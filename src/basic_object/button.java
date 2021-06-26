package basic_object;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button{
    JButton b = null;
    public Button(String text,Point p,Dimension d,Screen_controller c,int to_screen){// map 
        this.b = new JButton(text);
        this.b.setLocation(p);
        this.b.setSize(d);
        this.b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert(e.getSource().equals(this));
                c.switch_screen(to_screen);
            }
        });
    }
    public Button(String text,Point p,Dimension d,Player person,Item item,int price){//shop
        this.b = new JButton(text);
        this.b.setLocation(p);
        this.b.setSize(d);
        this.b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert(e.getSource().equals(this));
                if(person.getGold() > price){
                    person.spent(price);
                    person.addItem(item);
                    ((JButton)e.getSource()).setText("Sold!");
                }
                else{
                    ((JButton)e.getSource()).setText("Not Enough!");
                }
            }
        });
    }
    public Button(String text,Point p,Dimension d,Game game,Servant s){//Battle
        this.b = new JButton(text);
        this.b.setLocation(p);
        this.b.setSize(d);
        this.b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert(e.getSource().equals(this));
                if(person.getGold() > price){
                    person.spent(price);
                    person.addItem(item);
                    ((JButton)e.getSource()).setText("Sold!");
                }
                else{
                    ((JButton)e.getSource()).setText("Not Enough!");
                }
            }
        });
    }
    public JButton jbutton(){
        return this.b;
    }
}