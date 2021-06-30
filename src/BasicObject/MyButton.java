package BasicObject;

import Player.*;
import GameScene.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyButton {
    public static void Init(JFrame s, Player p) {
        MyButton.sharedScreen = s;
        MyButton.player = p;
    }

    private static JFrame sharedScreen = null;
    private static Player player = null;

    public static JButton make(String text, Point p, Dimension d, Screen nextScreen) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert (e.getSource().equals(this));
                nextScreen.setContent();
            }
        });
        return b;
    }

    public static JButton makeGame(String text, Point p, Dimension d) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert (e.getSource().equals(this));
                Game game = new Game(sharedScreen, player);
                game.start();
                synchronized (game) {
                    try {
                        game.wait();

                    } catch (InterruptedException err) {
                        System.out.print("InterruptedException in MyButton.makeGame");
                    }
                }
            }
        });
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(false);
        b.setFont(new Font("Dialog", Font.BOLD, 20));
        b.setForeground(Color.white);
        return b;
    }

    public static JButton makeMap(String text, Point p, Dimension d, int hardness) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert (e.getSource().equals(this));
                player.setHardness(hardness);
                Map map = new Map(sharedScreen);
                map.start();
                synchronized (map) {
                    try {
                        map.wait();

                    } catch (InterruptedException err) {
                        System.out.print("InterruptedException in MyButton.makeMap");
                    }
                }
            }
        });
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(false);
        b.setFont(new Font("DialogInput", Font.PLAIN, 42));
        b.setForeground(Color.BLACK);
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

    public static JButton make(String text, Point p, Dimension d, Player player, int level, Screen nextScreen) {// Menu
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