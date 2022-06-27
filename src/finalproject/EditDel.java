
package finalproject;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
   

public class EditDel extends JFrame implements ActionListener{
    private  String id;

    public String getId() {
        return id;
    }

    
    JFrame frame;
    JLabel l = new JLabel("ID: ");
    JTextField text = new JTextField();
    JButton button = new JButton("Edit");
    JButton button2 = new JButton("Delete");
    JButton Back = new JButton("Back");
    JTable table ;
    JScrollPane js;
    String[] columns = {"Name","ID"};
    String [][]data;
    ArrayList <Employee> list = new ArrayList ();
    static Connection c;
    static Statement s;
    static String query;
    static ResultSet r;
     
    public EditDel(){
       
    }
    public void showData(){
        frame =new JFrame();
       this.setTitle("Search for Id");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setResizable(false);
       this.setSize(700,650);
       this.setLocation(700,220);
       this.setLayout(null);
       l.setBounds(90, 40, 50, 30);
       l.setFont(new Font("", Font.ITALIC, 20));
       add(l);
       text.setBounds(140, 40, 190, 30);
       add(text);
       button.setBounds(390, 40, 100, 30);
       add(button);
       button2.setBounds(500, 40, 100, 30);
       add(button2);
       button.addActionListener(this);
       button2.addActionListener(this);
       
       Back.setBounds(70, 560, 100, 30);
       add(Back);
       Back.addActionListener(this);
       TableData();
    }
    public void TableData(){
        connection c1 = new connection();        
        try{
            c=c1.connect();
            s=c.createStatement();
            query="select * from employees";
            r=s.executeQuery(query);
           
            while(r.next()){
                Employee e = new Employee(r.getString("ID"),r.getString("Name"));
                list.add(e);
            }
            data = new String[list.size()][2];
            for(int i=0; i<list.size(); i++){
                data[i][1]=""+ list.get(i).getId();
                data[i][0]=""+ list.get(i).getName();
            }
            table = new JTable(data,columns);
            js = new JScrollPane(table);
            js.setBounds(25,100,650,445);
            this.add(js);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            try{
                c.close();
                s.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==button){
            if(text.getText().equals("")||text.getText()==null){
                JOptionPane.showMessageDialog(null, "Please enter all Fields","Error",0);
            }
            else{
                this.id = text.getText();
                updateEmp u = new updateEmp(Integer.parseInt(this.id));
                u.setID(id);
            }
        }
        if(ae.getSource()==button2){
           if(text.getText().equals("")||text.getText()==null){
                JOptionPane.showMessageDialog(null, "Please enter all Fields","Error",0);
            }
            else{
                this.id = text.getText();
                ConfirmDel c = new ConfirmDel();
                c.setID(id);
               // System.out.println("id1 : "+id);
            }   
        }
        if(ae.getSource()==Back){
           this.dispose();
        }
    }
    
}