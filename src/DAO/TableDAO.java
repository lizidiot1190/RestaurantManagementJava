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
    private static String dbUrl ="jdbc:sqlserver://localhost:1433;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
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
    
    public ArrayList<TableDTO> GetTableNonBIll(){
        Connection connect = null;
        ArrayList<TableDTO> listTable= new ArrayList<>();
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT DISTINCT tableId, tableName FROM CustomerTable JOIN Bill ON CustomerTable.tableID = Bill.idTable WHERE billStatus=1 ORDER BY tableID;";
            PreparedStatement prepStmt = connect.prepareStatement(sql);           
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                TableDTO table=new TableDTO();
                table.setTableId(rs.getInt(1));
                table.setTableName(rs.getString(2));
                listTable.add(table);
            }

            prepStmt.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
            
        }
        
        return listTable;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
