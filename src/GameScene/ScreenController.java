package GameScene;

import javax.swing.JFrame;

public class ScreenController {
    private JFrame mainScreen;
    public ScreenController(JFrame mainScreen){
        this.mainScreen = mainScreen;
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
        }
        //play game end scene
    }
}
