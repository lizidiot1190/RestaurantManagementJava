/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lizid
 */
public class ConnectSQLServer {
    private static String dbUrl ="jdbc:sqlserver://localhost:1433;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
    private static String dbuserName="sa";
    private static String dbpassWord="123123qq";
    
    //commit
    
    public void Login(String userName, String passWord){
        Connection connect = null;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM Account WHERE userName=? AND passWord=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1, userName);
            prepStmt.setString(2, passWord);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                System.out.println("Login Successful");
            }else{
                System.out.println("Login Failed!");
            }
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
    }


}
