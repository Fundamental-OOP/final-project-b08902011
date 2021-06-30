package GameScene;

import java.awt.*;
import javax.swing.*;
import BasicObject.*;

public class HomePage extends Screen {
	private void setTitle(Container contentPane) {
		JLabel title = new JLabel("Game", JLabel.CENTER);
		title.setBounds(570, 110, 400, 200);
		title.setFont(new Font("Serif", Font.ITALIC, 120));
		title.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		contentPane.add(title);
	}

	private void setButton(Container contentPane) {
		Dimension buttonSize = new Dimension(200, 200);
		JButton easy = MyButton.makeMap("easy", new Point(220, 460), buttonSize, 1);
		contentPane.add(easy);
		JButton medium = MyButton.makeMap("medium", new Point(670, 460), buttonSize, 2);
		contentPane.add(medium);
		JButton hard = MyButton.makeMap("hard", new Point(1120, 460), buttonSize, 3);
		contentPane.add(hard);
	}

	public HomePage(JFrame currentScreen) {
		super(currentScreen);
		setTitle(screen.getContentPane());
		setButton(screen.getContentPane());
	}
}