package Unit.Servant.State;

public abstract class State {
    public abstract void Waiting();

    public abstract void Attack();

    public abstract void Dead();

    public abstract void update();
}
