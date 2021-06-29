package GameScene;

import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import Player.Player;
import Unit.*;
import Unit.Tower.*;
import Unit.Servant.*;
import Unit.Servant.Skills.*;
import Unit.Servant.BasicServant.*;

public class Game extends Screen implements Runnable {
    Vector<Servant> Left = new Vector<Servant>();// Camp == true
    Vector<Servant> Right = new Vector<Servant>();
    Tower LeftTower = null;
    Tower RightTower = null;
    Point leftBornPoint = new Point(0, 0);
    Point rightBornPoint = new Point(0, 0);

    public Game(JFrame sharedScreen, Player player) {
        super(sharedScreen);
        Left = player.Servants();
        LeftTower = (Tower) player.MyTower().Duplicate(this, new Point(leftBornPoint), true);
        RightTower = (Tower) player.MyTower().Duplicate(this, new Point(leftBornPoint), true);
        // Draw bottom, tower, background
        screen.add(new JButton("1"));
    }

    public void addUnit(Unit s, Point p, Dimension d, boolean Camp) {
        if (s instanceof Servant) {
            this.addServant((Servant) s, p, d, Camp);
        }
    }

    private void addServant(Servant s, Point p, Dimension d, boolean Camp) {
        if (Camp) {
            Left.add(s);
            // Draw s facing right
        } else {
            Right.add(s);
            // Dra s facing left
        }
    }

    public int TimeSlice(Graphics g) {// a slice in game
        Left.get(0).slice(g);
        // for (int i = 0; i < Left.size(); i++) {
        //     Left.get(i).slice(g);
        // }
        // for (int i = 0; i < Right.size(); i++) {
        //     Right.get(i).slice(g);
        // }
        // if (LeftTower.dead()) {
        //     return -1;
        // } else if (RightTower.dead()) {
        //     return 1;
        // }
        // LeftTower.render(g);
        // RightTower.render(g);
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
        Left.add(new BasicServant());
        screen.setVisible(true);
        // Gamepanel gp = new Gamepanel();
        
        // screen.add(gp);
        sharedScreen.setContentPane(screen.getContentPane());
        sharedScreen.validate();
        sharedScreen.repaint();
        while (true) {
            // TimeSlice(sharedScreen.getGraphics());
            // sharedScreen.revalidate();
            // sharedScreen.repaint();

            try {
                System.out.print("Tick\n");
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
        // sharedScreen.add(Gamepanel);
    }
}