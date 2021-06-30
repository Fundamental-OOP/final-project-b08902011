package GameScene;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;

public class Map extends Screen {
	private void setBackground(JLayeredPane layeredPane) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Assets/map.png"));
		} catch (Exception e) {
			System.out.println("No image!");
		}
		Image resized = img.getScaledInstance(Screen.width, Screen.height, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(resized);

		JLabel imgLabel = new JLabel(image);
		imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

		layeredPane.add(imgLabel, 0);
	}

	private void setButtons(JLayeredPane layeredPane) {
		Dimension buttonSize = new Dimension(100, 100);
		JButton level_1 = MyButton.makeGame("Level1", new Point(380, 560), buttonSize);
		layeredPane.add(level_1, 0);
		layeredPane.moveToFront(level_1);

		JButton level_2 = MyButton.makeGame("Level2", new Point(400, 180), buttonSize);
		layeredPane.add(level_2, 0);
		layeredPane.moveToFront(level_2);

		JButton level_3 = MyButton.makeGame("Level3", new Point(1020, 450), buttonSize);
		layeredPane.add(level_3, 0);
		layeredPane.moveToFront(level_3);

		JButton shop1 = MyButton.makeShop("Level4", new Point(890, 130), buttonSize);
		layeredPane.add(shop1, 0);
		layeredPane.moveToFront(shop1);
	}

	public Map(JFrame sharedScreen) {
		super(sharedScreen);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		setBackground(layeredPane);
		setButtons(layeredPane);
		screen.setContentPane(layeredPane);
	}
}