package Player;

public abstract class Item {
    int price = 0;
    String discription = "No effect!\n";
    public int getPirce(){
        return this.price;
    }
    public String getDiscription(){
        return this.discription;
    }
    public abstract void activate(Player p);
    public abstract void deactivate(Player p);
    //render
}
