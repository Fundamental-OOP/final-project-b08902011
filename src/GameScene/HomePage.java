package GameScene;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BasicObject.*;

public class HomePage extends Screen{
	public HomePage(){
		super();
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		JLabel title = new JLabel("Game", JLabel.CENTER);	
		title.setBounds(590, 50, 400, 200);
		title.setFont(new java.awt.Font("Dialog", 1, 72));
		title.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		contentPane.add(title);

		Dimension buttonSize = new Dimension(200, 200);

		Button easy = new Button("easy", new Point(250, 700), buttonSize, )
	}
	
}