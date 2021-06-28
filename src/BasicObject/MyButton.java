package BasicObject;

import Player.*;
import Unit.*;
import GameScene.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyButton{
    public static JButton make(String text, Point p, Dimension d, Screen nextScreen){//Map 
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert(e.getSource().equals(this));
                nextScreen.setContent();
            }
        });
        return b;
    }

    public static JButton make(String text, Point p, Dimension d, Player person, Item item, int price) {// Shop
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert (e.getSource().equals(this));
                if (person.getGold() > price) {
                    person.spent(price);
                    person.addItem(item);
                    ((JButton) e.getSource()).setText("Sold!");
                } else {
                    ((JButton) e.getSource()).setText("Not Enough!");
                }
            }
        });
        return b;
    }

    public static JButton make(String text, Point p, Dimension d, Game game, Unit s) {// Battle
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert (e.getSource().equals(this));
                game.addUnit(s, new Point(0, 0), new Dimension(0, 0), true);
            }
        });
        return b;
    }

    public static JButton make(String text, Point p, Dimension d, Player player, int level, Screen nextScreen){//Menu
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert (e.getSource().equals(this));
                player.setLevel(level);
                nextScreen.setContent();
            }
        });
        return b;
    }
}