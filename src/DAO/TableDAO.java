/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TableDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lizid
 */
public class TableDAO {
    private static String dbUrl ="jdbc:sqlserver://localhost:1433;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true;"+"sendStringParametersAsUnicode=true;";
    private static String dbuserName="sa";
    private static String dbpassWord="123123qq";
    
    public ArrayList<TableDTO> GetTableList(){
        Connection connect = null;
        ArrayList<TableDTO> tableList =new ArrayList<>();
        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM CustomerTable";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                TableDTO table=new TableDTO();
                table.setTableId(rs.getInt(1));
                table.setTableName(rs.getString(2));
                table.setTableStatus(rs.getString(3));
                tableList.add(table);;               
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return tableList;
    }
    
    public void AddTable(String tableName, String status)
    {
        Connection connect = null;        
        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "INSERT INTO CustomerTable VALUES (?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, tableName);
            ps.setString(2, status);
            ps.executeUpdate();
            
            ps.close();
            connect.close();
            
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
    }
    
    public void UpdateTable(String tableName, String status, int id)
    {
        Connection connect = null;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE CustomerTable set tableName=?, tableStatus=? WHERE tableID=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, tableName);
            ps.setString(2, status);
            ps.setInt(3, id);
            ps.executeUpdate();
            
            ps.close();
            connect.close();
            
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
    }
    
    public void DeleteTable(int id)
    {
        Connection connect = null;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "DELETE FROM CustomerTable WHERE tableID=?";
            PreparedStatement ps = connect.prepareStatement(sql);           
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
            connect.close();
            
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
    }
    
    public void updateTableStatus (int id, String status){
        Connection connect = null;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE CustomerTable SET tableStatus=? WHERE tableID=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1, status);
            prepStmt.setInt(2, id);
            prepStmt.executeUpdate();

            prepStmt.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
    }
    
    public ArrayList<String> GetTableNameNonBill(){
        Connection connect = null;
        ArrayList<String> listTableName= new ArrayList<>();
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT tableName FROM CustomerTable WHERE tableStatus=N'Trống'";
            PreparedStatement prepStmt = connect.prepareStatement(sql);           
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                String name;                
                name=rs.getString(1);
                listTableName.add(name);
            }

            prepStmt.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
            
        }
        
        return listTableName;
    }
    
    public String GetTableNameById(int id){
        Connection connect = null;
        String tableName="";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT tableName FROM CustomerTable WHERE tableID=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, id);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                tableName=rs.getString(1);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return tableName;
    }
    public String GetTableName(int tableId){
        Connection connect = null;
        String name="";
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT tableName FROM CustomerTable WHERE tableId=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, tableId);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                name=rs.getString(1);
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        
        return name;
    }
    
    public int GetTableId(String tableName){
        Connection connect = null;
        int id =0;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT tableID FROM CustomerTable WHERE tableName=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1, tableName);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        
        return id;
    }
    
    
}

