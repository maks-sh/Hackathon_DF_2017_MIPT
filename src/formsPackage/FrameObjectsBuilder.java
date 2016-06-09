package formsPackage;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

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
	
	/**
	 * 
	 * @param name name of the button
	 * @param xLocation x coordinate to set in location
	 * @param yLocation y coordinate to set in location
	 * @param xSize x coordinate size
	 * @param ySize y coordinate size
	 * @return JButton with custom properties
	 */
	public JButton createButton(String name, int xLocation, int yLocation, int xSize, int ySize){
		JButton button = new JButton(name);
		button.setLocation(xLocation, yLocation);
		button.setSize(xSize, ySize);
		return button;
		
	}
	
	
	/**
	 * creating custom label
	 * @param title title of the label
	 * @param xLocation x coordinate to set in location
	 * @param yLocation y coordinate to set in location
	 * @param xSize x coordinate size
	 * @param ySize y coordinate size
	 * @param color color of the label
	 * @return JLabel with custom properties
	 */
	public JLabel createLabel(String title, int xLocation, int yLocation, int xSize, int ySize, Color color) {
		JLabel label = new JLabel(title);
		label.setLocation(xLocation, yLocation);
		label.setSize(xSize,ySize);
		label.setHorizontalAlignment(0);
		label.setForeground(color);
		return label;
	}
	
	/**
	 * creating custom text field
	 * @param name name of the button
	 * @param xLocation x coordinate to set in location
	 * @param yLocation y coordinate to set in location
	 * @param xSize x coordinate size
	 * @param ySize y coordinate size
	 * @return JButton with custom properties
	 */
	public JTextField createTextField (String name, int xLocation, int yLocation, int xSize, int ySize) {
		JTextField textField = new JTextField();
		textField.setBorder(BorderFactory.createTitledBorder(name));
		textField.setLocation(xLocation, yLocation);
		textField.setSize(xSize, ySize);
		return textField;
	}
	
	/**
	 * creating custom password field
	 * @param name name of the button
	 * @param xLocation x coordinate to set in location
	 * @param yLocation y coordinate to set in location
	 * @param xSize x coordinate size
	 * @param ySize y coordinate size
	 * @return JButton with custom properties
	 */
	public JPasswordField createPasswordField (String name, int xLocation, int yLocation, int xSize, int ySize) {
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBorder(BorderFactory.createTitledBorder(name));
		passwordField.setLocation(xLocation, yLocation);
		passwordField.setSize(xSize, ySize);
		return passwordField;
	}
	
	/**
	 * creating custom table
	 * @param name name of the button
	 * @param xLocation x coordinate to set in location
	 * @param yLocation y coordinate to set in location
	 * @param xSize x coordinate size
	 * @param ySize y coordinate size
	 * @return JTable with custom properties
	 */
	public JTable createTable(String name, int xLocation, int yLocation, int xSize, int ySize) {
		String[] columns  = {"Name","Surname"};
		String[][] data = {
				{"LAAL","1"},
				{"NOO","2"},
		};
		JTable table = new JTable(data, columns);
//		table.setBorder(BorderFactory.createTitledBorder(name));
		table.setLocation(xLocation, yLocation);
		table.setSize(xSize, ySize);
		return table;
	}

}
