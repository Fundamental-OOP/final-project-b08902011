package GameScene;

import java.awt.*;
import javax.swing.*;
import BasicObject.*;

public class HomePage extends Screen {
	public HomePage(JFrame currentScreen) {
		super(currentScreen);
		setTitle(screen.getContentPane());
		setButton(screen.getContentPane());
	}

	private void setTitle(Container contentPane) {
		JLabel title = new JLabel("Game", JLabel.CENTER);
		title.setBounds(570, 110, 400, 200);
		title.setFont(new Font("Serif", Font.ITALIC, 120));
		title.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		contentPane.add(title);
	}

	private void setButton(Container contentPane) {
		Dimension buttonSize = new Dimension(200, 200);
		JButton easy = MyButton.setHardnessButton("Easy", new Point(220, 460), buttonSize, 1, this);
		contentPane.add(easy);
		JButton medium = MyButton.setHardnessButton("Medium", new Point(670, 460), buttonSize, 2, this);
		contentPane.add(medium);
		JButton hard = MyButton.setHardnessButton("Hard", new Point(1120, 460), buttonSize, 3, this);
		contentPane.add(hard);
	}
}