package Unit.Servant.Ninja;

import Unit.*;
import GameScene.Game;
import Unit.Servant.Servant;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Ninja extends Servant {
    static int initHP = 500;
    static int initATK = 130;
    static int initDEF = 50;
    static BufferedImage Overview;
    static {
        try {
            Overview = ImageIO.read(new File("Assets/Servant/" + ServantName() + "/overview.png"));
        } catch (Exception e) {

        }
    }

    public Ninja(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new NinjaState(), world);
        this.stride = 15;
        this.stateControl.s = this;
        this.setNormalAttack(2, 200, 0, true, false);
    }

    @Override
    public BufferedImage toImage() {
        return Overview;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return new Ninja(new Point(this.coordinate), this.Camp, this.myWorld);
    }

    static public String ServantName() {
        return "Ninja";
    }
}
