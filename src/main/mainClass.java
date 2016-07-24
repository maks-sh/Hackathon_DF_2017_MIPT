package main;

import javax.swing.JFrame;

import appearanceCustomisation.FrameFactory;
import customListeners.SqlRequestExecuteListener;
import formsAndFrames.AnalysesDataFrame;
import formsAndFrames.LoginFrame;
import formsAndFrames.SqlRequestFrame;
import formsAndFrames.AnalysesFrame;

//TODO javadoc comments and backListener - should show parent, not always login
public class mainClass {
	/**
	 * login frame of the program
	 */
	public static LoginFrame loginFrame;
	/**
	 * analyses data frame of the program
	 */
	public static AnalysesDataFrame analysesDataFrame;
	/**
	 * request frame of the program
	 */
	public static SqlRequestFrame requestFrame;
	/**
	 * analyses frame of the program
	 */
	public static AnalysesFrame analysesFrame;
	
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