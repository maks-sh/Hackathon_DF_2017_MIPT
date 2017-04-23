package formsAndFrames;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import customListeners.BackListener;
import customListeners.LoginListener;

/**
 * login frame of the program
 * @author DenRUS
 *
 */
public class LoginFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * creates a login frame
	 * @param preferdXSize x size of the frame
	 * @param preferdYSize y size of the frame
	 * @return login frame with mentioned parameters
	 */
	public LoginFrame(int preferdXSize, int preferdYSize) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setContentPane(this.createContentPaneForLoginFrame(preferdXSize,preferdYSize));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(preferdXSize,preferdYSize);
		this.setLocationRelativeTo(null);
	}
	/**
	 * creating custom JPanel for login
	 * @return JPanel with custom options
	 */
	public JPanel createContentPaneForLoginFrame(int mainFrameLength, int mainFrameHeight) {
		/**
		 * creating custom objects constructor
		 */
		FrameObjectsBuilder builder = new FrameObjectsBuilder();
		/**
		 * First, creating panel, 
		 * where other components should be placed
		*/
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);
		totalGUI.setBorder(BorderFactory.createTitledBorder("Hello! This program should be used for work with table of DB Oracle."));
		/**
		 * Adding text field for username
		 */
		JTextField userNameField = builder.createTextField("Username", mainFrameLength - 500, 20, 150, 50);
		//TODO just for test
		userNameField.setText("hack_user");
		/**
		 * Adding password field for user
		 */
		JTextField passwordField = builder.createPasswordField("Password", mainFrameLength - 325, 20, 150, 50);
		//TODO just for tests
		passwordField.setText("hack#421");
		
		/**
		 * Adding sqlRequest field
		 */
		JTextField dataBaseField = builder.createTextField("Database", mainFrameLength - 500, 80, 325, 50);
		//TODO just for tests
		dataBaseField.setText("jdbc:oracle:thin:@10.55.167.22:1521:hack01");
				
		/**
		 * creating connection button
		 */
		JButton connectButton = builder.createButton("Connect", mainFrameLength - 150, 30, 100, 30);
		//creating action listener
		ActionListener loginListener = new LoginListener(userNameField,passwordField,dataBaseField, this);
		//adding action listener to button
		connectButton.addActionListener(loginListener);//link action to the button
		
		
		/**
		 * creating exit button
		 */
		JButton exitButton = builder.createButton("Exit", mainFrameLength - 150, mainFrameHeight - 100, 100, 30);
		ActionListener exitListener = new BackListener(this,null);
		exitButton.addActionListener(exitListener);
        
		/**
		 * adding objects to the pane
		 */
		totalGUI.add(passwordField);
		totalGUI.add(userNameField);
		totalGUI.add(dataBaseField);
		totalGUI.add(connectButton);
		totalGUI.add(exitButton);
			
		return totalGUI;
	}
}
