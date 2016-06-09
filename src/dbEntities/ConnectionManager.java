package dbEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 
 * @author DenRUS
 * class for work with DB
 */
public class ConnectionManager {
	private Connection dbConnection = null;
	private String user = "den",pass = "parol123",dataBase = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	/**
	 * @category testing
	 * constructor without creating a connection
	 * @param b 
	 */
	public ConnectionManager(boolean b){}

	/**
	 * constructor with creating default connection
	 * @return ConnectionManager object with created connection
	 */
	public ConnectionManager() throws SQLException, ClassNotFoundException{		
		setDbConnection(getDBConnection());
	}
	
	/**
	 * 
	 * @param user username for connection to DB
	 * @param pass password of the user
	 * @return ConnectionManager object with created connection
	 */
	public ConnectionManager(String user, String pass) throws SQLException,ClassNotFoundException{
		this.user = user;
		this.pass = pass;
		setDbConnection(getDBConnection());
	}
	
	
	/**
	 * get connection with default parameters
	 * @return connection object
	 */
	public Connection getDBConnection() throws SQLException, ClassNotFoundException{
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
	 * execute the request
	 * @param sqlRequest request to execute
	 * @return ResultSet - the result
	 * @throws SQLException if smth is not ok
	 */
	public ResultSet executeRequest(String sqlRequest) throws SQLException,ClassNotFoundException{
			return this.getDBConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sqlRequest);
	}
	
	/**
	 * printing a ResultSet
	 * @param rs data to print
	 * @throws SQLException if smth is not ok =)
	 */
	public void printResultSet(ResultSet rs) throws SQLException{
		ResultSetMetaData metaData = rs.getMetaData();
		System.out.println(metaData.getTableName(1));
		String[] columns = new String[metaData.getColumnCount()];
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			columns[i-1] = metaData.getColumnName(i);
			System.out.print(columns[i-1]+"			|			");
		}
		while (rs.next()){
			System.out.println();
			for (int j = 1; j<= metaData.getColumnCount(); j++){
				System.out.print(rs.getString(j)+"			|			");
			}
		}
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
