package Unit.Servant.Skills;

import Unit.*;

import java.util.*;

public abstract class Skill {
    public int cd = 1;
    public int range = 1;
    public int nTarget = 1;
    public boolean toenemy = false;
    public boolean toally = false;
    private int CoolDownCounter = 0;
    static protected String description = "";

    public Skill(int nTarget, int range, int cd, boolean toenemy, boolean toally) {
        this.nTarget = nTarget;
        this.toenemy = toenemy;
        this.toally = toally;
        this.range = range;
        this.cd = cd;
    }

    public String getDescription() {
        return description;
    }

    public abstract void Act(Unit performer, Vector<Unit> victim);

    public boolean CD() {
        return (CoolDownCounter++) >= cd;
    }
    
    public boolean reachable(Unit performer, Unit victim) {
        return ((performer.coordinate.x - performer.coordinate.x) <= this.range);
    }
}
