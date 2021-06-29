package Unit.Servant.FemaleZombie;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;

import java.awt.image.*;

public class FemaleZombie extends Servant {
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;

    public FemaleZombie(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new FemaleZombieState(), world);
        this.stateControl.s = this;
        this.stride = 5;
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
