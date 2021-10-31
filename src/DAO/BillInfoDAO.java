/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.BillInfoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author lizid
 */
public class BillInfoDAO {
    private static String dbUrl ="jdbc:sqlserver://localhost:1234;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
    private static String dbuserName="sa";
    private static String dbpassWord="123456";
    
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
    
    public ArrayList<BillInfoDTO> GetBillInfoListByBillId(int billId){
        Connection connect = null;
        ArrayList<BillInfoDTO> ListBillInfo =new ArrayList<>();
        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM BillInfo WHERE idBill=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, billId);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                BillInfoDTO billInfo=new BillInfoDTO();
                billInfo.setBillInfoId(rs.getInt(1));
                billInfo.setBillID(rs.getInt(2));
                billInfo.setFoodId(rs.getInt(3));
                billInfo.setCount(rs.getInt(4));
                billInfo.setNote(rs.getString(5));
                
                ListBillInfo.add(billInfo);               
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return ListBillInfo;
    }
}
