/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.BillDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lizid
 */
public class BillDAO {
    private static String dbUrl ="jdbc:sqlserver://localhost:1433;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
    private static String dbuserName="sa";
    private static String dbpassWord="Hoanghiep0106";
    
    public void UpdateBill(int billId, int tableId, int discount){
        Connection connect = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE Bill SET idTable=? discount=? WHERE billID=? ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1,tableId);
            prepStmt.setInt(2,discount);
            prepStmt.setInt(3,billId);
            prepStmt.executeUpdate();
            prepStmt.close();
            connect.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void AddBill( int tableId, Date checkIn, Date checkOut, int discount){
        Connection connect = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "INSERT INTO Bill VALUES(?,?,?,?,?) ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1,tableId);
            prepStmt.setDate(2, (java.sql.Date) checkIn);
            prepStmt.setDate(3, (java.sql.Date) checkOut);
            prepStmt.setInt(4,0);
            prepStmt.setInt(5, discount);
            prepStmt.executeUpdate();
            prepStmt.close();
            connect.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //Lay ra 1 cai bill trung voi tableId
    public BillDTO GetBillByTableId (int tableId){
        Connection connect = null;
        BillDTO bill = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM Bill WHERE idTable=? and billStatus=0";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1,tableId);
            ResultSet rs =prepStmt.executeQuery();
            while(rs.next()){
                bill =new BillDTO();
                bill.setId(rs.getInt(1));
                bill.setTableId(rs.getInt(2));
                bill.setCheckIn(rs.getDate(3));
                bill.setCheckOut(rs.getDate(4));
                bill.setBillStatus(rs.getInt(5));
                bill.setDiscount(rs.getInt(6));
            }
        }
        catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return bill;
    }
    
    // check ban da co bill chua, chua co bill tra ve false, dang co bill tra ve true
    public boolean CheckBillStatus(int tableId){
        Connection connect = null;
        boolean result=true;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM Bill WHERE idTable=? and billStatus=0";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1,tableId);
            ResultSet rs =prepStmt.executeQuery();
            if(rs.next()){
                return result;
            }
            else{
                result=false;
            }
        }
        catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return result;
    }
    
    public void CheckOutBill(int billID,Date checkOut){
        Connection connect = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE Bill SET  checkOUt=?, tableStatus=1 WHERE billID=? ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setDate(1, (java.sql.Date) checkOut);
            prepStmt.executeUpdate();
            prepStmt.close();
            connect.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
}
