
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FoodDTO;
import DTO.TableDTO;
import GUI.LoginGUI;
import GUI.MainGUI;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lizid
 */
public class ConnectSQLServer {
    private static String dbUrl ="jdbc:sqlserver://localhost:1433;"+"databaseName=RestaurantManagement;"+"integratedSercuriry=true";
    private static String dbuserName="sa";
    private static String dbpassWord="Hoanghiep0106";
    
//    public PreparedStatement ExcuteQuery(String query){
//        Connection connect = null;
//        PreparedStatement prepStmt = null;
//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
//            prepStmt = connect.prepareStatement(query);
//            ResultSet rs = prepStmt.executeQuery();
//            connect.close();
//        }
//        catch(Exception ex){
//            System.out.println("Connect Failure!");
//            ex.printStackTrace();
//        }
//
//            
//        return prepStmt;
//    }
    
    
   
    
    public boolean Login(String userName, String passWord){
        Connection connect = null;
        boolean result = false;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect =DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT *FROM Account WHERE userName=? AND passWord=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1, userName);
            prepStmt.setString(2, passWord);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                System.out.println("Login Successful");
                MainGUI mainGUI =new MainGUI(rs.getString(3),rs.getInt(5));
                mainGUI.setVisible(true);
                result = true;
            }else{
                System.out.println("Login Failed!");
            }
            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        }catch(Exception ex){
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        return result;
    }
    
  
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
                foodList.add(food);;               
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


}
