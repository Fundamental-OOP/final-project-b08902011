import javax.swing.*;
import java.awt.*;

import BasicObject.*;
import GameScene.*;
import Player.*;
import Servant.*;

public class Main {
    public static void main(String[] args) {
        Screen currentScreen = new Screen();
        Player player = new Player();
        Game level1 = new Game();
        Map map = new Map(currentScreen, level1);
        HomePage menu = new HomePage(player, currentScreen, map);
        currentScreen.setContent(menu.getScreen());
    }
}