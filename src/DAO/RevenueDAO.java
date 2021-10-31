/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.RevenueDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class RevenueDAO {
    private static String dbUrl ="jdbc:sqlserver://localhost:1234;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
    private static String dbuserName="sa";
    private static String dbpassWord="123456";
    
    public ArrayList<RevenueDTO> GetFoodList(){
        Connection connect = null;
        ArrayList<RevenueDTO> RevenueList =new ArrayList<>();
        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM Food ORDER BY catID ASC";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                RevenueDTO revenue=new RevenueDTO();
                revenue.setTableId(rs.getInt(1));
                revenue.setCheckIn(rs.getDate(2));
                revenue.setCheckOut(rs.getDate(3));
                revenue.setDiscount(rs.getInt(4));
                revenue.setCount(rs.getInt(5));
                revenue.setFoodId(rs.getInt(6));
                
                
                RevenueList.add(revenue);               
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return RevenueList;
    }
}
