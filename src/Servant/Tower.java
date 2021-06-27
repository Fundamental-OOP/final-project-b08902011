package Servant;

import Player.*;
import GameScene.Screen;
import java.awt.*;
import javax.swing.*;
public class Tower extends Unit{
    public Tower(){
        this.atk = 0;
        this.attack_range = 0;
        this.n_target = 0;
    }
    public int setHP(int hp){
        this.hp = hp;
        return this.hp;
    }
    public int setDef(int def){
        this.def = def;
        return this.def;
    }
    public void Generate(Screen s,Point p,Dimension d){}
    public void render(Graphics g){}
} 