
package finalproject;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    JFrame frame;
    JButton btn = new JButton("Login") ;
    JLabel idLab = new JLabel("ID") ,
           passLab = new JLabel("Password"),
           position = new JLabel("Position:");
    JRadioButton r1 = new JRadioButton("employee") ,
                r2 = new JRadioButton("admin");
    ButtonGroup g1=new ButtonGroup();
    
    JTextField idTxt= new JTextField() ,
               passTxt = new JPasswordField();
    
    static Connection connection;
    static Statement statement;
    static String query;
    static ResultSet r;
    public Login(){
        frame=new JFrame();
        this.setTitle("Login");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 300);
        this.setLocation(700,350);
        this.setLayout(null);
        ///////////////////////
        idLab.setBounds(20, 20, 70, 30);
        add(idLab);
        passLab.setBounds(20, 70, 70, 30);
        add(passLab);
        /////////////////////////
        idTxt.setBounds(100, 25, 120, 25);
        add(idTxt);
        passTxt.setBounds(100, 75, 120, 25);
        add(passTxt);
        ////////////////////////
        position.setBounds(20, 120, 100, 40);
         add(position);
        r1.setBounds(130,120,140,20);
        r2.setBounds(130, 150, 110, 20);
        r1.setActionCommand("employee");
        r2.setActionCommand("admin"); 
        g1.add(r1);
        g1.add(r2);
        add(r1);
        add(r2);
        
        btn.setBounds(110, 200, 110, 30);
        add(btn);
        btn.addActionListener(this);
        
    }
    String  id,pos;
    boolean found = false, correct = false, admin=false, checkChoice=false;
    public void check(){
        connection c1 = new connection();        
            id=idTxt.getText();
            try{
                connection=c1.connect();
                statement = connection.createStatement();
            query = "select * from employees where ID = " + id ;
            r = statement.executeQuery(query);
            while(r.next()){
                if(r.getString("ID").equalsIgnoreCase(idTxt.getText())){
                    if(r.getString("Password").equalsIgnoreCase(passTxt.getText())){
                       if( g1.getSelection().getActionCommand().equalsIgnoreCase("Admin")){
                           if(r.getString("Position").equalsIgnoreCase("Admin")){
                                checkChoice=true;
                                correct=true;
                                found=true;
                                admin=true;
                                break;
                            }
                            checkChoice=false;
                            correct=true;
                            found=true;
                            admin=true;
                            break;
                       }
                       if( g1.getSelection().getActionCommand().equalsIgnoreCase("Employee")){
                           if(!(r.getString("Position").equalsIgnoreCase("Admin"))){
                                checkChoice=true;
                                correct=true;
                                found=true;
                                break;
                            }
                            checkChoice=false;
                            correct=true;
                            found=true;
                            break;
                       }
                        correct=true;
                        found=true;
                        admin=false;
                        break;
                    }
                    correct=false;
                    found=true;
                }
            }
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btn){
            if(idTxt.getText().equals("")||idTxt.getText()==null||
                    passTxt.getText().equals("")||passTxt.getText()==null||
                    g1.isSelected(null))
            {
                JOptionPane.showMessageDialog(null, "All fields must be filled","Error",0);
            }
            else{
                check();
            if(found){
                if(correct){
                    if(checkChoice){
                        if(!admin){
                            ShowEmpData s = new ShowEmpData();
                            s.setId(idTxt.getText());
                            s.showData();
                            this.dispose();
                        }
                        else{
                            whichFun w = new whichFun();
                            this.dispose();
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Your choice is not correct","Error",0);
                        checkChoice=false;
                        correct=false;
                        found=false;
                        admin=false;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password not correct","Error",0);
                    checkChoice=false;
                    correct=false;
                    found=false;
                    admin=false;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "User not Found","Error",0);
                checkChoice=false;
                correct=false;
                found=false;
                admin=false;
            }
            }
        }
    }
}

