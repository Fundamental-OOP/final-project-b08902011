package Unit.Servant.BasicServant;

import javax.sql.rowset.serial.SerialArray;

import Unit.Servant.Servant;

import Unit.*;
import GameScene.Game;
import java.awt.*;
import Unit.Servant.State.*;
public class BasicServant extends Servant {
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;
    public BasicServant(){
        super(initHP, initATK, initDEF,new BasicServantState());
        this.stateControl.s = this;
    }
    public void onDead(){
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp){
        return null;
    }

    public void render(Graphics g){
        stateControl.update(g);
    }
}
