package formsAndFrames;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import customListeners.AnalysesDataFrameCloseListener;
import customListeners.BackListener;
import customListeners.ExecuteAnalyseListener;
import customListeners.SqlRequestExecuteListener;
import dbEntities.DataBaseManager;
import dbEntities.RSAndRSMDStorage;

/**
 * Frame for performing analyses
 * @author DenRUS
 *
 */
public class AnalysesFrame extends JFrame {
	/**
	 * connected analysesDataFrame
	 */
	AnalysesDataFrame analysesDataFrame;
	/**
	 * rs and rsmd storage
	 */
	RSAndRSMDStorage storage;

	/**
	 * constructor - creating specific Frame for analyses
//	 * @param cn databasemanager
//	 * @param sqlRequest request to execute
	 * @param parent frame
	 * @return frame for analyses
	 * @throws SQLException if smth wrong with SQL part of the connection
	 * @throws ClassNotFoundException if smth wrong with JDBC
	 */
	public AnalysesFrame (JFrame parent, AnalysesDataFrame connectedFrame) throws ClassNotFoundException, SQLException {
		this.analysesDataFrame = connectedFrame;
		JFrame.setDefaultLookAndFeelDecorated(true);
		int xSize = 470, ySize = 170;
		this.setTitle("Form for analyses");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(this.createContentPaneForAnalysesFrame(parent));
		this.setSize(xSize, ySize);
        this.setLocationRelativeTo(null);
	}
	/**
	 * creates a content pane for the frame
	 * @param parent parent frame to show in case of "back"
	 * @return custom JPanel
	 * @throws SQLException if smth is wrong with SQL part
	 */
	public JPanel createContentPaneForAnalysesFrame(JFrame parent) throws SQLException {
		FrameObjectsBuilder builder = new FrameObjectsBuilder();
		
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);
		totalGUI.setBorder(BorderFactory.createTitledBorder("Choose action:"));
		
		JButton backButton = builder.createButton("Back", 300, 90, 150, 30);
		ActionListener backListener = new BackListener(this,parent);
		backButton.addActionListener(backListener);
		backButton.addActionListener(new AnalysesDataFrameCloseListener(this.analysesDataFrame));
		
		
		
		String[] possibleActions = {"����� ����������"};
		JComboBox actions = builder.createComboBox(possibleActions, 20, 20, 200, 30);
		
		String[] columnNames;
		columnNames = new String[this.analysesDataFrame.getStorage().getResultSetMetaData().getColumnCount()];
		for (int i = 0; i < columnNames.length; i++) {
			columnNames[i] = this.analysesDataFrame.getStorage().getResultSetMetaData().getColumnName(i + 1);
		}
		/**
		 * first field to analyse
		 */
		JComboBox firstField = builder.createComboBox(columnNames, 20, 60, 200, 30);
		
		/**
		 * second field to analyse
		 */
		JComboBox secondField = builder.createComboBox(columnNames, 20, 100, 200, 30);
		
		JButton executeButton = builder.createButton("Execute actions", 300, 30, 150, 30);
		executeButton.addActionListener(new ExecuteAnalyseListener(this, firstField, secondField));
		
		totalGUI.add(executeButton);
		totalGUI.add(backButton);
		totalGUI.add(actions);
		totalGUI.add(firstField);
		totalGUI.add(secondField);
		return totalGUI;
	}
	/**
	 * @return the analysesDataFrame
	 */
	public AnalysesDataFrame getAnalysesDataFrame() {
		return analysesDataFrame;
	}
	/**
	 * @param analysesDataFrame the analysesDataFrame to set
	 */
	public void setAnalysesDataFrame(AnalysesDataFrame analysesDataFrame) {
		this.analysesDataFrame = analysesDataFrame;
	}
}


