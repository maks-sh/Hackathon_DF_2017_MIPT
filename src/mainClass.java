
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import dbEntities.ConnectionManager;
import formsPackage.MainFormAppearance;;

public class mainClass {
	static String REQUEST = "select * from hr.employees";
	static ResultSet rs = null;
	static ConnectionManager connectionManager;

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame mainFrame = new JFrame("Header of the window");

//		Создаем поверхность для размещения компонентов

		MainFormAppearance demo = new MainFormAppearance(); // Внешность формы

		
		mainFrame.setContentPane(demo.createContentPane());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1200,800);
		mainFrame.setVisible(true);

		
		
	}
	
	/**
	 * temp method for developing
	 */
	public static void dbConnectionExecute(){
		System.out.println("ASD");
		
		//db connection code
		try {
			connectionManager= new ConnectionManager();
		} catch (SQLException e) {
			System.out.println("SQLException at creating ConnectionManager object!");
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			System.out.println("ClassNotFoundException at creating ConnectionManager object!");
			e1.printStackTrace();
		} finally {
			if (connectionManager == null) {
				connectionManager = new ConnectionManager(false);
			}
		}
		try {
			rs = connectionManager.executeRequest(REQUEST);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException Error at request executing!");
			e.printStackTrace();
		} catch (SQLException e1) {
			System.out.println("SQLException Error at request executing!");
			e1.printStackTrace();
		}
		try {
			connectionManager.printResultSet(rs);
		} catch (SQLException e){
			System.out.println("Error at printing resultSet!");
			e.printStackTrace();
		}
	}
}
