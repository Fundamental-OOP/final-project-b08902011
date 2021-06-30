package GameScene;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;
import Player.*;

public class Shop extends Screen {
	public static int nAvalible = 6;
	private static Vector<Item> allItem = new Vector<Item>();
	static {
		allItem.add(new Soup());
	}
	private JLabel account = null;

	public Shop(JFrame sharedScreen, Player player) {
		super(sharedScreen);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		setBackground(layeredPane);
		setShelves(layeredPane);

		JButton backButton = MyButton.makeMap("Back", new Point(20, 50), new Dimension(150, 100), player.hardness);
		layeredPane.add(backButton, 0);
		layeredPane.moveToFront(backButton);

		account = new JLabel("Account Balance:" + String.valueOf(player.getGold()));
		account.setBounds(50, 300, 250, 70);
		account.setBackground(Color.GRAY);
		account.setForeground(Color.BLUE);
		account.setOpaque(true);
		account.setFont(new Font("DialogInput", Font.PLAIN, 20));
		layeredPane.add(account);
		layeredPane.moveToFront(account);

		screen.setContentPane(layeredPane);
	}

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

	private Item PickItem() {
		return allItem.get((int) (Math.random() * allItem.size()));
	}

	private void setShelves(JLayeredPane layeredPane) {
		Dimension shelfSize = new Dimension(420, 220);
		Dimension ButtonSize = new Dimension(420, 60);
		Point[] location = { new Point(410, 60), new Point(858, 60), new Point(410, 300), new Point(858, 300),
				new Point(410, 540), new Point(858, 540) };
		for (int i = 0; i < 6; i++) {
			JPanel backgroud = new JPanel();
			backgroud.setLocation(location[i].x, location[i].y);
			backgroud.setSize(shelfSize);
			backgroud.setBackground(Color.magenta);
			layeredPane.add(backgroud, 0);
			layeredPane.moveToFront(backgroud);
		}
		for (int i = 0; i < nAvalible; i++) {

			Item t = PickItem();
			BufferedImage image = t.toImage();
			JLabel imgLabel = new JLabel(new ImageIcon(image));
			imgLabel.setBounds(location[i].x, location[i].y, shelfSize.width, shelfSize.height);
			layeredPane.add(imgLabel, 0);
			layeredPane.moveToFront(imgLabel);
			JButton tButton = MyButton.makeShopButton(t.toString() + " " + String.valueOf(t.getPrice()) + "$",
					new Point(location[i].x, location[i].y + 160), ButtonSize, t);
			layeredPane.add(tButton, 0);
			layeredPane.moveToFront(tButton);
		}
	}

}
