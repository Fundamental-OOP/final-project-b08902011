package Player;

import java.util.*;

public class Player {
    private int level = 0;
    private int gold = 0;
    private Vector<Item> asset = new Vector<Item>();
    public int earn(int g){
        gold += g;
        return gold;
    }
    public int spent(int g){
        gold -= g;
        return gold;
    }
    public int getGold(){
        return gold;
    }
    //=======================
    public int assetSize(){
        return asset.size();
    }
    public Item getItem(int index){
        return asset.get(index);
    }
    public int addItem(Item i){
        asset.addElement(i);
        return asset.size();
    }
    public int lossItem(Item i){
        asset.removeElement(i);
        return asset.size();
    }
    //========================
    public int setLevel(int level){
        this.level = level;
        return this.level;
    }
}
