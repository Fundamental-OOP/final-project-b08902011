package Unit.Servant.State;
import Unit.Servant.*;
//Specify minimum Servant's State
public abstract class State {
    private Servant s;
    int attackCount = 0;
    int attackCycle = 0;
    int walkCount = 0;
    int walkCycle = 0;
    protected abstract void DrawWalk(int index);

    protected abstract void DrawAttack(int index);

    protected abstract void DrawDead();

    public void update() {
        if ((attackCount == 0) && s.Attack()) {//Only Try when attackCount == 0;
            this.DrawAttack(0);
            attackCount++;
        } else if (attackCount != 0) {
            this.DrawAttack(attackCount);
            attackCount++;
            attackCount %= attackCycle;
            walkCount = 0;
        } else {
            this.DrawWalk(walkCount);
            walkCount++;
            walkCount %= walkCycle;
            attackCount = 0;
        }
    }
}
