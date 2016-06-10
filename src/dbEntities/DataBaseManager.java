package dbEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTable;

/**
 * 
 * @author DenRUS
 * class for work with DB
 */
public class DataBaseManager implements RequestExecutor {
	private Connection dbConnection = null;
	private String user = "den",pass = "parol123",dataBase = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	/**
	 * @category testing
	 * constructor without creating a connection
	 * @param b 
	 */
	public DataBaseManager(boolean b){}

	/**
	 * constructor with creating default connection
	 * @return ConnectionManager object with created connection
	 */
	public DataBaseManager() throws SQLException, ClassNotFoundException{		
		setDbConnection(createDBConnection());
	}
	
	/**
	 * 
	 * @param user username for connection to DB
	 * @param pass password of the user
	 * @return ConnectionManager object with created connection
	 */
	public DataBaseManager(String user, String pass) throws SQLException,ClassNotFoundException{
		this.user = user;
		this.pass = pass;
		setDbConnection(createDBConnection());
	}
	
	public DataBaseManager(String user, String pass,String db) throws SQLException,ClassNotFoundException{
		this.user = user;
		this.pass = pass;
		this.dataBase = db;
		setDbConnection(createDBConnection());
	}
	
	/**
	 * get connection with default parameters
	 * @return connection object
	 */
	public Connection createDBConnection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		dbConnection = DriverManager.getConnection(this.dataBase, this.user, this.pass);
		return dbConnection;
	}
	
	/**
	 * get connection with custom parameters
	 * @param dataBase database name to connect
	 * @param user username to connect
	 * @param pass password of the user
	 * @return
	 */
	public Connection createDBConnection(String dataBase,String user, String pass) throws SQLException,ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		dbConnection = DriverManager.getConnection(dataBase, user, pass);
		return dbConnection;
	}

	/**
	 * 
	 * @param sqlRequest
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public JTable getResultAsTableFromDBM(String sqlRequest) throws ClassNotFoundException, SQLException {
		return this.getResultAsTable(dbConnection, sqlRequest);
	}
	

	
	//only getters and setters below

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the dbConnection
	 */
	public Connection getDbConnection() {
		return dbConnection;
	}

	/**
	 * @param dbConnection the dbConnection to set
	 */
	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	/**
	 * 
	 * @return the dataBase
	 */
	public String getDataBase() {
		return dataBase;
	}
	
	/**
	 * 
	 * @param dataBase the dataBase to set
	 */
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}
}
