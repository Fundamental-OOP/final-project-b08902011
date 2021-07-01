package GameScene;

import javax.swing.*;

public class Screen{
	protected JFrame sharedScreen;
	protected JFrame screen;
	public static final int width = 1555;
	public static final int height = 833;
	protected boolean running = true;
	public Screen(JFrame sharedScreen) {
		this.sharedScreen = sharedScreen;
		this.screen = new JFrame();
		screen.setBounds(-10, 0, width, height);
		screen.setVisible(false);
		screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screen.getContentPane().setLayout(null);
	}
	public void end(){
		this.running = false;
	}
	public void run() {
		this.running = true;
		sharedScreen.setContentPane(screen.getContentPane());
		sharedScreen.validate();
		sharedScreen.repaint();
		while(running){
			runningEvent();
			try{
				java.lang.Thread.sleep(1000);
			}catch(Exception e){

			}
		}
	}
	public void runningEvent(){}
}
