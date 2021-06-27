package Servant;
import java.util.*;
public class NormalAttack extends Skill{
    // public int attackCycle = 0;
    public NormalAttack(int nTarget, int range, int cd, boolean toenemy, boolean toally) {
        super(nTarget, range, cd, toenemy, toally);
        // this.attackCycle = attackCycle;
    }
    @Override
    public void Act(Unit performer,Vector<Unit> victim){
        for(Unit u:victim){
            u.takeDamage(((Servant)performer).ATK());
        }
    }
}                                         