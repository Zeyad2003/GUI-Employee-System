
package finalproject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class ConfirmDel extends JFrame implements ActionListener{
    JFrame frame ;
    JLabel l2;
    JButton b1;
    JButton b2;
    static Connection c;
     static PreparedStatement s;
     static String query;
    
    private String ID;
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
     
     
     
    public ConfirmDel(){
        frame =new JFrame();
        l2=new JLabel("Are you sure ?");
        b1=new JButton("Yes");
        b2=new JButton("No");
        
      //  System.out.println("id : "+getID());
        
       this.setTitle("Confirm process");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setResizable(false);
       this.setSize(350,240);
       this.setLocation(880,450);
       this.setLayout(null);
       l2.setBounds(100, 50, 200, 30);
       l2.setFont(new Font("", Font.ITALIC, 20));
       b1.setBounds(70,120,60,30);
       b2.setBounds(210,120,60,30); 
       add(l2);
       add(b1);
       add(b2); 
       b1.addActionListener(this);
       b2.addActionListener(this);
    }
    public void delete(){
        connection c1 = new connection(); 
        
        try{
            
            c=c1.connect();
           
            query="delete from employees where id = ?";
            s=c.prepareStatement(query);
            s.setString(1,getID());
            s.execute();
            
            System.out.println("Done");
            
            
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
        if(ae.getSource()==b1){
            delete();
            DoneDel dd= new DoneDel();
            this.dispose();
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
            this.dispose();
        }
    }
    
}