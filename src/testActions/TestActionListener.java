package testActions;

import static main.mainClass.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * custom action listener
 * @author DenRUS
 *
 */
public class TestActionListener implements ActionListener {
	JTextField userNameField;
	JTextField passwordField;
	JTextField sqlRequestField;
	
	/**
	 * default constructor 
	 * @param unf text field with username
	 * @param pf text field with password
	 * @param srf text field with sql request
	 */
	public TestActionListener(JTextField unf, JTextField pf, JTextField srf) {
		this.userNameField = unf;
		this.passwordField = pf;
		this.sqlRequestField = srf;		
	}
	
	
	/**
	 * actions to perform on event
	 * @param actionEvent
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		loginFrame.setVisible(false);
		if (analysesFrame == null) {
			try {
				analysesFrame = formAppearanceManager.createScrollFrameForAnalyses(userNameField, passwordField, sqlRequestField);
				analysesFrame.setVisible(true);
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
				loginFrame.setVisible(true);
				
			} catch (ClassNotFoundException ex1) {
				
			}
		} else {
			analysesFrame.setVisible(true);
		}
	}

}
