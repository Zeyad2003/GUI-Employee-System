
package finalproject;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.*;




public class insertNew extends JFrame implements ActionListener{
JFrame f1;
     JButton Btn ,Btn1;
     JTextField f_name,id,pass,n_id,phone,gender,add,DOB,pos,sala,boun;
     JLabel labName,labId,labPass,labNId,labPhone,labGender,labAdd,labDOB,labPos,labSal,labBonus;
     JRadioButton r1 , r2;
     ButtonGroup g1;
    String arr[];
     JComboBox b1;
     //-----DB----
    static Connection c;
    static Statement s;
    static String query;
    static ResultSet r;
     
   
    
     public insertNew(){
      //------frame componant------
     f1=new JFrame();
     labName=new JLabel("Emp_Name");
     f_name=new JTextField();
     labId=new JLabel("ID");
     id=new JTextField();
     labPass=new JLabel("Password");
     pass=new JTextField();
     labNId=new JLabel("National_Id");
     n_id=new JTextField();
     labPhone=new JLabel("Phone");
     phone=new JTextField();
     labGender=new JLabel("gender");
     r1= new JRadioButton("female");
     r2= new JRadioButton("male");
     g1 =new ButtonGroup();
     String arr[]={" ","Admin","Employee","Worker","Trainee"};
     
     labAdd=new JLabel("Address");
     add=new JTextField();
     labDOB=new JLabel("DOB");
     DOB=new JTextField();
     labPos=new JLabel("Position");
      b1=new JComboBox(arr);
      b1.setEditable(true);
     labSal=new JLabel("Salary");
     sala=new JTextField();
     labBonus=new JLabel("Bouns");
     boun=new JTextField();
     //--------------fram-------
       this.setTitle("Insert new employee ");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setResizable(false);
       this.setSize(500,400);
       this.setLocation(650,400);
       this.setLayout(null);// 1-->row 2--->columns
    //----------------add com..----------------------------------
    labName.setBounds(25, 30,100,20);
      f_name.setBounds(110,32,110,20);
       add (labName);
       add(f_name);
       labId.setBounds(265, 30 , 100, 20);
       id.setBounds(340, 32, 110, 20);
       add(labId);
       add(id);
       //--------------------------------------------------------------------
       labNId.setBounds(25,80,100,20);
       n_id.setBounds(110,85,110 ,20);
       add(labNId);
       add(n_id);
       labPass.setBounds(265,80,100,20);
       pass.setBounds(340, 82, 110, 20);
       add(labPass);
       add(pass);
      //-------------------------------------------------------------------
       labGender.setBounds(25,130,100,20);
        r1.setBounds(110,132,110 ,20);
        r2.setBounds(110 ,150,110,20);
       add(labGender);
       g1.add(r1);
       g1.add(r2);
       r1.setActionCommand("female");
       r2.setActionCommand("male");  // without will be insert null
       add(r1);
       add(r2);
      // add(gender);
       labPhone.setBounds(265,130,100,20);
       phone.setBounds(340, 132, 110, 20);
       add(labPhone);
       add(phone);
     //-------------------------------------------------------
       labDOB.setBounds(25,180,100,20);
       DOB.setBounds(110,182,110 ,20);
       add(labDOB);
       add(DOB);
       labPos.setBounds(265,180,100,20);
       b1.setBounds(340, 182, 110, 20);
       add(labPos);
       add(b1);
       
     //----------------------------------------------------------
       labSal.setBounds(25,230,100,20);
       sala.setBounds(110, 232, 110, 20);
       add(labSal);
       add(sala);
       labBonus.setBounds(265,230,100,20);
       boun.setBounds(340, 232, 110, 20);
       add(labBonus);
       add(boun);
       
       //--------------------------------------------------------
       labAdd.setBounds(25, 280, 100, 20);
       add.setBounds(110, 282, 110, 20);
       add(labAdd);
       add(add);
       //---------------------------------------------------------------
     Btn=new JButton("Add");
     Btn.setBounds(205, 325, 100, 25);
     add(Btn);
     Btn.addActionListener(this);
     
     Btn1 = new JButton("Back");
     Btn1.setBounds(50,325,100,25);
     add(Btn1);
     
     Btn1.addActionListener(this);
    
     }
     
    
     
     
     public void Add(){
          connection x=new connection();
 
            try{
             c=x.connect();
             
           query="INSERT INTO employees set Name='"+f_name.getText()+"',ID='"+id.getText()+"',Password='"+pass.getText()+"',National_ID='"+n_id.getText()+"',Phone='"+phone.getText()+
                    "',gender='"+g1.getSelection().getActionCommand()+"',Address='"+add.getText()+"',DateOfBirth='"+DOB.getText()+"',"
                    + "Position='"+b1.getSelectedItem().toString()+"',Salary='"+sala.getText()+"',Bonus='"+boun.getText()+"'";
            s=c.createStatement();
               s.executeUpdate(query);
                System.out.println("Done");
            }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            } // to close what is opened to make the DB more secure
           finally{
            try{
                c.close();
                s.close();
            }catch(SQLException r){
                System.out.println(r.getMessage());
            }
        }
     }
     @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Btn){
          if(f_name.getText().equals("")||f_name.getText()==null||
                id.getText().equals("")||id.getText()==null||
                pass.getText().equals("")||pass.getText()==null||
                n_id.getText().equals("")||n_id.getText()==null||
                phone.getText().equals("")||phone.getText()==null||
                g1.isSelected(null)||
               
                add.getText().equals("")||add.getText()==null||
                DOB.getText().equals("")||DOB.getText()==null||
                boun.getText().equals("")||boun.getText()==null||
                sala.getText().equals("")||sala.getText()==null||
                  b1.getSelectedItem()==" "
                  ){
              JOptionPane.showMessageDialog(null, "All fields must be filled","Error",0);}
               
          else{
              Add();
              Added y=new Added();
              f_name.setText(null);
              id.setText(null);
              pass.setText(null);
              n_id.setText(null);
              phone.setText(null);
              g1.clearSelection();
              add.setText(null);
              DOB.setText(null);
           
             b1.setSelectedItem(" ");
              sala.setText(null);
              boun.setText(null); 
          }
        }
        if(ae.getSource()==Btn1){
            this.dispose();
        }
    }
}
    
    


