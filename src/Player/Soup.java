package Player;

import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Soup extends Item {
    static BufferedImage img;
    static {
        try {
            img = (ImageIO.read(new File("Assets/Tower/BasicTower/Idle/1.jpg")));
        } catch (Exception e) {
            System.out.print("GG\n");
        }
    }
    public Soup(){
        super();
        this.price = 10;
    }
    @Override
    public String toString() {
        return "Soup";
    }
    
    @Override
    public void onGet(Player p) {
    }

    @Override
    public void onLost(Player p) {
    }

    @Override
    public BufferedImage toImage() {
        return Soup.img;
    }
}
