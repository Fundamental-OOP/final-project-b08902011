package Servant;
import java.util.*;
public abstract class Skill {
    int cd = 1;
    int CoolDownCounter = 0;
    int range = 1;
    public int nTarget = 1;
    public boolean toenemy = false;
    public boolean toally = false;
    String discription = "";
    public String getDescription(){
        return this.discription;
    }
    public abstract void Act(Unit performer,Vector<Unit> victim);
    public boolean CD(){
        return (CoolDownCounter++) >= cd;
    }
    public boolean reachable(Unit performer,Unit victim){
        //Not done, need to define border of Servant
        return true;
    }
}
