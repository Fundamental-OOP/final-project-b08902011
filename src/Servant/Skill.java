package Servant;
public abstract class Skill {
    int cd = 1;
    int range = 1;
    public int nTarget = 1;
    public boolean toenemy = false;
    public boolean toally = false;
    String discription = "";
    public String getDescription(){
        return this.discription;
    }
    public abstract void OnAttack(Unit performer,Unit victim);
    public int CD(){
        return this.cd;
    }
    public boolean reachable(Unit performer,Unit victim){
        return true;
    }
}
