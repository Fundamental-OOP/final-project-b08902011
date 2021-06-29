package GameScene;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import Player.Player;
import Unit.*;
import Unit.Tower.*;
import Unit.Servant.*;
import Unit.Servant.Skills.*;
import Unit.Servant.Ninja.*;
import Unit.Servant.FemaleZombie.*;
import Unit.Servant.MaleZombie.*;

public class Game extends Screen implements Runnable {
    Vector<Servant> playerServants = new Vector<Servant>();// Camp == true
    Vector<Servant> Left = new Vector<Servant>();// Camp == true
    Vector<Servant> Right = new Vector<Servant>();
    Tower LeftTower = null;
    Tower RightTower = null;
    Point leftBornPoint = new Point(0, 0);
    Point rightBornPoint = new Point(800, 0);

    public Game(JFrame sharedScreen, Player player) {
        super(sharedScreen);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Assets/battleField.png"));
        } catch (Exception e) {
            System.out.println("No image!");
        }
        Image resized = img.getScaledInstance(1555, 833, Image.SCALE_SMOOTH);
        
        playerServants = player.Servants();
        LeftTower = (Tower) player.MyTower().Duplicate(this, new Point(leftBornPoint), true);
        RightTower = (Tower) player.MyTower().Duplicate(this, new Point(rightBornPoint), true);
        if (true) {// For testing
            this.addServant(new Ninja(leftBornPoint,true,this));
            this.addServant(new FemaleZombie(leftBornPoint, true, this));
            this.addServant(new MaleZombie(rightBornPoint, false, this));
        }
        
    }

    public void addUnit(Unit s) {
        if (s instanceof Servant) {
            this.addServant((Servant) s);
        }
    }

    private void addServant(Servant s) {
        if (s.Camp) {
            debug();
            this.Left.add(s);
        } else {
            this.Right.add(s);
        }
    }

    public void removeServant(Servant s) {
        if (s.Camp) {
            this.Left.remove(s);
        } else {
            this.Right.remove(s);
        }
    }

    public int TimeSlice(Graphics g) {// a slice in game
        g.setColor(Color.BLACK); // paint background with all white

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
        return 0;
    }

    public Vector<Unit> getTarget(Servant s, Skill skill) {
        if (Left.size() == 0 || Right.size() == 0) {
            // return null;
        }
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
            if (skill.reachable(s, RightTower)) {
                ret.add(RightTower);

            }
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
            if (skill.reachable(s, LeftTower)) {
                ret.add(LeftTower);

            }
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
                debug();
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

    public void debug() {
        System.out.print(Left.size());
        System.out.print(" ");
        System.out.print(Right.size());
        System.out.print("\n");
    }
}