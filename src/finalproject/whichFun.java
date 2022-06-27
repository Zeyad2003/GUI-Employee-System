
package finalproject;


import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class whichFun extends JFrame implements ActionListener{

    JFrame frame ;
    JButton insertButton ;
    JButton showemployeeButton ;
    JButton EditeButton ;
    
    public whichFun() {
        /**********frame********/
        frame = new JFrame();
        insertButton =new JButton("insert");
        showemployeeButton =new JButton("Show employees data");
        EditeButton =new JButton("Edite & Delete");
        
        this.setVisible(true);
        this.setTitle("Which Fun ?");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        this.setResizable(false);//
        this.setSize(300, 300);
        this.setLocation(400,300);
        this .setLayout(null);
        this.setVisible(true);
        insertButton.setBounds(100,50,100,30);
       showemployeeButton.setBounds(60,120,180,30);
        EditeButton.setBounds(90,180,120,30);
        /****************buttons**************/
      //  frame.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
        add(insertButton);
        add(showemployeeButton);
        add(EditeButton);
        insertButton.addActionListener(this);
        EditeButton.addActionListener(this);
        showemployeeButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==insertButton){
            insertNew c = new insertNew();
        }
        else if(ae.getSource()==showemployeeButton){
            ShowData s =new ShowData();
        }
        else if(ae.getSource()==EditeButton){
            EditDel e = new EditDel();
            e.showData();
        }
    }


   
}
