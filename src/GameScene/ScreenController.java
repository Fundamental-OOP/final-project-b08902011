package GameScene;

import javax.swing.JFrame;
// import java.awt.Component.*;
import java.awt.event.*;
public class ScreenController {
    private JFrame mainScreen;
    public ScreenController(JFrame mainScreen){
        this.mainScreen = mainScreen;
    }
    public void start(){
        HomePage menu = new HomePage(mainScreen);
        menu.run();
        Map gameMap = new Map(mainScreen);
        while(!gameMap.GameOver()){
            gameMap.run();
            Screen nextScreen = gameMap.nextScreen;
            nextScreen.run();
        }
        End endScene = new End(mainScreen);
        endScene.run();
        mainScreen.dispatchEvent(new WindowEvent(mainScreen, WindowEvent.WINDOW_CLOSING));
    }
}
