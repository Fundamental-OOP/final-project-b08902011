package Unit.Tower.BasicTower;

import Unit.Tower.Tower;
import java.awt.*;
import java.nio.Buffer;

import GameScene.Game;
import Unit.*;
import java.awt.image.*;

public class BasicTower extends Tower {
    public BasicTower() {
        super(1000, 10);
    }

    @Override
    public BufferedImage toImage() {
        return null;
    }

    public BasicTower(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, 1000, 10, world);
    }

    @Override
    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return (Unit) (new BasicTower(coordinate, Camp, world));
    }

    @Override
    public void render(Graphics g) {

    }
}
