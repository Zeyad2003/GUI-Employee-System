
package finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ShowEmpData  extends JFrame implements ActionListener{
    JButton btn;
    JFrame frame;
    JLabel name = new JLabel("Name: "), 
    sal_label = new JLabel("Salary: "),
    bon_label = new JLabel("Bonus: "), 
    tot_label = new JLabel("Total Salary: ");
    TextField em_name = new TextField(),
    sal_text = new TextField(),
    bon_text = new TextField(), 
    tot_text = new TextField();
    
    private String id;
    
    static Connection c;
    static Statement s;
    static String query;
    static ResultSet r;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public ShowEmpData(){
        frame = new JFrame();
        this.setTitle("Employee Data");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(320, 300);
        this.setLocation(750,300);
        this.setLayout(null);
        ////////////////////////////////////////////
        name.setBounds(20, 30, 70, 25);
        add(name);
        em_name.setBounds(120, 30, 150, 25);
        add(em_name);
        // //////////////////////////////////////////// 
        sal_label.setBounds(20, 75, 80, 25);
        add(sal_label);
        sal_text.setBounds(120, 75, 150, 25);
        add(sal_text);
        //////////////////////////////////////////////
        bon_label.setBounds(20, 120, 80, 25);
        add(bon_label);
        bon_text.setBounds(120, 120, 150, 25);
        add(bon_text);
        //////////////////////////////////////////////
        tot_label.setBounds(20, 165, 80, 25);
        add(tot_label);
        tot_text.setBounds(120, 165, 150, 25);
        add(tot_text);
        ////////////////////////////////////////
        btn = new JButton("OK");
        btn.setBounds(115, 210, 80, 30);
        add(btn);
        btn.addActionListener(this);
        
        em_name.setEditable(false);
        sal_text.setEditable(false);
        bon_text.setEditable(false);
        tot_text.setEditable(false);
            
        
    }
    
    public void showData(){
     
        connection c1 = new connection();        
        try{
            c=c1.connect();
            s = c.createStatement();
            query = "select * from employees where ID = " + getId() ;
            r = s.executeQuery(query);
            r.next();
            int Sal = Integer.parseInt(r.getString("Salary"));
            int Bonus = Integer.parseInt(r.getString("Bonus"));
            int totalSal = Sal+Bonus;
            
            String t = Integer.toString(totalSal);
            em_name.setText(r.getString("Name"));
            sal_text.setText(r.getString("Salary"));
            bon_text.setText(r.getString("Bonus"));
            tot_text.setText(t);
            
            
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
        if(ae.getSource()==btn){
            this.dispose();
        }
    }
}


