package GameScene;

import java.awt.*;
import javax.swing.*;

public class Screen{
	protected JFrame screen;
	private static final int width = 1600;
	private static final int height = 900;
	public Screen(){
		this.screen = new JFrame();
		screen.setBounds(-10, 0, width, height);
		screen.setVisible(true);
		screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public void switch_screen(){

	}
	public void setContent(JFrame newScreen){
		screen.getContentPane().removeAll();
		screen.setContentPane(newScreen.getContentPane());
		screen.getContentPane().validate();
		screen.getContentPane().repaint();
	}
	public JFrame getScreen(){
		return this.screen;
	}
}

