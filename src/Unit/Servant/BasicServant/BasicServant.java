package Unit.Servant.BasicServant;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;

import java.awt.image.*;

public class BasicServant extends Servant {
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;

    public BasicServant(Game world) {
        super(initHP, initATK, initDEF, new BasicServantState(), world);
        this.stateControl.s = this;
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }


    public Servant Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }
}
