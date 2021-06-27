package Servant;

import GameScene.Screen;
import java.awt.*;
import javax.swing.*;

public abstract class Unit {
    public boolean Camp = true;
    protected int hp = 1;
    protected int def = 1;
    public boolean dead(){
        return hp <= 0;
    }
    abstract public Unit Generate(Screen s, Point p, Dimension d);
    abstract public void render(Graphics g);
}
