package formsAndFrames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import customListeners.BackListener;
import dbEntities.DataBaseManager;
import dbEntities.RSAndRSMDStorage;

/**
 * analyses frame of the program
 * @author DenRUS
 *
 */
public class AnalysesDataFrame extends JPanel implements ActionListener,CellEditorListener{
	
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
	public  AnalysesDataFrame (DataBaseManager dbManager, JScrollPane jScrollPane, JFrame parent,String reportName) throws ClassNotFoundException, SQLException {


		JPanel jPanel = new JPanel();
		JTable jTable=new JTable();
		storage = new RSAndRSMDStorage();
		this.dataBaseManager = dbManager;

		JButton button = new JButton("Save");
		button.addActionListener(this);
		Checkbox checkbox=new Checkbox("Certificate");

		JScrollPane scrollPane = jScrollPane;
//		JTable finalJTable = jTable;
//		jTable.getModel().addTableModelListener(new TableModelListener() {
//			@Override
//			public void tableChanged(TableModelEvent tme) {
//				if (tme.getType() == TableModelEvent.UPDATE) {
//					System.out.println("");
//					System.out.println("Cell " + tme.getFirstRow() + ", "
//							+ tme.getColumn() + " changed. The new value: "
//							+ finalJTable.getValueAt(tme.getFirstRow(),
//							tme.getColumn()));
//				}
//			}
//		});


		scrollPane.setPreferredSize(new Dimension(1000, 800));
		add(scrollPane);
		add(checkbox);
		add(button);

		setPreferredSize(new Dimension(450, 250));
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
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

	@Override
	public void actionPerformed(ActionEvent e) {

	}


	@Override
	public void editingStopped(ChangeEvent e) {

	}

	@Override
	public void editingCanceled(ChangeEvent e) {

	}
}

