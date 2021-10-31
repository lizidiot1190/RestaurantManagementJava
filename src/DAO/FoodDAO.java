/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FoodDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lizid
 */
public class FoodDAO {
    private static String dbUrl ="jdbc:sqlserver://localhost:1433;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
    private static String dbuserName="sa";
    private static String dbpassWord="123123qq";
    
    public ArrayList<FoodDTO> GetFoodList(){
        Connection connect = null;
        ArrayList<FoodDTO> foodList =new ArrayList<>();
        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM Food ORDER BY catID ASC";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                FoodDTO food=new FoodDTO();
                food.setFoodId(rs.getInt(1));
                food.setFoodName(rs.getString(2));
                food.setCatId(rs.getInt(3));
                food.setFoodPrice(rs.getString(4));
                foodList.add(food);               
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return foodList;
    }
    public void AddFood(String foodName, int catID, String Price)
    {
        Connection connect = null;  
         
        //String sql = "INSERT INTO jTable1(categoryID, categoryName)" + "VALUES(?,?)";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "INSERT INTO Food VALUES (?,?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, foodName);
            ps.setInt(2, catID);
            ps.setString(3, Price);           
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
    
    public void UpdateFood(String foodName, int catID, String Price, int foodID)
    {
        Connection connect = null;  
         
        //String sql = "INSERT INTO jTable1(categoryID, categoryName)" + "VALUES(?,?)";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "UPDATE Food set foodName=?, catID=?, foodPrice=? WHERE foodID=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, foodName);
            ps.setInt(2, catID);
            ps.setString(3, Price); 
            ps.setInt(4, foodID);
            ps.executeUpdate();
            
            ps.close();
            connect.close();
            
    
        }catch(Exception e)
        {
            System.out.print("Fail!!");
            e.printStackTrace();
        }
    }
    
    public void DeleteFood(int foodID)
    {
        Connection connect = null;  
         
        //String sql = "INSERT INTO jTable1(categoryID, categoryName)" + "VALUES(?,?)";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "DELETE FROM Food WHERE foodID=?";
            PreparedStatement ps = connect.prepareStatement(sql);          
            ps.setInt(1, foodID);
            ps.executeUpdate();
            
            ps.close();
            connect.close();
            
    
        }catch(Exception e)
        {
            System.out.print("Fail!!");
            e.printStackTrace();
        }
    }
    public String GetFoodNameById(int id){
        Connection connect = null;
        String name="";
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT foodName FROM Food WHERE foodId=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, id);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
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
    
    public double GetFoodPriceById(int id){
        Connection connect = null;
        double price=0;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT foodPrice FROM Food WHERE foodId=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setInt(1, id);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                price=rs.getDouble(1);
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return price;
    }
}

