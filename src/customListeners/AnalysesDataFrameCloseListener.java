package customListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * performs hiding of AnalysesDataFrame on pressing back button
 * @author DenRUS
 *
 */
public class AnalysesDataFrameCloseListener implements ActionListener {
	JPanel jPanel;
	/**
	 * default constructor
	 * @param jpanel frame that should be closed
	 */
	public AnalysesDataFrameCloseListener(JPanel jpanel) {
		this.jPanel = jpanel;
	}
	/**
	 * performs hiding
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.jPanel.setVisible(false);
	}

}
