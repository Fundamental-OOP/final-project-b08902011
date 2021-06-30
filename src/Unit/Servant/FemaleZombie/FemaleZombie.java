package Unit.Servant.FemaleZombie;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;

import java.awt.image.*;

public class FemaleZombie extends Servant {
    static int initHP = 1000;
    static int initATK = 120;
    static int initDEF = 60;

    public FemaleZombie(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new FemaleZombieState(), world);
        this.stateControl.s = this;
        this.stride = 5;
        this.setNormalAttack(1, 130, 0, true, false);
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
