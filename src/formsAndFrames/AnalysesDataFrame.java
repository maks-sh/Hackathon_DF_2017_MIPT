package formsAndFrames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import customListeners.BackListener;
import dbEntities.DataBaseManager;
import dbEntities.RSAndRSMDStorage;

/**
 * analyses frame of the program
 * @author DenRUS
 *
 */
public class AnalysesDataFrame extends JFrame {
	
	/**
	 * rs and rsmd storage
	 */
	RSAndRSMDStorage storage;

	
	/**
	 * data base manager for this frame
	 */
	DataBaseManager dataBaseManager;
	
	/**
	 * constructor - creating scroll Frame for analyses
	 * @return Scroll frame for analyses
	 * @throws SQLException if smth wrong with SQL part of the connection
	 * @throws ClassNotFoundException if smth wrong with JDBC
	 */
	public AnalysesDataFrame (DataBaseManager dbManager, String sqlRequest, JFrame parent) throws ClassNotFoundException, SQLException {
		storage = new RSAndRSMDStorage();
		this.setTitle(sqlRequest);
		this.dataBaseManager = dbManager;
//		TODO: show previous(sqlRequestFrame) on close
//        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
        JScrollPane scrollPane = new JScrollPane(dbManager.getResultAsTableFromDBM(sqlRequest,this.storage));
         
        this.getContentPane().add(scrollPane);
        this.setPreferredSize(new Dimension(800, 500));
        this.pack();
        this.setLocationRelativeTo(null);
	}
	/**
	 * @return the dataBaseManager
	 */
	public DataBaseManager getDataBaseManager() {
		return dataBaseManager;
	}
	/**
	 * @param dataBaseManager the dataBaseManager to set
	 */
	public void setDataBaseManager(DataBaseManager dataBaseManager) {
		this.dataBaseManager = dataBaseManager;
	}
	/**
	 * @return the storage
	 */
	public RSAndRSMDStorage getStorage() {
		return storage;
	}
	/**
	 * @param storage the storage to set
	 */
	public void setStorage(RSAndRSMDStorage storage) {
		this.storage = storage;
	}
}

