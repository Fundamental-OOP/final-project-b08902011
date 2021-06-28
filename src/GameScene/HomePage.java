package GameScene;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BasicObject.*;
import static BasicObject.MyButton.make;
import Player.*;

public class HomePage extends Screen{
	private void setTitle(Container contentPane){
		JLabel title = new JLabel("Game", JLabel.CENTER);	
		title.setBounds(590, 50, 400, 200);
		title.setFont(new java.awt.Font("Dialog", 1, 72));
		title.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		contentPane.add(title);		
	}

	private void setButton(Container contentPane, Player player, Screen currentScreen, Map map){
		Dimension buttonSize = new Dimension(200, 200);
		JButton easy = MyButton.make("easy", new Point(250, 500), buttonSize, player, 1, currentScreen, map);
		contentPane.add(easy);
		JButton medium = MyButton.make("medium", new Point(700, 500), buttonSize, player, 2, currentScreen, map);
		contentPane.add(medium);
		JButton hard = MyButton.make("hard", new Point(1150, 500), buttonSize, player, 3, currentScreen, map);
		contentPane.add(hard);		
	}

	public HomePage(Player player, Screen currentScreen, Map map){
		super();
		screen.setVisible(false);
		screen.getContentPane().setLayout(null);
		setTitle(screen.getContentPane());
		setButton(screen.getContentPane(), player, currentScreen, map);
	}
}