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
import java.awt.image.*;

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
        Image resized = img.getScaledInstance(Screen.width, Screen.height, Image.SCALE_SMOOTH);

        playerServants = player.Servants();
        LeftTower = (Tower) player.MyTower().Duplicate(this, new Point(leftBornPoint), true);
        RightTower = (Tower) player.MyTower().Duplicate(this, new Point(rightBornPoint), true);
        if (true) {// For testing
            this.addServant(new Ninja(new Point(leftBornPoint), true, this));
            this.addServant(new FemaleZombie(new Point(leftBornPoint), true, this));
            this.addServant(new MaleZombie(new Point(rightBornPoint), false, this));
        }

    }

    public void addUnit(Unit s) {
        if (s instanceof Servant) {
            this.addServant((Servant) s);
        }
    }

    private void addServant(Servant s) {
        if (s.Camp) {
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

        g.fillRect(-10, 0, Screen.width, Screen.height);
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
            BufferedImage image = new BufferedImage(Screen.width, Screen.height, BufferedImage.TYPE_INT_RGB);
            TimeSlice(image.createGraphics());
            sharedScreen.getGraphics().drawImage(image, 0, 0, null);
            sharedScreen.validate();
            sharedScreen.repaint();
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

    // public void debug() {
    // }
    // protected class BattlePane extends JPanel{
    // @Override
    // public void repaint(){
    // System.out.print("Repaint\n");
    // }
    // @Override
    // public void paint(Graphics g){
    // System.out.print("Paint\n");
    // }

    // @Override
    // public void paintComponent(Graphics g) {
    // System.out.print("PaintComponent\n");
    // }

    // @Override
    // public void update(Graphics g) {
    // System.out.print("Update\n");
    // }
    // }

    // protected class BattleFrame extends JFrame {
    // @Override
    // public void repaint() {
    // System.out.print("Repaint\n");
    // }

    // @Override
    // public void paint(Graphics g) {
    // TimeSlice(g);
    // System.out.print("Paint\n");
    // }

    // @Override
    // public void update(Graphics g) {
    // System.out.print("Update\n");
    // }
    // }

    // @Override
    // public void run() {
    // BattleFrame test = new BattleFrame();
    // test.add(new BattlePane());
    // while (true) {
    // test.validate();
    // test.repaint();
    // System.out.print("Tick\n");
    // try {
    // Thread.sleep(100);
    // debug();
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }
    // }
}