package customListeners;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dbEntities.DataBaseManager;

import static main.mainClass.*;
import formsAndFrames.AnalysesDataFrame;
import formsAndFrames.AnalysesFrame;
import formsAndFrames.SqlRequestFrame;

import java.awt.event.*;
import java.sql.SQLException;

/**
 * 
 * @author DenRUS
 *
 */
public class SqlRequestExecuteListener implements ActionListener {
	DataBaseManager dataBaseManager;
	JTextField sqlRequestField;
	JFrame frame;
	/**
	 * constructor
	 * @param cn connection manager to work with
	 * @param field field to listen on
	 * @param frame parent frame
	 */
	public SqlRequestExecuteListener(DataBaseManager cn, JTextField field, JFrame frame) {
		this.dataBaseManager = cn;
		this.sqlRequestField = field;
		this.frame = frame;
	}
		
	
	/**
	 * Creates and shows analys frame
	 * @param actionEvent every event
	 */
	public void actionPerformed(ActionEvent actionEvent){
		
//		if (analysesFrame == null) {
		try {
			analysesDataFrame = new AnalysesDataFrame(this.dataBaseManager, this.sqlRequestField.getText(), this.frame);
			analysesDataFrame.setVisible(true);
			
			analysesFrame = new AnalysesFrame(this.frame, analysesDataFrame);
			analysesFrame .setVisible(true);
			
			requestFrame.setVisible(false);
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
		
	
