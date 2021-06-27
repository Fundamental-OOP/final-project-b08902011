package GameScene;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BasicObject.*;
import Player.*;

public class HomePage extends Screen{
	public HomePage(Player player){
		super();
		screen.setVisible(false);
		contentPane = screen.getContentPane();
		contentPane.setLayout(null);
		JLabel title = new JLabel("Game", JLabel.CENTER);	
		title.setBounds(590, 50, 400, 200);
		title.setFont(new java.awt.Font("Dialog", 1, 72));
		title.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		contentPane.add(title);

		Dimension buttonSize = new Dimension(200, 200);

		JButton easy = MyButton.make("easy", new Point(250, 500), buttonSize, player, 1);
		contentPane.add(easy);
		JButton medium = MyButton.make("medium", new Point(700, 500), buttonSize, player, 2);
		contentPane.add(medium);
		JButton hard = MyButton.make("hard", new Point(1150, 500), buttonSize, player, 3);
		contentPane.add(hard);
	}
}