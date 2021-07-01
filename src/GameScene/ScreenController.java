package GameScene;

import javax.swing.JFrame;
import Player.Player;

public class ScreenController {
    private JFrame mainScreen;
    private Player player;
    public ScreenController(JFrame mainScreen,Player player){
        this.mainScreen = mainScreen;
        this.player = player;
    }
    public void start(){
        HomePage menu = new HomePage(mainScreen);
        menu.run();
        //Hardness set.
        Map gameMap = new Map(mainScreen);
        while(!gameMap.GameOver()){
            gameMap.run();
            Screen nextScreen = gameMap.nextScreen;
            nextScreen.run();
            System.out.print("GG\n");
        }
    }
}
