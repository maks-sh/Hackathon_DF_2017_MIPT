package testActions;

import static main.mainClass.*;
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
		loginFrame.setVisible(false);
		if (analysesFrame == null) {
			analysesFrame = formAppearanceManager.createScrollFrameForManeFrame();
		}
		analysesFrame.setVisible(true);
		

		
		
	}

}
