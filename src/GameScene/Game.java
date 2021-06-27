package GameScene;

import java.awt.*;
import java.util.*;
import Servant.*;

public class Game extends Screen {
    Vector<Servant> Left = new Vector<Servant>();// Camp == true
    Vector<Servant> Right = new Vector<Servant>();
    Tower LeftTower = new Tower();
    Tower RightTower = new Tower();

    public Game() {
        super();
    }

    public void addServant(Servant s, Point p, Dimension d, boolean Camp) {
        if (Camp) {
            Left.add(s);
            // Draw s facing right
        } else {
            Right.add(s);
            // Dra s facing left
        }
    }

    public int TimeSlice() {// a slice in game
        for (int i = 0; i < Left.size(); i++) {
            Left.get(i).slice();
        }
        for (int i = 0; i < Right.size(); i++) {
            Right.get(i).slice();
        }
        if (LeftTower.dead()) {
            return -1;
        } else if (RightTower.dead()) {
            return 1;
        }
        // this.updata();//Draw Everything
        // delay(0);// Set FPS
        return 0;
    }

    public Vector<Unit> getTarget(Servant s, Skill skill) {
        boolean Camp = s.Camp;
        boolean enemy = skill.toenemy;
        boolean ally = skill.toally;
        int nTarget = skill.nTarget;
        Vector<Unit> ret = new Vector<Unit>();
        if ((Camp && enemy) || (!Camp && ally)) {// Right to be selected
            for (Servant u : Right) {
                if (skill.reachable(s, u)) {
                    ret.add(u);
                    nTarget--;
                    if (nTarget == 0) {
                        return ret;
                    }
                }
            }
            ret.add(RightTower);
        }
        if ((!Camp && enemy) || (Camp && ally)) {
            for (Servant u : Left) {
                if (skill.reachable(s, u)) {
                    ret.add(u);
                    nTarget--;
                    if (nTarget == 0) {
                        return ret;
                    }
                }
            }
            ret.add(LeftTower);
        }
        return null;
    }
}
