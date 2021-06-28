package GameScene;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;
import static BasicObject.MyButton.make;

public class Map extends Screen{
	public Map(JFrame sharedScreen, Game level1){
		super(sharedScreen);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Assets/map.png"));
		} catch (Exception e) {
			System.out.println("No image!");
		}
		Image resized = img.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(resized);

		JLabel imgLabel = new JLabel(image);
		imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

		screen.getLayeredPane().setLayout(null);
		screen.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		((JPanel) screen.getContentPane()).setOpaque(false);

		screen.getContentPane().setLayout(null);
		Dimension buttonSize = new Dimension(200, 200);
		JButton level_1 = MyButton.make("Level1", new Point(250, 500), buttonSize, level1);
		level_1.setContentAreaFilled(false);
		level_1.setBorderPainted(true);
		screen.getContentPane().add(level_1);

		// screen.setVisible(true);
	}
}