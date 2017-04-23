package customListeners;

import javax.swing.*;

import dbEntities.DataBaseManager;

import static main.mainClass.*;
import formsAndFrames.AnalysesDataFrame;
import formsAndFrames.AnalysesFrame;
import formsAndFrames.SqlRequestFrame;

import java.awt.*;
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
//		try {
//			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//
//			JFrame frame = new JFrame("DocumentEventDemo");
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			frame.setSize(dimension);
//
////			analysesDataFrame = new AnalysesDataFrame(this.dataBaseManager, this.sqlRequestField.getText(), this.frame,"report1");
//			JComponent newContentPane = analysesDataFrame;
//			newContentPane.setOpaque(true); // content panes must be opaque
//			frame.setContentPane(newContentPane);
//			// Display the window.
//			frame.pack();
//			frame.setVisible(true);
//
//			// Display in center
//			int x = (int) ((dimension.getWidth() - frame.getWidth()) / 3);
//			int y = (int) ((dimension.getHeight() - frame.getHeight()) / 3);
//			frame.setLocation(x, y);
//
//
//
//
//			requestFrame.setVisible(false);
//		} catch (SQLException ex) {
//			JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
//			loginFrame.setVisible(true);
//
//		} catch (ClassNotFoundException ex1) {
//			JOptionPane.showMessageDialog(new JFrame(),ex1.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
//			loginFrame.setVisible(true);
//		}
//		} else {
//			analysesFrame.setVisible(true);
//		}
	}
}


