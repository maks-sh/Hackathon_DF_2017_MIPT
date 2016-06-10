package customListeners;

import static main.mainClass.*;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import formsAndFrames.AnalysesFrame;
import formsAndFrames.SqlRequestFrame;


/**
 * custom action listener
 * @author DenRUS
 *
 */
public class LoginListener implements ActionListener {
	JTextField userName;
	JTextField password;
	JTextField dataBaseName;
	JFrame frame;
	
	/**
	 * default constructor 
	 * @param unf text field with username
	 * @param pf text field with password
	 * @param srf text field with sql request
	 */
	public LoginListener(JTextField unf, JTextField pf, JTextField srf,JFrame frame) {
		this.userName = unf;
		this.password = pf;
		this.dataBaseName = srf;
		this.frame = frame;
	}
	
	
	/**
	 * actions to perform on event
	 * @param actionEvent
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		loginFrame.setVisible(false);
		
//		if (requestFrame == null) {
			try {
				requestFrame = new SqlRequestFrame(this.userName.getText(),this.password.getText(),this.dataBaseName.getText(),this.frame);
				requestFrame.setVisible(true);
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
				loginFrame.setVisible(true);
				
			} catch (ClassNotFoundException ex1) {
				JOptionPane.showMessageDialog(new JFrame(),ex1.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
				requestFrame.setVisible(true);
			}
//		} else {
//			requestFrame.setVisible(true);
//		}
	}

}
