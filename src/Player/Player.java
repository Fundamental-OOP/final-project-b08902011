package Player;

import java.util.*;
import Unit.Tower.*;
import Unit.Tower.BasicTower.BasicTower;
import Unit.Servant.*;

public class Player {
    public int stage = 0;
    private int gold = 1000;
    public int hardness = 0;
    private Vector<Item> asset = new Vector<Item>();
    private Vector<Servant> servants = new Vector<Servant>();
    private Tower myTower = new BasicTower();

    public Vector<Servant> Servants() {
        return this.servants;
    }

    public int setHardness(int h) {
        this.hardness = h;
        return this.hardness;
    }

    public Tower MyTower() {
        return myTower;
    }

    // ===========================
    public int earn(int g) {
        gold += g;
        return gold;
    }

    public int spent(int g) {
        gold -= g;
        return gold;
    }

    public int getGold() {
        return gold;
    }

    // =======================
    public int assetSize() {
        return asset.size();
    }

    public Item getItem(int index) {
        return asset.get(index);
    }

    public int addItem(Item i) {
        asset.addElement(i);
        return asset.size();
    }

    public int lossItem(Item i) {
        asset.removeElement(i);
        return asset.size();
    }
    public int Win(){
        this.stage++;
        return this.stage;
    }
}
