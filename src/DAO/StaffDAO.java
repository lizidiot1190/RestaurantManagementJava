/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.ConnectSQLServer;
import DTO.StaffDTO;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vhh01
 */
public class StaffDAO {
    private static String dbUrl ="jdbc:sqlserver://localhost:1433;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
    private static String dbuserName="sa";
    private static String dbpassWord="123123qq";
    public ArrayList<StaffDTO> GetStaffListdb() {
        Connection connect = null;
        ArrayList<StaffDTO> staffList =new ArrayList<>();

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT * FROM Staff ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                StaffDTO staff = new StaffDTO();
                staff.setStaffId(rs.getInt(1));
                staff.setStaffName(rs.getString(2));
                staff.setGender(rs.getString(3));
                
                staff.setDateOfBirth(rs.getDate(4));
                staff.setPhoneNumber(rs.getString(5));
                staff.setAddress(rs.getString(6));
                staffList.add(staff);
                
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        } catch (Exception ex) {
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        
        return staffList;
    }
    
    public void addStaff(String name, String gender, Date ns, String phoneNumber, String address){
        Connection connect = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "INSERT INTO Staff VALUES (?,?,?,?,?) ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1, name);
            prepStmt.setString(2, gender);
            java.sql.Date sqlDate =new java.sql.Date(ns.getTime());           
            prepStmt.setDate(3,  sqlDate);
            prepStmt.setString(4, phoneNumber);
            prepStmt.setString(5, address);
            prepStmt.executeUpdate();
            
            prepStmt.close();
            connect.close();;
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void deleteStaff(int id){
        Connection connect = null;
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql="DELETE FROM Staff WHERE staffID=?";
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
    
    public void updateStaff(String name, String gender, Date ns, String phoneNumber, String address, int id){
        Connection connect = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql="UPDATE Staff SET staffName=?,gender=?,dateOfBirth=?,phoneNumber=?,address=? WHERE staffID=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1, name);
            prepStmt.setString(2, gender);
            java.sql.Date sqlDate =new java.sql.Date(ns.getTime());
            prepStmt.setDate(3, sqlDate);
            prepStmt.setString(4, phoneNumber);
            prepStmt.setString(5,address);
            prepStmt.setInt(6, id);
            prepStmt.executeUpdate();
            
    }catch (Exception ex) {
            //System.out.println("Failed!");
            ex.printStackTrace();
        }
    }
}

