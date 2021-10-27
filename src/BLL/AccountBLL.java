/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.AccountDAO;

import DTO.AccountDTO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vhh01
 */
public class AccountBLL {
    private ArrayList<AccountDTO> listAccount;
    public AccountBLL(){
        listAccount = new ArrayList<>();
    }
    
    public ArrayList<AccountDTO> getListAccount(){
        AccountDAO db=new AccountDAO();
        listAccount=db.GetAccountListdb();
        return this.listAccount;
    }
    
    public void GetAccountList(JTable tblAccount){
        AccountDAO db=new AccountDAO();
        listAccount=db.GetAccountListdb();
        DefaultTableModel accounttable = (DefaultTableModel )tblAccount.getModel();
        accounttable.setRowCount(0);
        
        Object rowaccount[] = new Object[5];
        for(int i=0;i<listAccount.size();i++){
            rowaccount[0] = listAccount.get(i).getAccountID();
            rowaccount[1] = listAccount.get(i).getUserName();
            rowaccount[2] = listAccount.get(i).getDisplayName();
            rowaccount[3] = listAccount.get(i).getPassWord();
            rowaccount[4] = listAccount.get(i).getType();
            
            accounttable.addRow(rowaccount);
        
        }
    }
    
    public void AddAccount(String username, String displayname, String password, String type){
        AccountDAO db = new AccountDAO();
        db.addAccount(username, displayname, password, type);
        
    }
    
    public void deleteAccount(int id){
        AccountDAO db= new AccountDAO();
        db.deteleAccount(id);
    }
    
    public void updateAccount(int id, String username, String displayname, String password, String type){
        AccountDAO db =new AccountDAO();
        db.updateStaff(username, displayname, password, type, id);
    }
}
