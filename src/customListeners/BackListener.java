package customListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import static main.mainClass.*;

/**
 * listener for backButton
 * @author DenRUS
 *
 */
public class BackListener implements ActionListener {
	/**
	 * frame to close and frame to show
	 */
	JFrame frame,parent;
	
	/**
	 * associates the frame with the listener
	 * @param frame
	 */
	public BackListener(JFrame frame,JFrame parent) {
		this.frame = frame;	
		this.parent = parent;
	}
	
	/**
	 * performs closing
	 */
	public void actionPerformed(ActionEvent e) {
		if (loginFrame.equals(this.frame)) {
			System.exit(1);
		} else {
			//todo
			this.frame.setVisible(false);
			this.parent.setVisible(true);
		}
	}

}
