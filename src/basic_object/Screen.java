package basic_object;

import java.awt.*;
import javax.swing.*;

public class Screen{
	private String name;
	private JFrame frame = new JFrame();
	public Screen(String name){
		this.name = name;
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

