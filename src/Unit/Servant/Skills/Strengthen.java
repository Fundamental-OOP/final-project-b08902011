package Unit.Servant.Skills;

import Unit.*;

import java.util.*;
import Unit.Servant.*;
public final class Strengthen extends Skill {
    public Strengthen() {
        super(1, 1, 30, false, true);
    }

    @Override
    public void Act(Unit performer, Vector<Unit> victim) {
        System.out.print("S\n");
        ((Servant)performer).addATK(10);
    }
}