package GameScene;

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
		screen.getContentPane().setLayout(null);
	}
	public void setContent(){
		sharedScreen.getContentPane().removeAll();
		sharedScreen.setContentPane(screen.getContentPane());
		sharedScreen.validate();
		sharedScreen.repaint();
		if(this instanceof Runnable){
			this.run();
		}
	}
	public void run(){
  		System.out.print("Error in Screen.run()\n");
	}
}
