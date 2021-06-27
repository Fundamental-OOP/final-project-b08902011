package GameScene;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Map extends Screen{
	public Map(){
		super();
		screen.setVisible(false);

		ImageIcon img = new ImageIcon("Assets/map.png");
		
		JLabel imgLabel = new JLabel(img);
		screen.add(imgLabel);
	}
}