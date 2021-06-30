import javax.sql.rowset.serial.SerialRef;
import javax.swing.*;

import BasicObject.MyButton;

import java.util.*;
import GameScene.*;
import Player.*;
import GameScene.Map;

public class Main {
    public static void main(String[] args) {
        JFrame monitor = new JFrame();
        monitor.getContentPane().setLayout(null);
        monitor.setBounds(-10, 0, Screen.width, Screen.height);
        monitor.setVisible(true);
        monitor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Player player = new Player();
        MyButton.Init(monitor, player);
        HomePage menu = new HomePage(monitor);
        menu.start();
    }
}