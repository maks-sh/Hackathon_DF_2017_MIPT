package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import dbEntities.ConnectionManager;
import formsPackage.FormAppearance;;

public class mainClass {
	public static JFrame loginFrame = new JFrame();
	public static JFrame analysesFrame;
	public static FormAppearance formAppearanceManager = new FormAppearance();
	private static String REQUEST = "select * from hr.employees";
	private static ResultSet rs = null;
	private static ConnectionManager connectionManager;
	
	/**
	 * size of the main form
	 * @category const
	 */
	private static int[] WINDOWSIZE = {600,200};
	

	
	/**
	 * main method
	 * @param args args of command line
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
//		JFrame mainFrame = new JFrame("Header of the window");

//		FormAppearance formAppearanceManager = new FormAppearance(); 
		
		loginFrame.setContentPane(formAppearanceManager.createContentPaneForLoginFrame());
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(WINDOWSIZE[0],WINDOWSIZE[1]);
		loginFrame.setVisible(true);
		loginFrame.setLocationRelativeTo(null);
	
		
		
	}
	
	
	
	
	/**
	 * temp method for developing
	 */
	public static ResultSet dbConnectionExecute(){
		//db connection code
		try {
			connectionManager= new ConnectionManager();
		} catch (SQLException e) {
			System.out.println("SQLException at creating ConnectionManager object!");
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			System.out.println("ClassNotFoundException at creating ConnectionManager object!");
			e1.printStackTrace();
			connectionManager = new ConnectionManager(false);
		}
		try {
			return connectionManager.executeRequest(REQUEST);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException Error at request executing!");
			e.printStackTrace();
		} catch (SQLException e1) {
			System.out.println("SQLException Error at request executing!");
			e1.printStackTrace();
		}
		return null;
		
	}
	
	
	
	//getters and setters
	/**
	 * @return the wINDOWSIZE
	 */
	public static int[] getWINDOWSIZE() {
		return WINDOWSIZE;
	}
	/**
	 * @param wINDOWSIZE the wINDOWSIZE to set
	 */
	public static void setWINDOWSIZE(int[] wINDOWSIZE) {
		WINDOWSIZE = wINDOWSIZE;
	}

}
//пример диалога/ошибки
////JOptionPane.showMessageDialog(new JFrame(), message,"Some rows", JOptionPane.ERROR_MESSAGE);
