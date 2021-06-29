package Unit.Servant.Ninja;

import Unit.*;
import GameScene.Game;
import Unit.Servant.Servant;
import java.awt.*;
import java.awt.image.*;

public class Ninja extends Servant {
    static int initHP = 10;
    static int initATK = 1000;
    static int initDEF = 10;
    public Ninja(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new NinjaState(), world);
        this.stride = 60;
        this.stateControl.s = this;
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
