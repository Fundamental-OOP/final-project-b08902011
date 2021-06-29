package Unit.Servant.MaleZombie;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;
import java.awt.image.*;

public class MaleZombie extends Servant {
    static {
        MaleZombie.stride = 7;
    }
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;

    public MaleZombie(Game world) {
        super(initHP, initATK, initDEF, new MaleZombieState(), world);
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
