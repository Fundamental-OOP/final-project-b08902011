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

public class Shop extends Screen {
	private java.util.List<Item> allItem = new ArrayList<>();
	private java.util.List<Item> availableItem = new ArrayList<>();

	private void setBackground(JLayeredPane layeredPane) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Assets/shop.jpg"));
		} catch (Exception e) {
			System.out.println("No image!");
		}
		BufferedImage subImg = img.getSubimage(80, 0, 1400, img.getHeight());
		Image resized = subImg.getScaledInstance(Screen.width, Screen.height, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(resized);
		JLabel imgLabel = new JLabel(image);
		imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		layeredPane.add(imgLabel, 0);

		JLabel title = new JLabel("Shop", JLabel.CENTER);
		title.setBounds(225, 67, 133, 50);
		title.setFont(new Font("Dialog", Font.BOLD, 42));
		title.setForeground(Color.orange);
		title.setOpaque(true);
		title.setBackground(Color.darkGray);
		layeredPane.add(title, 0);
		layeredPane.moveToFront(title);
	}

	private java.util.List<JPanel> setShelves(JLayeredPane layeredPane) {
		java.util.List<JPanel> shelves = new ArrayList<>();
		Dimension shelfSize = new Dimension(420, 220);

		JPanel shelf1 = new JPanel();
		shelf1.setLocation(410, 60);
		shelf1.setSize(shelfSize);
		shelf1.setBackground(Color.magenta);
		shelves.add(shelf1);
		layeredPane.add(shelf1, 0);
		layeredPane.moveToFront(shelf1);

		JPanel shelf2 = new JPanel();
		shelf2.setLocation(858, 60);
		shelf2.setSize(shelfSize);
		shelf2.setBackground(Color.magenta);
		shelves.add(shelf2);
		layeredPane.add(shelf2, 0);
		layeredPane.moveToFront(shelf2);

		JPanel shelf3 = new JPanel();
		shelf3.setLocation(410, 300);
		shelf3.setSize(shelfSize);
		shelf3.setBackground(Color.magenta);
		shelves.add(shelf3);
		layeredPane.add(shelf3, 0);
		layeredPane.moveToFront(shelf3);

		JPanel shelf4 = new JPanel();
		shelf4.setLocation(858, 300);
		shelf4.setSize(shelfSize);
		shelf4.setBackground(Color.magenta);
		shelves.add(shelf4);
		layeredPane.add(shelf4, 0);
		layeredPane.moveToFront(shelf4);

		JPanel shelf5 = new JPanel();
		shelf5.setLocation(410, 540);
		shelf5.setSize(shelfSize);
		shelf5.setBackground(Color.magenta);
		shelves.add(shelf5);
		layeredPane.add(shelf5, 0);
		layeredPane.moveToFront(shelf4);

		JPanel shelf6 = new JPanel();
		shelf6.setLocation(858, 540);
		shelf6.setSize(shelfSize);
		shelf6.setBackground(Color.magenta);
		shelves.add(shelf6);
		layeredPane.add(shelf6, 0);
		layeredPane.moveToFront(shelf6);

		return shelves;
	}

	public Shop(JFrame sharedScreen) {
		super(sharedScreen);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		setBackground(layeredPane);
		java.util.List<JPanel> shelves = setShelves(layeredPane);
//Should be replace with ending bottum
		JButton backButton = MyButton.make("Back", new Point(380, 560), new Dimension(100, 100), null);
		layeredPane.add(backButton, 0);
		layeredPane.moveToFront(backButton);
		screen.setContentPane(layeredPane);
		// screen.setVisible(true);
	}
}
