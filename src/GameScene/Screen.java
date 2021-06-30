package GameScene;

import javax.swing.*;

public class Screen {
	protected JFrame sharedScreen;
	protected JFrame screen;
	public static final int width = 1555;
	public static final int height = 833;

	public Screen(JFrame sharedScreen) {
		this.sharedScreen = sharedScreen;
		this.screen = new JFrame();
		screen.setBounds(-10, 0, width, height);
		screen.setVisible(false);
		screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screen.getContentPane().setLayout(null);
	}

	public void setContent() {
		sharedScreen.getContentPane().removeAll();
		sharedScreen.setContentPane(screen.getContentPane());
		sharedScreen.validate();
		sharedScreen.repaint();
	}
}
