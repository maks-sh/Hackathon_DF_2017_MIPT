package testActions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.*;


/**
 * custom action listener
 * @author DenRUS
 *
 */
public class TestActionListener implements ActionListener {
	
	
	/**
	 * actions to perform on every(?) event
	 * @param actionEvent
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		//generates message with some rows
		
		String message = "string1\n"
				+"string2\n"
				+"string3";
		JOptionPane.showMessageDialog(new JFrame(), message,"Some rows", JOptionPane.ERROR_MESSAGE);
		
	}

}
