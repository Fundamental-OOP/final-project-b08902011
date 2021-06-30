package Unit.Servant.Ninja;

import Unit.*;
import GameScene.Game;
import Unit.Servant.Servant;
import java.awt.*;
import java.awt.image.*;

public class Ninja extends Servant {
    static int initHP = 400;
    static int initATK = 100;
    static int initDEF = 40;

    public Ninja(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new NinjaState(), world);
        this.stride = 15;
        this.stateControl.s = this;
        this.setNormalAttack(2, 100, 0, true, false);
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
