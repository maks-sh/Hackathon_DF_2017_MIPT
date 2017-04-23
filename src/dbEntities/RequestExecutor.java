package dbEntities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import formsAndFrames.AnalysesDataFrame;

/**
 * entity to perform sql requests
 * 
 * @author DenRUS
 *
 */
public interface RequestExecutor {

	/**
	 * return the result of the request as a JTable
	 * 
	 * @param cn
	 *            connection to work with
	 * @param sqlRequest
	 *            request to execute
	 * @param storage a place to save rs and rsmd
	 * @return JTable with the results
	 * @throws ClassNotFoundException
	 *             if smth goes wrong
	 * @throws SQLException
	 *             if smth goes wrong with SQL part
	 */
	public default JTable getResultAsTable(Connection cn, String sqlRequest, RSAndRSMDStorage storage)
			throws ClassNotFoundException, SQLException {
		String[] columnNames;
		Object[][] data;
		ResultSet rs = this.executeRequest(cn, sqlRequest);
		ResultSetMetaData metaData = rs.getMetaData();
		storage.setResultSet(rs);
		storage.setResultSetMetaData(metaData);
		storage.setRequest(sqlRequest);
		columnNames = new String[metaData.getColumnCount()];
		for (int i = 0; i < columnNames.length; i++) {
			columnNames[i] = metaData.getColumnName(i + 1);
		}
		;
		int rowCount = 0;
		rs.last();
		rowCount = rs.getRow();
		rs.beforeFirst();
		data = new String[rowCount][columnNames.length];
		while (rs.next()) {
			rowCount--;
			for (int j = 0; j < columnNames.length; j++) {
				data[rowCount][j] = rs.getString(j + 1);
			}
		}

		JTable table = new JTable(data, columnNames);
		return table;

	}

	/**
	 * execute the request
	 * 
	 * @param sqlRequest
	 *            request to execute
	 * @return ResultSet - the result
	 * @throws SQLException
	 *             if smth is not ok
	 */
	public default ResultSet executeRequest(Connection cn, String sqlRequest)
			throws SQLException, ClassNotFoundException {
		return cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sqlRequest);
	}

	/**
	 * printing a ResultSet
	 * 
	 * @param rs
	 *            data to print
	 * @throws SQLException
	 *             if smth is not ok =)
	 */
	public default void printResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		System.out.println(metaData.getTableName(1));
		String[] columns = new String[metaData.getColumnCount()];
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			columns[i - 1] = metaData.getColumnName(i);
			System.out.print(columns[i - 1] + "			|			");
		}
		while (rs.next()) {
			System.out.println();
			for (int j = 1; j <= metaData.getColumnCount(); j++) {
				System.out.print(rs.getString(j) + "			|			");
			}
		}
	}

}
