package Unit.Servant.MaleZombie;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;
import java.awt.image.*;

public class MaleZombie extends Servant {
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;

    public MaleZombie(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new MaleZombieState(), world);
        this.stateControl.s = this;
        this.stride = 7;
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
