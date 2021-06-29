package Unit.Servant.CowGirl;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;

import java.awt.image.*;

public class CowGirl extends Servant {
    static {
        CowGirl.stride = 10;
    }
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;

    public CowGirl(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new CowGirlState(), world);
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
