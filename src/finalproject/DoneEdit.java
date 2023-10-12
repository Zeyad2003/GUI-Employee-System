
package finalproject;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DoneEdit extends JFrame implements ActionListener{
    JFrame done ;
    JLabel l1;
    JButton btn1;
    public DoneEdit(){
       done =new JFrame();
        l1=new JLabel("Updated Successful : )");
        btn1= new JButton("OK");
        
       this.setTitle("Done");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setResizable(false);
       this.setSize(300,200);
       this.setLocation(1050,550);
       this.setLayout(null);
       l1.setBounds(70, 50, 170, 30);
       l1.setFont(new Font("Serif", Font.ITALIC, 20));
       add(l1);
       btn1.setBounds(110, 110, 70, 30);
       add(btn1);
       btn1.addActionListener(this);
     
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btn1){
            this.setVisible(false);
            this.dispose();

        }
    }
     
}