package GameScene;

import java.awt.*;
import javax.swing.*;

public class Screen extends JFrame{
	private static final int width = 1600;
	private static final int height = 900;
	public Screen(){
		super();
		setBounds(-10, 0, width, height);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}

