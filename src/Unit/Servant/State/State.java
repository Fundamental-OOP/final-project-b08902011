package Unit.Servant.State;

import Unit.Servant.*;

import java.util.*;
import java.awt.*;
import java.awt.image.*;

//Specify minimum Servant's State
public abstract class State {
    public Servant s;
    private int attackCount = 0;
    private int walkCount = 0;
    private int deadCount = 0;
    protected int nAttackImage = 0;
    protected int nWalkImage = 0;
    protected int nDeadImage = 0;
    protected Vector<BufferedImage> attackImage = new Vector<BufferedImage>();
    protected Vector<BufferedImage> deadImage = new Vector<BufferedImage>();
    protected Vector<BufferedImage> walkImage = new Vector<BufferedImage>();
    protected Rectangle range = null;

    private void render(BufferedImage image, Graphics g) {
        if (!s.Camp) {
            g.drawImage(image, s.coordinate.x + range.width, s.coordinate.y, -range.width, range.height, null);
        } else {
            g.drawImage(image, s.coordinate.x, s.coordinate.y, range.width, range.height, null);
        }
    }

    protected void DrawWalk(Graphics g) {
        s.move(true);
        this.render(walkImage.get(walkCount), g);
        walkCount = reset(walkCount) + 1;
        walkCount %= nWalkImage;
    }

    protected void DrawAttack(Graphics g) {
        this.render(attackImage.get(attackCount), g);
        attackCount = reset(attackCount) + 1;
        attackCount %= nAttackImage;
    }

    protected void DrawDead(Graphics g) {
        this.render(deadImage.get(deadCount), g);
        deadCount = reset(deadCount) + 1;
        if (deadCount == nDeadImage) {
            s.onDead();
        }
    }

    protected int reset(int preserve) {
        attackCount = 0;
        walkCount = 0;
        return preserve;
    }

    public void update(Graphics g) {
        if (s.dead()) {
            this.DrawDead(g);
        } else if ((attackCount != 0) || ((attackCount == 0) && s.Attack())) {// Only Try when attackCount == 0;
            this.DrawAttack(g);
        } else {
            this.DrawWalk(g);
        }
    }
}
