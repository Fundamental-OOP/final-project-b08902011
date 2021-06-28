package Unit.Servant.Skills;

import Unit.*;
import java.util.*;

public abstract class Skill {
    public int cd = 1;
    int range = 1;
    public int nTarget = 1;
    int CoolDownCounter = 0;
    public boolean toenemy = false;
    public boolean toally = false;
    String discription = "";

    public Skill(int nTarget, int range, int cd, boolean toenemy, boolean toally) {
        this.nTarget = nTarget;
        this.toenemy = toenemy;
        this.toally = toally;
        this.range = range;
        this.cd = cd;
    }

    public String getDescription() {
        return this.discription;
    }

    public abstract void Act(Unit performer, Vector<Unit> victim);

    public boolean CD() {
        return (CoolDownCounter++) >= cd;
    }

    public boolean reachable(Unit performer, Unit victim) {
        // Not done, need to define border of Servant
        return true;
    }
}
