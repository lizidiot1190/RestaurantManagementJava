/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AccountDTO;
import UTILS.md5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vhh01
 */
public class AccountDAO {
    private static String dbUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=RestaurantManagement;" + "integratedSercuriry=true";
    private static String dbuserName = "sa";
    private static String dbpassWord = "Hoanghiep0106";
    
    public ArrayList<AccountDTO> GetAccountListdb() {
        Connection connect = null;
        ArrayList<AccountDTO> accountList =new ArrayList<>();

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "SELECT * FROM Account ";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                AccountDTO account = new AccountDTO();
                account.setAccountID(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setDisplayName(rs.getString(3));
                account.setPassWord(rs.getString(4));
                account.setType(rs.getInt(5));
                accountList.add(account);
            }

            prepStmt.close();
            rs.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        } catch (Exception ex) {
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
        
        return accountList;
    }
    public void addAccount (String username, String displayname, String password, String type){
        Connection connect = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql = "INSERT INTO Account VALUES (?,?,?,?)";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1, username);
            prepStmt.setString(2, displayname);
            prepStmt.setString(3, UTILS.md5.md5(password))  ;
            prepStmt.setString(4, type);
            prepStmt.executeUpdate();

            prepStmt.close();
            connect.close();

//            System.out.println("Connect to dadabase successfully!");
        } catch (Exception ex) {
            //System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
    }
    
    public void deteleAccount( int id ){
        Connection connect = null;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql="DELETE FROM Account WHERE accountID=?";
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
    
    public void updateStaff(String username, String displayname, String password, String type,int id ){
        Connection connect = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(dbUrl, dbuserName, dbpassWord);
            String sql="UPDATE Account SET userName=?,displayName=?,passWord=?,type=? WHERE accountID=?";
            PreparedStatement prepStmt = connect.prepareStatement(sql);
            prepStmt.setString(1, username);
            prepStmt.setString(2, displayname);
            prepStmt.setString(3, UTILS.md5.md5(password));
            prepStmt.setString(4, type);
            prepStmt.setInt(5,id);
            prepStmt.executeUpdate();
            
    }catch (Exception ex) {
            //System.out.println("Failed!");
            ex.printStackTrace();
        }
    }
    
}
