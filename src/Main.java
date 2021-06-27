import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

import BasicObject.*;
import GameScene.*;
import Player.*;
import Servant.*;

public class Main {
    public static void main(String[] args) {  	
        Player player = new Player();       
        Map map = new Map();
        Screen currentScreen = new Screen();
        HomePage menu = new HomePage(player, currentScreen, map);
    }
}