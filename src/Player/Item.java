package Player;

import java.awt.Graphics;

public abstract class Item {
    int price = 0;
    String discription = "No effect!\n";

    public int getPirce() {
        return this.price;
    }

    public String getDiscription() {
        return this.discription;
    }

    public abstract void onGet(Player p);

    public abstract void onLost(Player p);

    public abstract void render(Graphics g);
}
