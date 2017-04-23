package customListeners;

import dbEntities.DataBaseManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * Created by AsusTek on 23.04.2017.
 */
public class SaveListener implements ActionListener {

    final static Set<String> tableColumns = new LinkedHashSet<String>() {{
        add("name");
        add("passport_number");
        add("sender_account_number");
        add("recipient_account_number");
        add("amount");
	    add("payment_purpose");
	    add("operation_date");
	    add("sert");
    }};
    static String createTempTable1 = "CREATE TABLE %s (" +
            "name VARCHAR2(200), " +
            "passport_number INTEGER," +
            "sender_account_number INTEGER," +
            "recipient_account_number INTEGER," +
            "amount INTEGER," +
            "payment_purpose VARCHAR2(200)," +
            "operation_date DATE," +
            "sert NUMBER)";
    static String mergeStmt = "MERGE INTO %s t1 USING (SELECT * FROM %s) t2 ON " +
            "t1.rownumber = t2.rownumber WHEN MATCH THEN UPDATE SET ";
    static String dropTempTable1 = "drop table %s";
    static String inserts = "insert into %s (%s)VALUES (%s)";

    private final String reportName;
    private final Map<String, Map<String, String>> data;

    DataBaseManager dataBaseManager;

    public SaveListener(JCheckBox sert, Map<String,Map<String,String>> data, String reportName,
                        DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
        this.reportName = reportName;
        this.data = data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try(Connection connection = this.dataBaseManager.getDbConnection()) {
            String tableName = "tempTable" +Math.round(Math.random()*10000);
            PreparedStatement psc = connection.prepareStatement(String.format(createTempTable1, tableName));
            psc.execute();

            StringBuilder valuesString = new StringBuilder();
            StringBuilder columnsString = new StringBuilder();

            for (String num : data.keySet()) {
                Map<String, String> dataObject = data.get(num);
                for (String field : tableColumns) {
                    if (field.equalsIgnoreCase("name")) {
                        valuesString.append(dataObject.get(field));
                        columnsString.append(field);
                        continue;
                    }
                    valuesString.append(", ").append(field);
                    columnsString.append(", ").append(field);
                }
            }
            PreparedStatement insertStmt = connection.prepareStatement(String.format(
                    inserts, tableName, columnsString.toString(), valuesString.toString()));
            insertStmt.execute();


            StringBuilder merge = new StringBuilder(mergeStmt);
            Boolean first = true;
            for (String field : tableColumns) {
                if (first) {
                    merge.append("t1.").append(field).append("= t2.").append(field).append("");
                    first = false;
                    continue;
                }
                merge.append(", t1.").append(field).append("= t2.").append(field).append("");
            }
            PreparedStatement psm = connection.prepareStatement(String.format(merge.toString(),"report1", tableName));
            psm.execute();


            PreparedStatement psd = connection.prepareStatement(String.format(dropTempTable1, tableName));
            psd.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
