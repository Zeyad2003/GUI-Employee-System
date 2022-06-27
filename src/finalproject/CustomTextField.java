package finalproject;
import java.awt.*;

import javax.swing.*;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CustomTextField extends JTextField implements FocusListener {
    boolean f; // true if focused on this field and false otherwise
    String  t; // text in this field before it was focused
    CustomTextField(String t){
        f=false;
        this.t=t;
        this.setForeground(new Color(160,160,160)); //gray
        this.setText(t);
        this.addFocusListener(this);
    }
    // enter the text field
    @Override
    public void focusGained(FocusEvent e) {
        if (!f) { // not edit anything
            this.setForeground(new Color(0, 0, 0)); // black
            this.setText("");
        }
    }

    // leave the text field
    // handle the case when the text field is empty
    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().equals("")) {
            this.setForeground(new Color(160, 160, 160)); // gray
            this.setText(t);  // set the default text t
            f = false; // means show default text from database
        } else {
            f = true; // user edit the text field
        }
    }
}