
package finalproject;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class ShowData extends javax.swing.JFrame implements ActionListener {

    JFrame frame;
    JLabel l1;
    JTable table ;
    JScrollPane js;
    String[] columns = {"Name", "ID","Password" , "National ID", "Phone", "Gender", "Address", "DOB", "Position", "Salary","bonus"};
    String [][]data;
     ArrayList <data> list = new ArrayList ();
     static Connection c;
     static Statement s;
     static String query;
     static ResultSet r;
        JButton Back = new JButton("Back");

    ShowData() {
        frame =new JFrame();
       this.setTitle("CEmployees Data");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setResizable(false);
       this.setSize(950,500);
       this.setLocation(700,220);
       this.setLayout(null);
       
       Back.setBounds(50, 420, 100, 30);
       add(Back);
       Back.addActionListener(this);
       
       show_table();
    }
    public void show_table()
    {
       
    connection c1 = new connection();
        try{
          
            c=c1.connect();
            s=c.createStatement();
            query="select * from employees";
            r=s.executeQuery(query);
            while(r.next())
            {
                data u1= new data (r.getString("Name"),r.getString("ID"),r.getString("Password"),r.getString("National_ID"),r.getString("Phone"),
                        r.getNString("gender"),r.getString("Address"),r.getString("DateOfBirth"),r.getString("Position"),r.getString("Salary"),r.getString("Bonus"));
                list.add(u1);
            }
           
            data = new String[list.size()][12];
            for(int i=0; i<list.size(); i++){
                data[i][0]=""+ list.get(i).getName();
                data[i][1]=""+ list.get(i).getId();
                data[i][2]=""+ list.get(i).getPAS();
                data[i][3]=""+ list.get(i).getNat();
                data[i][4]=""+ list.get(i).getPhone();
                data[i][5]=""+ list.get(i).getGender();
                data[i][6]=""+ list.get(i).getAddress();
                data[i][7]=""+ list.get(i).getDob();
                data[i][8]=""+ list.get(i).getPos();
                data[i][9]=""+ list.get(i).getSal();
                data[i][10]=""+ list.get(i).getBon();
                
                
            }
            
            table = new JTable(data,columns);
            js = new JScrollPane(table);
            js.setBounds(0,0,945,400);
            this.add(js);
            
            }
        catch(SQLException e){
                System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Back){
           this.dispose();
        }
            
    }
    
}