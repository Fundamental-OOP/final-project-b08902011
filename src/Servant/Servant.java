package Servant;

import GameScene.Game;
import GameScene.Screen;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public abstract class Servant extends Unit {
    protected Vector<Skill> SKI = new Vector<Skill>();
    protected Point coordinate = new Point(0, 0);
    protected int walkCycle = 10;
    protected int walkCount = 0;
    protected int attackCycle = 10;
    protected int attackCount = 0;
    protected int atk = 1;
    protected NormalAttack normalAttack = null;
    public Game world = null;

    public void addSkill(Skill s) {
        SKI.add(s);
        SKI.sort(new Comparator<Skill>() {
            @Override
            public int compare(Skill left, Skill right) {
                return -1 * (left.cd - right.cd);
            }
        });
    }

    public void slice() {// Vector<Unit> target
        Vector<Unit> target = null;
        for (Skill s : SKI) {
            if (s.CD() && (target = world.getTarget(this, s)) != null) {
                s.Act(this, target);
                return;
            }
        }
        if (attackCount == 0 && (target = world.getTarget(this, normalAttack)) != null) {
            attackCount++;
            normalAttack.Act(this, target);
        } else if (attackCount != 0) {
            attackCount++;
            attackCount %= attackCycle;
            walkCount = 0;
            // play attack graphs
        } else {
            walkCount++;
            walkCount %= walkCycle;
            attackCount = 0;

        }
    }

    protected abstract void drawWalk(int index);

    protected abstract void drawAttack(int index);

    protected abstract void drawDead();

    protected abstract void onDead();

    // public abstract void drawInit(); Same as render

    public int ATK() {
        return this.atk;
    }
}
