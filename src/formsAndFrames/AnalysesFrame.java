package formsAndFrames;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dbEntities.DataBaseManager;

public class AnalysesFrame extends JFrame {
	DataBaseManager connectionManager;
	/**
	 * constructor - creating scroll Frame for analyses
	 * @return Scroll frame for analyses
	 * @throws SQLException if smth wrong with SQL part of the connection
	 * @throws ClassNotFoundException if smth wrong with JDBC
	 */
	public AnalysesFrame (DataBaseManager cn, String sqlRequest) throws ClassNotFoundException, SQLException {
		this.setTitle(sqlRequest);
		this.connectionManager = cn;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         
        JScrollPane scrollPane = new JScrollPane(cn.getResultAsTableFromDBM(sqlRequest));
         
        this.getContentPane().add(scrollPane);
        this.setPreferredSize(new Dimension(800, 500));
        this.pack();
        this.setLocationRelativeTo(null);
//        frame.setVisible(true);
	}

	
	
}
