package Servant;

import Player.*;
import GameScene.Screen;
import java.awt.*;
import javax.swing.*;
public class Tower extends Unit{
    public Tower(){
    }
    public int setHP(int hp){
        this.hp = hp;
        return this.hp;
    }
    public int setDef(int def){
        this.def = def;
        return this.def;
    }
    public Unit Generate(Screen s,Point p,Dimension d){return null;}
    public void render(Graphics g){}
} 