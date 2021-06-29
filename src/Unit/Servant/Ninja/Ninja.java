package Unit.Servant.Ninja;

import Unit.*;
import GameScene.Game;
import Unit.Servant.Servant;
import java.awt.*;

public class Ninja extends Servant {
    static{
        Ninja.stride = 30;
    }
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;

    public Ninja(Game world) {
        super(initHP, initATK, initDEF, new NinjaState(),world);
        this.stateControl.s = this;
    }

    public void onDead() {
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }

    public void render(Graphics g) {
        stateControl.update(g);
    }
}
