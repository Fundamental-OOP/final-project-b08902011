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

    public static JButton makeShop(String text, Point p, Dimension d) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assert (e.getSource().equals(this));
                Shop shop = new Shop(sharedScreen, player);
                shop.start();
                synchronized (shop) {
                    try {
                        shop.join();
                    } catch (InterruptedException err) {
                        System.out.print("InterruptedException in MyButton.makeGame");
                    } finally {
                        System.out.print("Leave Shop\n");
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
                    } finally {
                        System.out.print("Leave Game\n");
                        Map map = new Map(sharedScreen);
                        map.start();
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
                        map.join();

                    } catch (InterruptedException err) {
                        System.out.print("InterruptedException in MyButton.makeMap");
                    } finally {
                        System.out.print("Leave Map\n");
                    }
                }
            }
        });
        b.setBackground(Color.RED);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(true);
        b.setFont(new Font("DialogInput", Font.PLAIN, 42));
        b.setForeground(Color.green);
        return b;
    }

    public static JButton makeShopButton(String text, Point p, Dimension d, Item item) {// Shop
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
                    Shop.nAvalible--;
                    if(Shop.nAvalible == 0){
                        Shop.nAvalible = 6;
                    }
                    Shop shop = new Shop(sharedScreen, player);
                    shop.start();
                    synchronized (shop) {
                        try {
                            shop.join();
                        } catch (InterruptedException err) {
                            System.out.print("InterruptedException in MyButton.makeGame");
                        } finally {
                            System.out.print("Leave Shop\n");
                        }
                    }
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
                assert (e.getSource().equals(this));
                // TODO
            }
        });
        return b;
    }
}
