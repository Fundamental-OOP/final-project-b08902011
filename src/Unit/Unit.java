package Unit;

import GameScene.Game;
import java.awt.*;
import java.awt.image.*;

public abstract class Unit {

    public abstract Unit Duplicate(Game world, Point coordinate, boolean Camp);

    public abstract BufferedImage toImage();

    public Point coordinate = null;
    public boolean Camp = true;
    protected int hp = 0;
    protected int def = 0;
    protected Game myWorld = null;

    public Unit(Point coordinate, boolean Camp, int hp, int def, Game myWorld) {
        this.coordinate = coordinate;
        this.Camp = Camp;
        this.hp = hp;
        this.def = def;
        this.myWorld = myWorld;
    }

    public Unit(int hp, int def) {
        this.hp = hp;
        this.def = def;
    }

    public boolean dead() {
        return hp <= 0;
    }

    public int takeDamage(int damage) {
        this.hp -= (damage - this.def) > 0 ? (damage - this.def) : 1;
        return this.hp;
    }

}
