package appearanceCustomisation;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * entity for creating standard frame objects 
 * @author DenRUS
 *
 */
public class FrameObjectsBuilder {
	
	/**
	 * basic constructor
	 */
	public FrameObjectsBuilder(){};
	
	public JButton createButton(String name, int xlocation, int ylocation, int xsize, int ysize){
		JButton button = new JButton(name);
		button.setLocation(xlocation, ylocation);
		button.setSize(xsize, ysize);
		return button;
		
	}
	
	
	/**
	 * creating custom label
	 * @param title title of the label
	 * @param xlocation x coordinate to set in location
	 * @param ylocation y coordinate to set in location
	 * @param xsize x coordinate size
	 * @param ysize y coordinate size
	 * @param color color of the label
	 * @return JLabel with custom properties
	 */
	public JLabel createLabel(String title, int xlocation, int ylocation, int xsize, int ysize, Color color) {
		JLabel label = new JLabel(title);
		label.setLocation(xlocation, ylocation);
		label.setSize(xsize,ysize);
		label.setHorizontalAlignment(0);
		label.setForeground(color);
		return label;
	}

}
