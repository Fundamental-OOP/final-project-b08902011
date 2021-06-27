package Servant;

import GameScene.Game;
import GameScene.Screen;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public abstract class Servant extends Unit {
    int clock = 0;
    protected Vector<Skill> SKI = new Vector<Skill>();
    protected int atk = 1;
    protected Point coordinate = new Point(0, 0);
    public Game world = null;

    public void addSkill(Skill s) {
        SKI.add(s);
        SKI.sort(new Comparator<Skill>() {
            @Override
            public int compare(Skill left, Skill right) {
                return -1 * (left.CD() - right.CD());
            }
        });
    }

    Vector<Unit> target = null;
    public void slice() {//Vector<Unit> target
        this.clock += 1;//Is okay to overflow
        for (Skill s : SKI) {
            if(this.clock % s.CD() == 0 && (target = world.getTarget(this,s)) != null){
                
                break;
            }
        }
    }

    public Unit Generate(Screen s, Point p, Dimension d) {
        return null;
    }

    public void render(Graphics g) {
    }
}
