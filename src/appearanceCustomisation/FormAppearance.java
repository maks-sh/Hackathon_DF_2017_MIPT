package appearanceCustomisation;
import javax.swing.*;

import dbEntities.ConnectionManager;
import formsPackage.FrameObjectsBuilder;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import testActions.*;
import main.mainClass;

public class FormAppearance {
	
	/**
	 * creating custom JPanel for login
	 * @return JPanel with custom options
	 */
	public JPanel createContentPaneForLoginFrame() {
		/**
		 * getting main frame measurements
		 */
		int MainFrameLength = mainClass.getWINDOWSIZE()[0], MainFrameHeight = mainClass.getWINDOWSIZE()[1];
		/**
		 * creating custom objects constructor
		 */
		FrameObjectsBuilder builder = new FrameObjectsBuilder();
	
		
		
		/**
		 * First, creating panel, 
		 * where other components should be placed
		*/
		JPanel totalGUI = new JPanel(); // creating panel
		totalGUI.setLayout(null);
		
		//creating border
		totalGUI.setBorder(BorderFactory.createTitledBorder("Hello! This program should be used for work with table of DB Oracle."));
		
		
		
		/**
		 * Adding text field for username
		 */
		JTextField userNameField = builder.createTextField("Username", MainFrameLength - 500, 20, 150, 50);
		//just for tests
		userNameField.setText("den");
		
		/**
		 * Adding password field for user
		 */
		JTextField passwordField = builder.createTextField("Password", MainFrameLength - 325, 20, 150, 50);
		//just for tests
		passwordField.setText("parol123");
		
		/**
		 * Adding sqlRequest field
		 */
		JTextField sqlRequestField = builder.createTextField("SQL Request", MainFrameLength - 500, 80, 325, 50);
		//just for tests
		sqlRequestField.setText("select * from hr.employees");
				
		/**
		 * creating connection button
		 */
		JButton connectButton = builder.createButton("Connect", MainFrameLength - 150, 30, 100, 30);
		//creating action listener
		ActionListener actionListener = new TestActionListener(userNameField,passwordField,sqlRequestField);
		//adding action listener to button
		connectButton.addActionListener(actionListener);//link action to the button
		
		
		/**
		 * creating exit button
		 */
		JButton exitButton = builder.createButton("Exit", MainFrameLength - 150, MainFrameHeight - 100, 100, 30);
		ActionListener csvListener = new CsvListener();
		exitButton.addActionListener(csvListener);
        
		/**
		 * adding objects to the pane
		 */
		totalGUI.add(passwordField);
		totalGUI.add(userNameField);
		totalGUI.add(sqlRequestField);
		totalGUI.add(connectButton);
		totalGUI.add(exitButton);
			
		return totalGUI;
	}
	
	/**
	 * creating scroll Frame for analyses
	 * @return
	 * @throws SQLException if smth wrong with SQL part of the connection
	 * @throws ClassNotFoundException if smth wrong with JDBC
	 */
	public JFrame createScrollFrameForAnalyses (JTextField userNameField, JTextField passwordField, JTextField sqlRequestField) throws ClassNotFoundException, SQLException {
		JFrame frame = new JFrame(/*"Analys frame"*/sqlRequestField.getText());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames;
        Object[][] data;
        ConnectionManager cm = new ConnectionManager(userNameField.getText(),passwordField.getText());
        	ResultSet rs = cm.executeRequest(sqlRequestField.getText());
        	ResultSetMetaData metaData = rs.getMetaData();
        	columnNames = new String[metaData.getColumnCount()];
        	for (int i = 0; i < columnNames.length; i++) {
        		columnNames[i] = metaData.getColumnName(i+1);
            };
            int rowCount = 0;
                rs.last();
                rowCount = rs.getRow();
                rs.beforeFirst();
//            System.out.println(rowCount+"    "+columnNames.length);
          	data = new String[rowCount][columnNames.length];
          	while (rs.next()) {
          		rowCount--;
          		for (int j = 0; j < columnNames.length; j++){
            		data[rowCount][j] = rs.getString(j+1);
            		}
          	}
        	
        JTable table = new JTable(data, columnNames);
         
        JScrollPane scrollPane = new JScrollPane(table);
         
        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
		
	}
}