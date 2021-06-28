package Unit.Tower;

import Unit.*;
import GameScene.Game;
import java.awt.*;

public abstract class Tower extends Unit {
    public Tower(Point coordinate,Boolean Camp,int hp,int def,Game myWorld){
        super(coordinate, Camp, hp, def, myWorld);
    }

    public int setHP(int hp) {
        this.hp = hp;
        return this.hp;
    }

    public int setDef(int def) {
        this.def = def;
        return this.def;
    }
}