package basic_object;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button{
    JButton b = null;
    public Button(String text,Point p,Dimension d,Screen_controller c,int to_screen){// map 
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert(e.getSource().equals(this));
                c.switch_screen(to_screen);
            }
        });
    }
    public Button(String text,Point p,Dimension d,Player person,Item item){//shop
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert(e.getSource().equals(this));
                if(person.gold)
            }
        });
    }
}