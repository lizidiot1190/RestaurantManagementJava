/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CategoryDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 *
 * @author Admin
 */
public class CategoryDAO {
    private static String dbUrl ="jdbc:sqlserver://localhost:1234;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
    private static String dbuserName="sa";
    private static String dbpassWord="123456";
    //private Connection connect;
    
    
    
    public ArrayList<CategoryDTO> GetCategoryList(){
        Connection connect = null;
        ArrayList<CategoryDTO> categoryList =new ArrayList<>();
        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM FoodCategory";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                CategoryDTO cat=new CategoryDTO();
                cat.setCategoryID(rs.getInt(1));
                cat.setCategoryName(rs.getString(2));               
                categoryList.add(cat);;               
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return categoryList;
    }
    
    public void AddCategory(String categoryName)
    {
        Connection connect = null;  
         
        //String sql = "INSERT INTO jTable1(categoryID, categoryName)" + "VALUES(?,?)";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "INSERT INTO FoodCategory VALUES (?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, categoryName);
            ps.executeUpdate();
            
            ps.close();
            connect.close();
            /*PreparedStatement ps = connect.prepareStatement(sql);
            //ps.setInt(1, cat.getCategoryID());
            ps.setString(1, cat.getCategoryName());*/
    
        }catch(Exception e)
        {
            System.out.print("Fail!!");
            e.printStackTrace();
        }
    }
    
    public void UpdateCategory(String categoryName, int categoryID)
    {
        Connection connect = null;  
         
        //String sql = "INSERT INTO jTable1(categoryID, categoryName)" + "VALUES(?,?)";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE FoodCategory set categoryName=? WHERE categoryID=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, categoryName);
            ps.setInt(2, categoryID);
            ps.executeUpdate();
            
            ps.close();
            connect.close();
            
    
        }catch(Exception e)
        {
            System.out.print("Fail!!");
            e.printStackTrace();
        }
    }
    
    public void DeleteCategory(int categoryID)
    {
        Connection connect = null;  
         
        //String sql = "INSERT INTO jTable1(categoryID, categoryName)" + "VALUES(?,?)";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "DELETE FROM FoodCategory WHERE categoryID=?";
            PreparedStatement ps = connect.prepareStatement(sql);          
            ps.setInt(1, categoryID);
            ps.executeUpdate();
            
            ps.close();
            connect.close();
            
    
        }catch(Exception e)
        {
            System.out.print("Fail!!");
            e.printStackTrace();
        }
    }
    
    public String GetCateNameById(int id){
        Connection connect = null;
        String cateName="";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT categoryName FROM FoodCategory WHERE categoryID=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, id);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                cateName=rs.getString(1);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return cateName;
    }
    
    public int GetCateIdByName(String categoryName){
        Connection connect = null;
        int catID=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT categoryID FROM FoodCategory WHERE categoryName=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1, categoryName);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                catID=rs.getInt(1);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return catID;
    }
}
