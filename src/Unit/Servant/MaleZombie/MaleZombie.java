package Unit.Servant.MaleZombie;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;
import java.awt.image.*;

public class MaleZombie extends Servant {
    static int initHP = 2000;
    static int initATK = 200;
    static int initDEF = 40;

    public MaleZombie(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new MaleZombieState(), world);
        this.stateControl.s = this;
        this.stride = 7;
        this.setNormalAttack(1, 80, 0, true, false);
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
