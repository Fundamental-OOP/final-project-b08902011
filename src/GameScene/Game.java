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
import Unit.Tower.BasicTower.BasicTower;
import Unit.Servant.*;
import Unit.Servant.Skills.*;
import Unit.Servant.Ninja.*;
import Unit.Servant.FemaleZombie.*;
import Unit.Servant.MaleZombie.*;
import Unit.Servant.CowGirl.*;
import BasicObject.*;

public class Game extends Screen {
    Vector<Servant> playerServants = new Vector<Servant>();// Camp == true
    Vector<Servant> Left = new Vector<Servant>();// Camp == true
    Vector<Servant> Right = new Vector<Servant>();
    Tower LeftTower = null;
    Tower RightTower = null;
    private static final Point leftBornPoint = new Point(0, 0);
    private static final Point rightBornPoint = new Point(1300, 0);
    Image background;

    private void setButtons(JLayeredPane layeredPane, Vector<Servant> playerServants) {
        int buttonWidth = 130, buttonHeight = 210, posX = 400, posY = 530;
        Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);
        for (int i = 0; i < playerServants.size(); i++) {
            JButton oneServant = MyButton.setServant("", new Point(posX + (buttonWidth + 100) * i, posY), buttonSize,
                    this, playerServants.get(i));
            BufferedImage img = playerServants.get(i).toImage();
            Image resized = img.getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
            oneServant.setIcon(new ImageIcon(resized));
            
            String str = playerServants.get(i).getClass().toString();
            String[] split = str.split("\\.");
            JLabel servantCost = new JLabel(split[2], JLabel.CENTER);
            servantCost.setBounds(posX + (buttonWidth + 100) * i, posY + 50, buttonWidth, 100);

            layeredPane.add(oneServant, 1);
            layeredPane.moveToFront(oneServant);
            layeredPane.add(servantCost, 1);
            layeredPane.moveToFront(servantCost);
        }
    }

    private void loadBackground() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Assets/battleField.png"));
        } catch (Exception e) {
            System.out.println("No image!");
        }
        Image resized = img.getScaledInstance(Screen.width, Screen.height, Image.SCALE_SMOOTH);
        background = resized;
    }

    public Game(JFrame sharedScreen, Player player) {
        super(sharedScreen);
        playerServants = player.Servants();
        if(true){
            playerServants = new Vector<Servant>();
            playerServants.add(new Ninja(new Point(leftBornPoint), true, this));
            playerServants.add(new MaleZombie(new Point(leftBornPoint), true, this));
            playerServants.add(new FemaleZombie(new Point(leftBornPoint), true, this));
            playerServants.add(new CowGirl(new Point(leftBornPoint), true, this));
        }
        LeftTower = (Tower) player.MyTower().Duplicate(this, new Point(leftBornPoint), true);
        RightTower = new BasicTower(new Point(rightBornPoint), true, this);
        if(true){
            this.addServant(new Ninja(new Point(leftBornPoint), false, this));
            this.addServant(new FemaleZombie(new Point(leftBornPoint), false, this));
            this.addServant(new MaleZombie(new Point(rightBornPoint), false, this));
            this.addServant(new CowGirl(new Point(rightBornPoint), false, this));
        }
        loadBackground();
    }

    public void addServant(Servant s) {
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
        if (LeftTower.dead()) {
            return -1;
        } else if (RightTower.dead()) {
            return 1;
        }
        g.drawImage(background, 0, 0, Screen.width, Screen.height, null);
        for (int i = 0; i < Left.size(); i++) {
            Left.get(i).slice(g);
        }
        for (int i = 0; i < Right.size(); i++) {
            Right.get(i).slice(g);
        }
        LeftTower.slice(g);
        RightTower.slice(g);
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
        return ret.size() == 0 ? null : ret;
    }

    @Override
    public void run() {
        this.running = true;
        int gameflag = 0;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (this.running) {
            BufferedImage image = new BufferedImage(Screen.width, Screen.height, BufferedImage.TYPE_INT_RGB);
            gameflag = TimeSlice(image.createGraphics());

            JLabel imgLabel = new JLabel(new ImageIcon(image));
            imgLabel.setBounds(0, 0, Screen.width, Screen.height);
            imgLabel.setVisible(true);
            JLayeredPane layeredPane = new JLayeredPane();
            layeredPane.add(imgLabel, 0);

            setButtons(layeredPane, playerServants);

            JLabel money = new JLabel("Money", JLabel.CENTER);
            money.setBounds(70, 570, 200, 200);
            money.setFont(new Font("Serif", Font.PLAIN, 40));
            layeredPane.add(money, 1);
            layeredPane.moveToFront(money);

            screen.setContentPane(layeredPane);
            sharedScreen.setContentPane(screen.getContentPane());
            sharedScreen.validate();
            sharedScreen.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (gameflag == 1) {
                System.out.print("Win");
                return;
            } else if (gameflag == -1) {
                System.out.print("Lose");
                return;
            }
        }
    }

    @Override
    public void end() {
        System.out.print("Calling end in game do nothing.");
    }
}