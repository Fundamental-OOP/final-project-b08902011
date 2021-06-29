package GameScene;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;
import static BasicObject.MyButton.make;
import Player.*;

public class Shop extends Screen{
	private java.util.List<Item> allItem = new ArrayList<>();
	private java.util.List<Item> availableItem = new ArrayList<>();

	private void setBackground(JLayeredPane layeredPane){
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Assets/shop.jpg"));
		} catch (Exception e) {
			System.out.println("No image!");
		}
		BufferedImage subImg = img.getSubimage(100, 0, 1400, img.getHeight());
		Image resized = subImg.getScaledInstance(1600, 800, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(resized);

		JLabel imgLabel = new JLabel(image);
		imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

		layeredPane.setLayout(null);
		layeredPane.add(imgLabel, 0);
	}

<<<<<<< HEAD
public class Shop extends Screen{
	// private List<Item> allItem = new ArrayList();
	// private List<Item> availableItem = new ArrayList();
=======
>>>>>>> 718f80ecbbe8b3463173a0531c6bcef3ecd3f539
	public Shop(JFrame sharedScreen){
		super(sharedScreen);
		JLayeredPane layeredPane = new JLayeredPane();
		setBackground(layeredPane);

		screen.setContentPane(layeredPane);
		screen.setVisible(true);
	}
}
