package customListeners;

import static main.mainClass.analysesDataFrame;
import static main.mainClass.analysesFrame;
import static main.mainClass.loginFrame;
import static main.mainClass.requestFrame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import formsAndFrames.AnalysesDataFrame;
import formsAndFrames.AnalysesFrame;

/**
 * custom listener
 * @author DenRUS
 *
 */
public class ExecuteAnalyseListener implements ActionListener{
	AnalysesFrame frame;
	JComboBox firstField,secondField;
	/**
	 * constructor
	 */
	public ExecuteAnalyseListener(AnalysesFrame parent,JComboBox firstField, JComboBox secondField) {
		this.frame = parent;
		this.firstField = firstField;
		this.secondField = secondField;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		this.frame.getAnalysesDataFrame().getDataBaseManager().getResultAsTableFromDBM(, this.frame.)
		try {
			analysesDataFrame = new AnalysesDataFrame(this.frame.getAnalysesDataFrame().getDataBaseManager(), 
					"select * from (" + this.frame.getAnalysesDataFrame().getStorage().getRequest() +
					") t1, (" + this.frame.getAnalysesDataFrame().getStorage().getRequest() + ") t2 where t1." +
							this.firstField.getSelectedItem().toString()+"=t2."+this.secondField.getSelectedItem().toString(), this.frame);
			analysesDataFrame.setVisible(true);
		} catch (SQLException ex) {
			
			JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
			
		} catch (ClassNotFoundException ex1) {
			JOptionPane.showMessageDialog(new JFrame(),ex1.getMessage(),"Error1!", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
