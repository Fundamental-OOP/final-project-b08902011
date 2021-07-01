package GameScene;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;

import java.util.*;

public class Map extends Screen {
	private static int stage = 0;
	private static final int endStage = 4;
	private static Vector<Vector<Point>> location = new Vector<Vector<Point>>();
	private boolean gameOver = false;
	public Screen nextScreen = null;
	static {
		location.add(new Vector<Point>());
		location.get(0).add(new Point(380, 560));
		location.get(0).add(new Point(260, 460));
		location.get(0).add(new Point(500, 580));
		location.add(new Vector<Point>());
		location.get(1).add(new Point(400, 180));
		location.get(1).add(new Point(560, 400));
		location.get(1).add(new Point(1020, 450));
		location.add(new Vector<Point>());
		location.get(2).add(new Point(760, 130));
		location.get(2).add(new Point(760, 260));
		location.get(2).add(new Point(1000, 230));
		location.add(new Vector<Point>());
		location.get(3).add(new Point(890, 130));
	}

	public Map(JFrame sharedScreen) {
		super(sharedScreen);
		layeredPane.setLayout(null);
		setBackground();
		setButtons();
		screen.setContentPane(layeredPane);
	}

	public boolean GameOver() {
		if (endStage <= stage) {
			gameOver = true;
		}
		return gameOver;
	}

	private void setBackground() {
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

	private void setButtons() {
		Dimension buttonSize = new Dimension(100, 100);
		for (int z = 0; z < location.get(stage).size(); z++) {
			int r = (int) (Math.random() * 400);
			if (r < 100) {
				JButton b = MyButton.setShopButton("Shop", location.get(stage).get(z), buttonSize, this);
				layeredPane.add(b, 0);
				layeredPane.moveToFront(b);
			} else if (r < 250) {
				JButton b = MyButton.setGameButton("Battle", location.get(stage).get(z), buttonSize, this);
				layeredPane.add(b, 0);
				layeredPane.moveToFront(b);
			}else{
				JButton b = MyButton.setConfrontButton("!?!", location.get(stage).get(z), buttonSize, this);
				layeredPane.add(b, 0);
				layeredPane.moveToFront(b);
			}
		}
	}

	@Override
	public void end() {
		super.running = false;
		Map.stage++;
		this.screen.removeAll();
		this.setButtons();
		this.screen.setContentPane(layeredPane);
		System.out.println("Leave Map");
	}
	public int curStage(){
		return Map.stage;
	}
}