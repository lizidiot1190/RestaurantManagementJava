/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author lizid
 */
public class BillInfoDAO {
    private static String dbUrl ="jdbc:sqlserver://localhost:1433;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
    private static String dbuserName="sa";
    private static String dbpassWord="123123qq";
    
    public void AddBillInfo(int billId, int foodId, int count, String note){
        Connection connect = null;
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "INSERT INTO BillInfo VALUES (?,?,?,?) ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, billId);
            prepStmt.setInt(2, foodId);
            prepStmt.setInt(3, count);
            prepStmt.setString(4, note);
            prepStmt.executeUpdate();
            prepStmt.close();
            connect.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
