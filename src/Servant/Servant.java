package Servant;

import GameScene.Game;
import GameScene.Screen;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public abstract class Servant extends Unit {
    protected Vector<Skill> SKI = new Vector<Skill>();
    protected int atk = 1;
    protected Point coordinate = new Point(0, 0);
    public Game world = null;
    public final static int pace = 10;
    public void addSkill(Skill s) {
        SKI.add(s);
        SKI.sort(new Comparator<Skill>() {
            @Override
            public int compare(Skill left, Skill right) {
                return -1 * (left.cd - right.cd);
            }
        });
    }

    Vector<Unit> target = null;
    public void slice() {//Vector<Unit> target
        for (Skill s : SKI) {
            if(s.CD() && (target = world.getTarget(this,s)) != null){
                s.Act(this, target);
                return;
            }
        }
        //Nothing performed, just walk;
        //Walk
    }

    public Unit Generate(Screen s, Point p, Dimension d) {
        return null;
    }

    public void render(Graphics g) {
    }
}
