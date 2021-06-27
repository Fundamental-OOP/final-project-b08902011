package GameScene;
import java.awt.*;
import java.util.*;
import Servant.*;
public class Game extends Screen{
    Vector<Servant> Left = new Vector<Servant>();//Camp == true
    Vector<Servant> Right = new Vector<Servant>();
    Tower LeftTower = new Tower();
    Tower RightTower = new Tower();
    public Game(){
        super();
    }
    public void addServant(Servant s,Point p,Dimension d,boolean Camp){

    }
    public int TimeSlice(){//a slice in game
        for(Servant u : Left){
            u.slice();
        }
        for(Servant u : Right){
            u.slice();
        }
        if(LeftTower.dead() && RightTower.dead()){
            return 0;
        }
        else if(LeftTower.dead()){
            return -1;
        }
        else{
            return 1;
        }
        //this.updata();//Draw Everything
        //delay(0);// Set FPS
    }
    public Vector<Unit> getTarget(Servant s,Skill skill){
        boolean Camp = s.Camp;
        boolean enemy = skill.toenemy;
        boolean ally = skill.toally;
        int nTarget = skill.nTarget;
        Vector<Unit> ret = new Vector<Unit>();
        if((Camp && enemy) ||(!Camp && ally)){//Right to be selected
            for(Servant u : Right){
                if(skill.reachable(s,u)){
                    ret.add(u);
                    nTarget--;
                    if(nTarget == 0){
                        return ret;
                    }
                }
            }
        }
        if((!Camp && enemy) ||(Camp && ally)){
            for(Servant u : Left){
                if(skill.reachable(s,u)){
                    ret.add(u);
                    nTarget--;
                    if(nTarget == 0){
                        return ret;
                    }
                }
            }
        }
        return null;
    }
    private boolean intersect(Unit a,Unit b){
        return True;
    }
}
