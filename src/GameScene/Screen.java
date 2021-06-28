package GameScene;

import java.awt.*;
import javax.swing.*;

public class Screen{
	protected JFrame sharedScreen;
	protected JFrame screen;
	private static final int width = 1600;
	private static final int height = 900;
	public Screen(JFrame sharedScreen){
		this.sharedScreen = sharedScreen;
		this.screen = new JFrame();
		screen.setBounds(-10, 0, width, height);
		screen.setVisible(false);
		screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void switchScreen(){

	}
	public void setContent(){
		sharedScreen.getContentPane().removeAll();
		sharedScreen.setContentPane(screen.getContentPane());
		sharedScreen.getContentPane().validate();
		sharedScreen.getContentPane().repaint();
		// sharedScreen.getLayeredPane().removeAll();
		// sharedScreen.setLayeredPane(screen.getLayeredPane());
		// sharedScreen.getLayeredPane().validate();
		// sharedScreen.getLayeredPane().repaint();
	}
	public JFrame get(){
		return screen;

	}
}
