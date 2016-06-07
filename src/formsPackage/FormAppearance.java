package formsPackage;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import testActions.*;
import appearanceCustomisation.FrameObjectsBuilder;
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
		 *where other components should be placed
		*/
		JPanel totalGUI = new JPanel(); // creating panel
		totalGUI.setLayout(null);
		
		//creating border
		totalGUI.setBorder(BorderFactory.createTitledBorder("Hello! This program should be used for work with table of DB Oracle."));
		
//		/**
//		 * creating greetings label
//		 */
//		JLabel greetingLabel = builder.createLabel("Hello! This program should be used for work with table of DB Oracle.", 0, -25, 500, 100, Color.blue);
//		totalGUI.add(greetingLabel); //adding textlabel to the panel
		
		
		/**
		 * Adding text field for username
		 */
		JTextField userNameField = builder.createTextField("Username", MainFrameLength - 500, 20, 150, 50);
		
		/**
		 * Adding password field for user
		 */
		JTextField passwordField = builder.createTextField("Password", MainFrameLength - 325, 20, 150, 50);
				
		/**
		 * creating connection button
		 */
		JButton connectButton = builder.createButton("Connect", MainFrameLength - 150, 30, 100, 30);
		//creating action listener
		ActionListener actionListener = new TestActionListener();
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
		totalGUI.add(connectButton);
		totalGUI.add(exitButton);
//		totalGUI.add(mainTable);
			
		return totalGUI;
	}
	
	/**
	 * creating s scroll Frame for analyses frame
	 * @return
	 */
	public JFrame createScrollFrameForManeFrame () {
		JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames;
        Object[][] data;
        try {
        	ResultSet rs = mainClass.dbConnectionExecute();
        	ResultSetMetaData metaData = rs.getMetaData();
        	columnNames = new String[metaData.getColumnCount()];
        	for (int i = 0; i < columnNames.length; i++) {
        		columnNames[i] = metaData.getColumnName(i+1);
            };
            int rowCount = 0;
            try {
                rs.last();
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            catch(SQLException ex) {
            	System.out.println("Exception at row counting!");
                ex.printStackTrace();;
            }
            System.out.println(rowCount+"    "+columnNames.length);
          	data = new String[rowCount][columnNames.length];
          	while (rs.next()) {
          		rowCount--;
          		for (int j = 0; j < columnNames.length; j++){
            		data[rowCount][j] = rs.getString(j+1);
            		}
          	}
        	
        } catch (SQLException e) {
        	System.out.println("Exception with DB access!");
        	e.printStackTrace();
        	columnNames = null;
        	data = null;
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