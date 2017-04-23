package customListeners;

import dbEntities.DataBaseManager;
import dbEntities.RSAndRSMDStorage;
import formsAndFrames.AnalysesDataFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static main.mainClass.*;

public class ReportExecListener implements ActionListener {
    private DataBaseManager dataBaseManager;
    private RSAndRSMDStorage storage = new RSAndRSMDStorage();
    private JFrame frame;
    private String sqlRequest;
    private JTextField monthField;
    private JTextField yearField;

    private static String sqlForReport1 = "select * from report1 WHERE EXTRACT(MONTH FROM operation_date)= %s AND " +
            "EXTRACT (YEAR FROM operation_date) = %s";
    private static String sqlForReport2 = "select * from report2";


    /**
     * constructor
     * @param cn connection manager to work with
     * @param reportName Имя отчета
     * @param frame parent frame
     */
    public ReportExecListener(DataBaseManager cn, String reportName, JFrame frame, JTextField monthField, JTextField yearField) {
        this.dataBaseManager = cn;
        this.sqlRequest = this.getRequest(reportName);
        this.frame = frame;
        this.monthField = monthField;
        this.yearField = yearField;
    }


    /**
     * Creates and shows analys frame
     * @param actionEvent every event
     */
    public void actionPerformed(ActionEvent actionEvent){


//		if (analysesFrame == null) {
        try {
            JScrollPane scrollPane = new JScrollPane(dataBaseManager.getResultAsTableFromDBM(
                    String.format(sqlRequest, monthField.getText(), yearField.getText()), this.storage));
            analysesDataFrame = new AnalysesDataFrame(scrollPane, frame);
            analysesDataFrame.setVisible(true);

//            analysesFrame = new AnalysesFrame(this.frame, analysesDataFrame);
//            analysesFrame .setVisible(true);

            requestFrame.setVisible(false);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
            loginFrame.setVisible(true);

        }
//		} else {
//			analysesFrame.setVisible(true);
//		}
    }

    /**
     * Возвращает запрос в зависимости от отчета
     * @param reportName имя отчета
     * @return запрос
     */
    private String getRequest(String reportName) {
        switch (reportName) {
            case "Обязательный отчет по недвижимости":
                return sqlForReport1;
            case "Подозрительные счета":
                return sqlForReport2;
            default:
                throw new RuntimeException("Неверное название отчета!");
        }
    }
}