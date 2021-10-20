/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author lizid
 */
public class TableDTO {
    private int tableId;
    private String tableName;
    private String tableStatus;
    public TableDTO(){
        tableId=0;
        tableName="";
        tableStatus="";
        
    }
    
    public TableDTO(int tableId, String tableName, String tableStatus){
        this.tableId=tableId;
        this.tableName=tableName;
        this.tableStatus=tableStatus;
    }
    
    public TableDTO(TableDTO table){
        this.tableId=table.tableId;
        this.tableName=table.tableName;
        this.tableStatus=table.tableStatus;
    }

    /**
     * @return the tableId
     */
    public int getTableId() {
        return tableId;
    }

    /**
     * @param tableId the tableId to set
     */
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the tableStatus
     */
    public String getTableStatus() {
        return tableStatus;
    } 

    /**
     * @param tableStatus the tableStatus to set
     */
    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }
}
