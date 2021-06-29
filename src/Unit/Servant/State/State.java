package Unit.Servant.State;

import Unit.Servant.*;

import java.util.*;
import java.awt.*;

//Specify minimum Servant's State
public abstract class State {
    protected Servant s;
    int attackCount = 0;
    int walkCount = 0;
    int deadCount = 0;
    static protected int nAttackImage = 0;
    static protected int nWalkImage = 0;
    static protected int nDeadImage = 0;
    static protected Vector<Image> attackImage = null;
    static protected Vector<Image> deadImage = null;
    static protected Vector<Image> walkImage = null;
    static protected Rectangle range = null; 
    private void render(Image image, Graphics g) {
        if (s.Camp) {
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
