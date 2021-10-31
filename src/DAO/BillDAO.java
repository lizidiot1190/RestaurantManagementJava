/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.BillDTO;
import DTO.BillInfoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private static String dbpassWord="123123qq";
    
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
    

    public void AddBill( int tableId, String checkIn, String checkOut){
        Connection connect = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "INSERT INTO Bill VALUES(?,?,?,?,?) ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1,tableId);
            prepStmt.setString(2, checkIn);
            prepStmt.setString(3, checkOut);
            prepStmt.setInt(4,0);
            prepStmt.setInt(5, 0);
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
    
     public int GetBillId(int tableId){
        Connection connect = null;
        int result=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM Bill WHERE idTable=? and billStatus=0";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1,tableId);
            ResultSet rs =prepStmt.executeQuery();
            while(rs.next()){
                result = rs.getInt(1);
            }
        }
        catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return result;
    }
     
    public String getCheckIn(int billId){
        Connection connect = null;;
        String date = "00:00:00";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT checkIn FROM Bill WHERE billID=? ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, billId);
            ResultSet rs = prepStmt.executeQuery();

            if(rs.next())
                date=rs.getString(1);
            else{
                return date;
            }
            prepStmt.close();
            connect.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    
    public ArrayList<BillDTO> GetBillListByStatus(){
        Connection connect = null;
        ArrayList<BillDTO> ListBill =new ArrayList<>();
        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT * FROM Bill WHERE billStatus=1";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                BillDTO bill=new BillDTO();
               
                bill.setId(rs.getInt(1));
                bill.setTableId(rs.getInt(2));
                bill.setCheckIn(rs.getDate(3));
                bill.setCheckOut(rs.getDate(4));
                bill.setBillStatus(rs.getInt(5));
                bill.setDiscount(rs.getInt(6));
                   
                ListBill.add(bill);               
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return ListBill;
    }
    
    public ArrayList<BillDTO> GetBillListByDate(String fd, String scd){
        Connection connect = null;
        ArrayList<BillDTO> ListBill =new ArrayList<>();
        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT * FROM Bill WHERE billStatus=1 AND checkOut BETWEEN ? AND ?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            
            prepStmt.setString(1, fd);
            prepStmt.setString(2, scd);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                BillDTO bill=new BillDTO();
               
                bill.setId(rs.getInt(1));
                bill.setTableId(rs.getInt(2));
                bill.setCheckIn(rs.getDate(3));
                bill.setCheckOut(rs.getDate(4));
                bill.setBillStatus(rs.getInt(5));
                bill.setDiscount(rs.getInt(6));
                   
                ListBill.add(bill);               
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return ListBill;
    }
    
    public void CheckOutBill(int billID,String checkOut, int discount){
        Connection connect = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE Bill SET  checkOUt=?,discount=?, billStatus=1 WHERE billID=? ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1,checkOut);
            prepStmt.setInt(2, discount);
            prepStmt.setInt(3, billID);
            prepStmt.executeUpdate();
            prepStmt.close();
            connect.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void UpdateDiscount(int billId, int discount){
        Connection connect = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE Bill SET  discount=? WHERE billID=? ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, discount);
            prepStmt.setInt(2, billId);
            prepStmt.executeUpdate();
            prepStmt.close();
            connect.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public int GetDiscount(int billId){
        Connection connect = null;
        int result=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT discount FROM Bill WHERE billID=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1,billId);
            ResultSet rs =prepStmt.executeQuery();
            while(rs.next()){
                result = rs.getInt(1);
            }
        }
        catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return result;
    }
    
    public void UpdateTableId(int billId, int tableId){
        Connection connect = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE Bill SET  idTable=? WHERE billID=? ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, tableId);
            prepStmt.setInt(2, billId);
            prepStmt.executeUpdate();
            prepStmt.close();
            connect.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
