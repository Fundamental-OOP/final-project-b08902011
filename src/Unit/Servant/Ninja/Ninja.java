package Unit.Servant.Ninja;

import Unit.*;
import GameScene.Game;
import Unit.Servant.Servant;
import java.awt.*;
import java.awt.image.*;

public class Ninja extends Servant {
    static int initHP = 500;
    static int initATK = 130;
    static int initDEF = 50;

    public Ninja(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new NinjaState(), world);
        this.stride = 15;
        this.stateControl.s = this;
        this.setNormalAttack(2, 200, 0, true, false);
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }

    public Servant Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
