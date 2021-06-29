import javax.swing.*;
import java.awt.*;
import java.util.*;
import BasicObject.*;
import GameScene.*;
import Player.*;

public class Main {
    public static void main(String[] args) {
        JFrame monitor = new JFrame();
        monitor.getContentPane().setLayout(null);
        monitor.setBounds(-10, 0, 1555, 833);
        monitor.setVisible(true);
        monitor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Player player = new Player();
        Game level1 = new Game(monitor,player);
        Game level2 = new Game(monitor,player);
        Game level3 = new Game(monitor,player);
        java.util.List<Screen> levels = new ArrayList<>();
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);

        Shop shop1 = new Shop(monitor);
        levels.add(shop1);
        
        GameScene.Map map = new GameScene.Map(monitor, levels);
        HomePage menu = new HomePage(monitor, player, map);
        menu.setContent();
    }
}