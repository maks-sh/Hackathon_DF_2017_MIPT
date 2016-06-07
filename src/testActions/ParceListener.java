package testActions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.*;

/**
 * 
 * @author DenRUS
 *
 */
public class ParceListener implements ActionListener {
	
	/**
	 * @param actionEvent every event
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		
		//text of message
		String message = "Button 2 is pressed";
		//message output
			JOptionPane.showMessageDialog(new JFrame(),	message, "Message by 2", JOptionPane.ERROR_MESSAGE);
	}
		
	
}
