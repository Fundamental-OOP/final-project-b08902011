package GameScene;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;
import java.util.*;
public class Map extends Screen {
	private static int stage = -1;
	private static final int endStage = 3;
	private static Vector<Vector<Point>> location = new Vector<Vector<Point>>();
	static {
		location.add(new Vector<Point>());
		location.get(0).add(new Point(380, 560));
		location.get(0).add(new Point(260, 460));
		location.get(0).add(new Point(500, 580));
		location.add(new Vector<Point>());
		location.get(1).add(new Point(400, 180));
		location.get(1).add(new Point(1020, 450));
		location.add(new Vector<Point>());
		location.get(2).add(new Point(890, 130));
	}
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
		for (int z = 0; z < location.get(stage).size(); z++) {
			int r = (int) (Math.random() * 100);
			if (r < 10) {
				JButton b = MyButton.makeShop("Shop", location.get(stage).get(z), buttonSize);
				layeredPane.add(b, 0);
				layeredPane.moveToFront(b);
			} else if (r < 101) {
				JButton b = MyButton.makeGame("Battle", location.get(stage).get(z), buttonSize);
				layeredPane.add(b, 0);
				layeredPane.moveToFront(b);
			}
		}
	}

	public Map(JFrame sharedScreen) {
		super(sharedScreen);
		System.out.print("obj\n");
		Map.stage++;
		System.out.print("obj\n");
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		setBackground(layeredPane);
		setButtons(layeredPane);
		screen.setContentPane(layeredPane);
	}
}