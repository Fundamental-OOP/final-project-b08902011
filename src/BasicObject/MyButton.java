package BasicObject;

import Player.*;
import GameScene.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Unit.Servant.*;

public class MyButton {
    public static void Init(JFrame s, Player p) {
        MyButton.sharedScreen = s;
        MyButton.player = p;
    }

    private static JFrame sharedScreen = null;
    private static Player player = null;

    public static JButton setShopButton(String text, Point p, Dimension d, Map self) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(false);
        b.setFont(new Font("Dialog", Font.BOLD, 20));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                self.nextScreen = new Shop(sharedScreen, player);
                self.end();
            }
        });
        return b;
    }

    public static JButton setGameButton(String text, Point p, Dimension d, Map self) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(false);
        b.setFont(new Font("Dialog", Font.BOLD, 20));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                self.nextScreen = new Game(sharedScreen, player);
                self.end();
            }
        });
        return b;
    }

    public static JButton exitButton(String text, Point p, Dimension d, Screen self) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setBackground(Color.RED);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(true);
        b.setFont(new Font("DialogInput", Font.PLAIN, 42));
        b.setForeground(Color.green);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                self.end();
            }
        });
        return b;
    }

    public static JButton setHardnessButton(String text, Point p, Dimension d, int hardness, Screen self) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setBackground(Color.RED);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(true);
        b.setFont(new Font("DialogInput", Font.PLAIN, 42));
        b.setForeground(Color.green);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.setHardness(hardness);
                if (self != null) {
                    self.end();
                }
            }
        });
        return b;
    }

    public static JButton buyItemButton(String text, Point p, Dimension d, Item item,Shop self) {// Shop
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (player.getGold() > item.getPrice() && !((JButton) e.getSource()).getText().equals("Sold!")) {
                    player.spent(item.getPrice());
                    player.addItem(item);
                    ((JButton) e.getSource()).setText("Sold!");
                    self.Buy();               
                } else {
                    ((JButton) e.getSource()).setText("Not Enough!");
                }
            }
        });
        return b;
    }

    public static JButton make(String text, Point p, Dimension d, Game game, Servant servant) {// Game
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(false);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.addServant((Servant)servant.Duplicate(game, new Point(0,0), true));
                System.out.print("Hi\n");
            }
        });
        return b;
    }
}
