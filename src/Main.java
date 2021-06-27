import javax.swing.*;
import java.awt.*;

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
        currentScreen.setContent(menu.getScreen());
    }
}