package formsAndFrames;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import customListeners.BackListener;
import customListeners.SqlRequestExecuteListener;
import dbEntities.DataBaseManager;

/**
 * request frame
 * @author DenRUS
 *
 */
public class SqlRequestFrame extends JFrame{
	DataBaseManager dbManager;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor - creates frame for user to perform a sql request
	 * @param userName user
	 * @param password pass of the user
	 * @throws SQLException smth wrong with SQL part
	 * @throws ClassNotFoundException smth wrong with JDBC
	 */
	public SqlRequestFrame(String userName, String password, String database,JFrame parent) throws ClassNotFoundException, SQLException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.dbManager = new DataBaseManager(userName,password,database);
		int xSize = 620, ySize = 170;
		this.setTitle(userName);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(this.createContentPaneForSqlRequestFrame(userName,parent));
		this.setSize(xSize, ySize);
        this.setLocationRelativeTo(null);
    }
	
	/**
	 * creates a content pane for the frame
	 * @param user user connected to the data base
	 * @param parent parent frame to show in case of "back"
	 * @return custom JPanel
	 */
	public JPanel createContentPaneForSqlRequestFrame(String user,JFrame parent) {
		FrameObjectsBuilder builder = new FrameObjectsBuilder();
		
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);
		totalGUI.setBorder(BorderFactory.createTitledBorder("You are connected as: \""+user+"\""));
		
		JButton backButton = builder.createButton("Back", 450, 90, 150, 30);
		ActionListener backListener = new BackListener(this,parent);
		backButton.addActionListener(backListener);
		
		JTextField sqlRequestField = builder.createTextField("SQL Request", 20, 20, 400, 50);
		//TODO just for tests
		sqlRequestField.setText("select * from customers");
		
		JButton executeButton = builder.createButton("Execute request", 450, 30, 150, 30);
		ActionListener sqlRequestExecute = new SqlRequestExecuteListener(dbManager,sqlRequestField, this);
		executeButton.addActionListener(sqlRequestExecute);
		
		totalGUI.add(executeButton);
		totalGUI.add(sqlRequestField);
		totalGUI.add(backButton);
		return totalGUI;
	}
	

}
