import javax.swing.*;
import java.awt.*;

import BasicObject.*;
import GameScene.*;
import Player.*;

public class Main {
    public static void main(String[] args) {
        JFrame monitor = new JFrame();
        monitor.getContentPane().setLayout(null);
        monitor.setBounds(-10, 0, 1600, 900);
        monitor.setVisible(true);
        monitor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Player player = new Player();
        Game level1 = new Game(monitor);
        Map map = new Map(monitor, level1);
        HomePage menu = new HomePage(monitor, player, map);
        // monitor.setLayeredPane(menu.get().getLayeredPane());
        menu.setContent();

    }
}