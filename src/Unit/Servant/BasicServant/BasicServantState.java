package Unit.Servant.BasicServant;
import Unit.Servant.Servant;
import Unit.Servant.State.State;
import java.io.*;
import javax.imageio.*;
import java.awt.*;

public class BasicServantState extends State {
    static {
        nAttackImage = 3;
        for (int i = 1; i <= nAttackImage; i++) {
            try {
                attackImage.add(ImageIO
                        .read(new File("Assets/Servant/" + ServantName() + "/Attack/" + String.valueOf(i) + ".png")));
            } catch (IOException e) {
                System.out.print(
                        "Load" + "Assets/Servant/" + ServantName() + "/Attack/" + String.valueOf(i) + ".png Failed\n");
            }
        }
        nWalkImage = 3;
        for (int i = 1; i <= nWalkImage; i++) {
            try {
                walkImage.add(ImageIO
                        .read(new File("Assets/Servant/" + ServantName() + "/Walk/" + String.valueOf(i) + ".png")));
            } catch (IOException e) {
                System.out.print(
                        "Load" + "Assets/Servant/" + ServantName() + "/Walk/" + String.valueOf(i) + ".png Failed\n");
            }
        }
        nDeadImage = 3;
        for (int i = 1; i <= nDeadImage; i++) {
            try {
                deadImage.add(ImageIO
                        .read(new File("Assets/Servant/" + ServantName() + "/Dead/" + String.valueOf(i) + ".png")));
            } catch (IOException e) {
                System.out.print(
                        "Load" + "Assets/Servant/" + ServantName() + "/Dead/" + String.valueOf(i) + ".png Failed\n");
            }
        }
        range = new Rectangle(0, 0, 300, 300);
    }

    static public String ServantName() {
        // return "BasicSeverant";
        return "CowGirl";
    }
}
