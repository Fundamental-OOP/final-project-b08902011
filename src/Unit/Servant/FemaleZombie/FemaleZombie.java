package Unit.Servant.FemaleZombie;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;

public class FemaleZombie extends Servant {
    static {
        FemaleZombie.stride = 5;
    }
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;

    public FemaleZombie(Game world) {
        super(initHP, initATK, initDEF, new FemaleZombieState(),world);
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
