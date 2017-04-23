package formsAndFrames;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

import customListeners.BackListener;
import customListeners.ReportExecListener;
import customListeners.SqlRequestExecuteListener;
import dbEntities.DataBaseManager;
import javafx.scene.control.CheckBox;

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
		int xSize = 700, ySize = 170;
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

		JButton backButton = builder.createButton("Back", 450, 90, 100, 30);
		ActionListener backListener = new BackListener(this,parent);
		backButton.addActionListener(backListener);

		JTextField reportMonth = builder.createTextField("Month", 430, 20, 100, 50);
		reportMonth.setText(new SimpleDateFormat("MM").format(new Date()));

		JTextField reportYear = builder.createTextField("Year", 550, 20, 100, 50);
		reportYear.setText(new SimpleDateFormat("yyyy").format(new Date()));

//		JButton executeButton = builder.createButton("Execute request", 450, 30, 150, 30);
//		ActionListener sqlRequestExecute = new SqlRequestExecuteListener(dbManager,sqlRequestField, this);
//		executeButton.addActionListener(sqlRequestExecute);

		JButton report1 = builder.createButton("Обязательный отчет по недвижимости",20,20,400,50);
		report1.addActionListener(new ReportExecListener(dbManager, report1.getText(), this, reportMonth, reportYear));

		JButton report2 = builder.createButton("Подозрительные счета",20,80,400,50);
		report2.addActionListener(new ReportExecListener(dbManager, report2.getText(), this, reportMonth, reportYear));

		JCheckBox checkBox = new JCheckBox();
		checkBox.setLocation(550,90);

//		totalGUI.add(executeButton);
		totalGUI.add(reportMonth);
		totalGUI.add(reportYear);
		totalGUI.add(report1);
		totalGUI.add(report2);
		totalGUI.add(backButton);
		totalGUI.add(checkBox);
		checkBox.setLocation(550,90);
		return totalGUI;
	}
}
