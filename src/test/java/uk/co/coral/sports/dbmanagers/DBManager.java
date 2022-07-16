package uk.co.coral.sports.dbmanagers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    public static void main(String[] args) throws SQLException {
        String q = "Select * from data";
        String[][] result = FetchDataFromDB(q);
        System.out.println(result);
    }

    public static String[][] FetchDataFromDB(String query) throws SQLException {
        String url = "jdbc:mysql://https://buildyourbet.prod.coral.co.uk/api/v1/events";
        DBConnectionManager DBInstance = DBConnectionManager.getInstance(url);
        Connection conn  = DBInstance.getConnection();
        Statement stat;
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(query);
        int clmCount = rs.getMetaData().getColumnCount();//to get number of column returned
        rs.last();//to get total number of rows returned
        int rowCount = rs.getRow();//this will give the index
        rs.beforeFirst();//this will bring it back to first raw
        String[][] result = new String[rowCount][clmCount];//create object
        int i = 0;
        while (rs.next()) {
            for (int j = 0; j < clmCount; j++) {
                result[i][j] = rs.getString(j + 1);
            }
            i = i + 1;
        }
        return result;
    }
}
