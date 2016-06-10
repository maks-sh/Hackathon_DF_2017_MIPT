package main;

import javax.swing.JFrame;

import appearanceCustomisation.FrameFactory;
import customListeners.SqlRequestExecuteListener;
import formsAndFrames.AnalysesFrame;
import formsAndFrames.LoginFrame;
import formsAndFrames.SqlRequestFrame;

//TODO javadoc comments and backListener - should show parent, not always login
public class mainClass {
	public static LoginFrame loginFrame;
	public static AnalysesFrame analysesFrame;
	public static SqlRequestFrame requestFrame;
	/**
	 * @deprecated
	 */
	public static FrameFactory frameFactoryManager = new FrameFactory();
//	private static String REQUEST = "select * from hr.employees";
//	private static ResultSet rs = null;
//	private static ConnectionManager connectionManager;
	
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
		
		loginFrame = new LoginFrame(WINDOWSIZE[0], WINDOWSIZE[1]);
		loginFrame.setVisible(true);
		
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