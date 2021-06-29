package GameScene;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;
import static BasicObject.MyButton.make;

public class Map extends Screen{
	private void setBackground(JLayeredPane layeredPane){
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

		layeredPane.setLayout(null);
		layeredPane.add(imgLabel, 0);		
	}

	private void setButtons(JLayeredPane layeredPane, java.util.List<Screen> levels){
		Dimension buttonSize = new Dimension(100, 100);
		Font buttonFont = new Font("Dialog", Font.BOLD, 20);
		JButton level_1 = MyButton.make("Level1", new Point(400, 600), buttonSize, levels.get(0));
		level_1.setContentAreaFilled(false);
		level_1.setBorderPainted(true);
		level_1.setOpaque(false);
		level_1.setFont(buttonFont);
		level_1.setForeground(Color.white);
		layeredPane.add(level_1, 0);
		layeredPane.moveToFront(level_1);

		JButton level_2 = MyButton.make("Level2", new Point(420, 200), buttonSize, levels.get(1));
		level_2.setContentAreaFilled(false);
		level_2.setBorderPainted(true);
		level_2.setOpaque(false);
		level_2.setFont(buttonFont);
		level_2.setForeground(Color.white);
		layeredPane.add(level_2, 0);
		layeredPane.moveToFront(level_2);

		JButton level_3 = MyButton.make("Level3", new Point(1070, 490), buttonSize, levels.get(2));
		level_3.setContentAreaFilled(false);
		level_3.setBorderPainted(true);
		level_3.setOpaque(false);
		level_3.setFont(buttonFont);
		level_3.setForeground(Color.white);
		layeredPane.add(level_3, 0);
		layeredPane.moveToFront(level_3);

		JButton shop1 = MyButton.make("Level4", new Point(920, 140), buttonSize, levels.get(3));
		shop1.setContentAreaFilled(false);
		shop1.setBorderPainted(true);
		shop1.setOpaque(false);
		shop1.setFont(buttonFont);
		shop1.setForeground(Color.white);
		layeredPane.add(shop1, 0);
		layeredPane.moveToFront(shop1);		
	}
	public Map(JFrame sharedScreen, java.util.List<Screen> levels){
		super(sharedScreen);
		JLayeredPane layeredPane = new JLayeredPane();
		setBackground(layeredPane);
		setButtons(layeredPane, levels);
	
		screen.setContentPane(layeredPane);
	}
}