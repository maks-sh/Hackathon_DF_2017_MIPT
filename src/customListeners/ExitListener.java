package customListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import static main.mainClass.*;

/**
 * listener for 3rd button (test)
 * @author DenRUS
 *
 */
public class ExitListener implements ActionListener {
	/**
	 * frame to close
	 */
	JFrame frame,parent;
	
	/**
	 * associates the frame with the listener
	 * @param frame
	 */
	public ExitListener(JFrame frame,JFrame parent) {
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
			//TODO check on memory errors. (Is the frame killed by setting the visability "false"?)
			this.frame.setVisible(false);
			this.parent.setVisible(true);
		}
	}

}
