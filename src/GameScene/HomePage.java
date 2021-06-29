package GameScene;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BasicObject.*;
import Player.*;

public class HomePage extends Screen {
	private void setTitle(Container contentPane) {
		JLabel title = new JLabel("Game", JLabel.CENTER);
		title.setBounds(570, 110, 400, 200);
		title.setFont(new Font("Serif", Font.ITALIC, 120));
		title.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		contentPane.add(title);
	}

	private void setButton(Container contentPane, Player player, Map map) {
		Dimension buttonSize = new Dimension(200, 200);
		Font buttonFont = new Font("DialogInput", Font.PLAIN, 42);
		JButton easy = MyButton.make("easy", new Point(220, 460), buttonSize, player, 1, map);
		easy.setFont(buttonFont);
		contentPane.add(easy);
		JButton medium = MyButton.make("medium", new Point(670, 460), buttonSize, player, 2, map);
		medium.setFont(buttonFont);
		contentPane.add(medium);
		JButton hard = MyButton.make("hard", new Point(1120, 460), buttonSize, player, 3, map);
		hard.setFont(buttonFont);
		contentPane.add(hard);
	}

	public HomePage(JFrame currentScreen, Player player, Map map) {
		super(currentScreen);
		setTitle(screen.getContentPane());
		setButton(screen.getContentPane(), player, map);
	}
}