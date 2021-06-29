package GameScene;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import Player.Player;
import Unit.*;
import Unit.Tower.*;
import Unit.Servant.*;
import Unit.Servant.Skills.*;

public class Game extends Screen implements Runnable {
    Vector<Servant> Left = new Vector<Servant>();// Camp == true
    Vector<Servant> Right = new Vector<Servant>();
    Tower LeftTower = null;
    Tower RightTower = null;
    Point leftBornPoint = new Point(0, 0);
    Point rightBornPoint = new Point(800, 0);

    public Game(JFrame sharedScreen, Player player) {
        super(sharedScreen);
        Left = player.Servants();
        LeftTower = (Tower) player.MyTower().Duplicate(this, new Point(leftBornPoint), true);
        RightTower = (Tower) player.MyTower().Duplicate(this, new Point(leftBornPoint), true);
    }

    public void addUnit(Unit s, Point p, Dimension d, boolean Camp) {
        if (s instanceof Servant) {
            this.addServant((Servant) s, p, d, Camp);
        }
    }

    private void addServant(Servant s, Point p, Dimension d, boolean Camp) {
        if (Camp) {
            Left.add(s);
        } else {
            Right.add(s);
        }
    }

    public int TimeSlice(Graphics g) {// a slice in game
        g.setColor(Color.WHITE); // paint background with all white
        g.fillRect(-10, 0, 1555, 833);
        for (int i = 0; i < Left.size(); i++) {
            Left.get(i).slice(g);
        }
        for (int i = 0; i < Right.size(); i++) {
            Right.get(i).slice(g);
        }
        if (LeftTower.dead()) {
            return -1;
        } else if (RightTower.dead()) {
            return 1;
        }
        LeftTower.render(g);
        RightTower.render(g);
        return 0;
    }

    public Vector<Unit> getTarget(Servant s, Skill skill) {
        boolean Camp = s.Camp;
        boolean enemy = skill.toenemy;
        boolean ally = skill.toally;
        int nTarget = skill.nTarget;
        Vector<Unit> ret = new Vector<Unit>();
        if ((Camp && enemy) || (!Camp && ally)) {// Right to be selected
            for (Servant u : Right) {
                if (skill.reachable(s, u)) {
                    ret.add(u);
                    nTarget--;
                    if (nTarget == 0) {
                        return ret;
                    }
                }
            }
            ret.add(RightTower);
        }
        if ((!Camp && enemy) || (Camp && ally)) {
            for (Servant u : Left) {
                if (skill.reachable(s, u)) {
                    ret.add(u);
                    nTarget--;
                    if (nTarget == 0) {
                        return ret;
                    }
                }
            }
            ret.add(LeftTower);
        }
        return null;
    }

    @Override
    public void run() {
        while (true) {
            sharedScreen.revalidate();
            sharedScreen.repaint();
            TimeSlice(sharedScreen.getGraphics());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setContent() {
        sharedScreen.getContentPane().removeAll();
        sharedScreen.setContentPane(screen.getContentPane());
        sharedScreen.validate();
        sharedScreen.repaint();
        this.run();
    }
}