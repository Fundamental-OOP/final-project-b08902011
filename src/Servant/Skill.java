package Servant;

public abstract class Skill {
    String discription = "";
    public String getDescription(){
        return this.discription;
    }
    public abstract void OnAttack(Unit performer,Unit victim);
}
