
package finalproject;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ConfirmEdit extends JFrame implements ActionListener{ 
   JFrame conf ;
    JLabel l2;
    JButton b1;
    JButton b2;
    public ConfirmEdit(){
        conf =new JFrame();
        l2=new JLabel("Are you sure ?");
        b1=new JButton("Yes");
        b2=new JButton("No");
        
       this.setTitle("Confirm process");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setResizable(false);
       this.setSize(350,240);
       this.setLocation(1000,550);
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            DoneEdit dd= new DoneEdit(); 
            this.dispose();
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
            this.dispose();
        }
    }
    
}
