package Unit.Servant.State;

import Unit.Servant.*;

import java.util.*;
import java.awt.*;

//Specify minimum Servant's State
public abstract class State {
    private Servant s;
    int attackCount = 0;
    int walkCount = 0;
    int nAttackImage = 0;
    int nWalkImage = 0;
    int nDeadImage = 0;
    int deadCount = 0;
    static private Vector<Image> attackImage = null;
    static private Vector<Image> deadImage = null;
    static private Vector<Image> walkImage = null;

    private void render(Image image, Graphics g) {
        Rectangle range = null;
        if (s.Camp) {
            g.drawImage(image, range.x + range.width, range.y, -range.width, range.height, null);
        } else {
            g.drawImage(image, range.x, range.y, range.width, range.height, null);
        }
    }

    protected void DrawWalk(Graphics g) {
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
        if(s.dead()){
            this.DrawDead(g);
        }
        else if ((attackCount == 0) && s.Attack()) {// Only Try when attackCount == 0;
            this.DrawAttack(g);
        } else if (attackCount != 0) {
            this.DrawAttack(g);
        } else {
            this.DrawWalk(g);
        }
    }
}
