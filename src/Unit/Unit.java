package Unit;

import GameScene.Screen;
import java.awt.*;

public abstract class Unit {
    public boolean Camp = true;
    protected int hp = 1;
    protected int def = 1;

    public boolean dead() {
        return hp <= 0;
    }

    public int takeDamage(int damage) {
        this.hp -= (damage - this.def) > 0 ? (damage - this.def) : 1;
        return this.hp;
    }

    public abstract Unit Generate(Screen s, Point p, Dimension d);

    public abstract void render(Graphics g);
}
