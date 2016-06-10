package customListeners;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dbEntities.DataBaseManager;

import static main.mainClass.*;
import formsAndFrames.AnalysesFrame;

import java.awt.event.*;
import java.sql.SQLException;

/**
 * 
 * @author DenRUS
 *
 */
public class SqlRequestExecuteListener implements ActionListener {
	DataBaseManager connectionManager;
	JTextField sqlRequestField;
	/**
	 * constructor
	 * @param cn connection manager to work with
	 * @param field field to listen on
	 */
	public SqlRequestExecuteListener(DataBaseManager cn, JTextField field) {
		this.connectionManager = cn;
		this.sqlRequestField = field;
	}
		
	
	/**
	 * @param actionEvent every event
	 */
	public void actionPerformed(ActionEvent actionEvent){
		
//		if (analysesFrame == null) {
		try {
			analysesFrame = new AnalysesFrame(this.connectionManager, this.sqlRequestField.getText());
			analysesFrame.setVisible(true);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
			loginFrame.setVisible(true);
			
		} catch (ClassNotFoundException ex1) {
			JOptionPane.showMessageDialog(new JFrame(),ex1.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
			loginFrame.setVisible(true);
		}
//		} else {
//			analysesFrame.setVisible(true);
//		}
	}
}
		
	
