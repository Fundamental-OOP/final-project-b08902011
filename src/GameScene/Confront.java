package GameScene;

import javax.swing.JFrame;

import Player.Player;

import java.util.*;
import java.awt.image.*;
import java.io.*;
import Unit.Servant.*;
import javax.imageio.*;
import Unit.Servant.CowGirl.*;
import Unit.Servant.MaleZombie.*;
import Unit.Servant.Ninja.*;
import java.awt.*;
import javax.swing.*;
import BasicObject.*;

public class Confront extends Screen {
    private static Vector<BufferedImage> Scene = new Vector<BufferedImage>();
    private static Vector<Servant> Partner = new Vector<Servant>();
    static {
        for (int i = 1; i <= 3; i++) {
            try {
                Scene.add(ImageIO.read(new File("Assets/scene" + String.valueOf(i) + ".jpg")));
            } catch (Exception e) {
                System.out.println("No image!");
            }
        }
        Partner.add(new CowGirl(new Point(0, 0), true, null));
        Partner.add(new Ninja(new Point(0, 0), true, null));
        Partner.add(new MaleZombie(new Point(0, 0), true, null));
    }
    private static int counter = 0;

    public Confront(JFrame sharedScreen, Player player) {
        super(sharedScreen);
        if (counter < Scene.size()) {
            layeredPane.setLayout(null);
            Image resized = Scene.get(counter).getScaledInstance(Screen.width, Screen.height, Image.SCALE_SMOOTH);
            // resized.getGraphics().drawImage(Partner.get(counter).toImage(), 1000, 600, 200, 200, null);
            ImageIcon image = new ImageIcon(resized);
            JLabel imgLabel = new JLabel(image);
            imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
            layeredPane.add(imgLabel, 0);
            JButton b = MyButton.exitButton("Back", new Point(10, 50), new Dimension(100, 100), this);
            layeredPane.add(b, 0);
            layeredPane.moveToFront(b);
            screen.setContentPane(layeredPane);
            player.addMember(Partner.get(counter));
        }
        counter++;
    }

}
