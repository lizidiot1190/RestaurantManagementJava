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
import java.util.HashSet;
import java.util.Set;

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
    

    public void UpdateBillInfo(int billInfoId, int count, String note){
        Connection connect = null;
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE BillInfo SET count=?,note=? WHERE billIinfoID=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, count);
            prepStmt.setString(2,note);
            prepStmt.setInt(3, billInfoId);;
            prepStmt.executeUpdate();
            prepStmt.close();
            connect.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void DeleteBillInfo(int id){
        Connection connect = null;
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql="DELETE FROM BillInfo WHERE billIinfoID=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();
            prepStmt.close();
            connect.close();
        } catch (Exception ex) {
            //System.out.println("Failed!");
            ex.printStackTrace();
        }  
    }
    
    public BillInfoDTO CheckBillInfoByBillIdAndFoodId (int billId, int foodId,String note){
        Connection connect = null;
        BillInfoDTO billInfo=null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT * FROM BillInfo WHERE idBill=? AND idFood=? AND note=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, billId);
            prepStmt.setInt(2, foodId);
            prepStmt.setString(3, note);
            ResultSet rs =prepStmt.executeQuery();
            if(rs.next()){
                billInfo = new BillInfoDTO();
                billInfo.setBillInfoId(rs.getInt(1));
                billInfo.setBillID(rs.getInt(2));
                billInfo.setFoodId(rs.getInt(3));
                billInfo.setCount(rs.getInt(4));
                billInfo.setNote(rs.getString(5));                            
            }
            else{
                return billInfo;
            }
            rs.close();
            prepStmt.close();
            connect.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return billInfo;
    }
    
    public ArrayList<BillInfoDTO> GetListBillInfoByBillId(int billId){
        Connection connect = null;
        ArrayList<BillInfoDTO> listBillInfo = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT * FROM BillInfo WHERE idBill=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, billId);
            ResultSet rs =prepStmt.executeQuery();
            while(rs.next()){
                BillInfoDTO billInfo = new BillInfoDTO();
                billInfo.setBillInfoId(rs.getInt(1));
                billInfo.setBillID(rs.getInt(2));
                billInfo.setFoodId(rs.getInt(3));
                billInfo.setCount(rs.getInt(4));
                billInfo.setNote(rs.getString(5));
                listBillInfo.add(billInfo);
            }
            rs.close();
            prepStmt.close();
            connect.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listBillInfo;
    }
    
    public ArrayList<BillInfoDTO> GetBillInfoListByBillId(int billId){
        Connection connect = null;
        ArrayList<BillInfoDTO> listBillInfo = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT * FROM BillInfo WHERE idBill=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, billId);
            ResultSet rs =prepStmt.executeQuery();
            while(rs.next()){
                BillInfoDTO billInfo = new BillInfoDTO();
                billInfo.setBillInfoId(rs.getInt(1));
                billInfo.setBillID(rs.getInt(2));
                billInfo.setFoodId(rs.getInt(3));
                billInfo.setCount(rs.getInt(4));
                billInfo.setNote(rs.getString(5));
                listBillInfo.add(billInfo);
            }
            rs.close();
            prepStmt.close();
            connect.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listBillInfo;
    }
}
