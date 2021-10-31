/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.ParseException;

/**
 *
 * @author vhh01
 */
public class AccountDTO {
    private int accountID;
    private String userName;
    private String displayName;
    private String passWord;
    private int type;
    
    public AccountDTO() throws ParseException{
        accountID=0;
        userName="";
        displayName="";
        passWord="";
        type=0;
        
    }

    public AccountDTO(int accountID, String userName, String displayName, String passWord, int type) {
        this.accountID = accountID;
        this.userName = userName;
        this.displayName = displayName;
        this.passWord = passWord;
        this.type = type;
    }
    
    public AccountDTO(AccountDTO account){
        this.accountID=account.accountID;
        this.userName=account.userName;
        this.displayName=account.displayName;
        this.passWord=account.displayName;
        this.type=account.type;
        
    }
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
