package dbEntities;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class RSAndRSMDStorage {
	/**
	 * result set
	 */
	ResultSet resultSet;
	/**
	 * @return the resultSet
	 */
	public ResultSet getResultSet() {
		return resultSet;
	}
	/**
	 * @param resultSet the resultSet to set
	 */
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	/**
	 * result set metadata
	 */
	ResultSetMetaData resultSetMetaData;
	/**
	 * @return the resultSetMetaData
	 */
	public ResultSetMetaData getResultSetMetaData() {
		return resultSetMetaData;
	}
	/**
	 * @param resultSetMetaData the resultSetMetaData to set
	 */
	public void setResultSetMetaData(ResultSetMetaData resultSetMetaData) {
		this.resultSetMetaData = resultSetMetaData;
	}
	String request;
	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}
}
