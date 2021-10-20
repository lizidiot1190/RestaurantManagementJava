/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author lizid
 */
public class BillDTO {
    private int id;
    private int tableId;
    private Date checkIn;
    private Date checkOut;
    private int billStatus;
    private int discount;
    
    public BillDTO() throws ParseException{
        SimpleDateFormat datefm =new SimpleDateFormat("dd/MM/yyyy");
        id=0;
        tableId=0;
        checkIn=datefm.parse("01/01/1970");
        checkOut=datefm.parse("01/01/1970");
        billStatus=0;
        discount=0;
    }
    
    public BillDTO(int id, int tableId, Date checkIn, Date checkOut, int billStatus, int discount){
        this.id=id;
        this.tableId=tableId;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        this.billStatus=billStatus;
        this.discount=discount;
    }
    
    public BillDTO(BillDTO bill){
        this.id=bill.id;
        this.tableId=bill.tableId;
        this.checkIn=bill.checkIn;
        this.checkOut=bill.checkOut;
        this.billStatus=bill.billStatus;
        this.discount=bill.discount;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
