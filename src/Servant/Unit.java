package Servant;

import GameScene.Screen;
import java.awt.*;
import javax.swing.*;

public abstract class Unit {
    protected int hp = 1;
    protected int atk = 1;
    protected int def = 1;
    protected int attack_range = 1;// Pixel
    protected int n_target = 1;
    
    abstract public void Generate(Screen s, Point p, Dimension d);

    abstract public void render(Graphics g);
}
