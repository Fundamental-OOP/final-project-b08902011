package Unit.Servant.State;

import Unit.Servant.*;

import java.util.*;
import java.awt.*;
import java.awt.image.*;

//Specify minimum Servant's State
public abstract class State {
    public Servant s;
    int attackCount = 0;
    int walkCount = 0;
    int deadCount = 0;
    static protected int nAttackImage = 1;
    static protected int nWalkImage = 1;
    static protected int nDeadImage = 1;
    static protected Vector<BufferedImage> attackImage = new Vector<BufferedImage>();
    static protected Vector<BufferedImage> deadImage = new Vector<BufferedImage>();
    static protected Vector<BufferedImage> walkImage = new Vector<BufferedImage>();
    static protected Rectangle range = null;

    private void render(BufferedImage image, Graphics g) {
        g.setColor(Color.WHITE); // paint background with all white
        g.fillRect(s.coordinate.x, s.coordinate.y, 300, 300);if (!s.Camp) {
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
        } else if ((attackCount == 0) && s.Attack()) {// Only Try when attackCount == 0;
            this.DrawAttack(g);
        } else if (attackCount != 0) {
            this.DrawAttack(g);
        } else {
            this.DrawWalk(g);
        }
    }
}
