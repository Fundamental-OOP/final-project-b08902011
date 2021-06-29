package Unit.Servant.Ninja;

import Unit.*;
import GameScene.Game;
import Unit.Servant.Servant;
import java.awt.*;
import java.awt.image.*;

public class Ninja extends Servant {
    static {
        Ninja.stride = 30;
    }
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;

    public Ninja(Point coordinate,boolean Camp,Game world) {
        super(coordinate,Camp,initHP, initATK, initDEF, new NinjaState(), world);
        this.stateControl.s = this;
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }

    public void onDead() {
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
