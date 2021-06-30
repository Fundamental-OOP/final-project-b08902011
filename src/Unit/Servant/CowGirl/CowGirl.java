package Unit.Servant.CowGirl;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;

import java.awt.image.*;

public class CowGirl extends Servant {
    static int initHP = 200;
    static int initATK = 160;
    static int initDEF = 30;

    public CowGirl(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new CowGirlState(), world);
        this.stateControl.s = this;
        this.stride = 10;
        this.setNormalAttack(1, 500, 0, true, false);
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }
    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
