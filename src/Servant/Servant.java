package Servant;
import GameScene.Screen;
import java.awt.*;
import javax.swing.*;
public abstract class Servant extends Unit{
    int mp = 0;
    protected Skill SKI = null;
    public Servant(Servant tmp){

    }
    public void Generate(Screen s){}
    public void render(Graphics g){
    }
}
