/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.ConnectSQLServer;
import DTO.TableDTO;
import java.util.ArrayList;

/**
 *
 * @author lizid
 */
public class TableBLL {
    
    private ArrayList<TableDTO> listTable;
    public TableBLL(){
        listTable = new ArrayList<>();
    }
    
    public ArrayList<TableDTO> getListTable(){
        ConnectSQLServer db=new ConnectSQLServer();
        listTable=db.GetTableList();
        return this.listTable;
    }
    
}
