package customListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * performs hiding of AnalysesDataFrame on pressing back button
 * @author DenRUS
 *
 */
public class AnalysesDataFrameCloseListener implements ActionListener {
	JFrame frame;
	/**
	 * default constructor
	 * @param frame frame that should be closed
	 */
	public AnalysesDataFrameCloseListener(JFrame frame) {
		this.frame = frame;	
	}
	/**
	 * performs hiding
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.setVisible(false);		
	}

}
