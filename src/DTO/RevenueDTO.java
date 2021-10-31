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
 * @author Admin
 */
public class RevenueDTO {
    private int billInfoId;
    private int billId;
    private int foodId;
    private int count;
    private int id;
    private int tableId;
    private Date checkIn;
    private Date checkOut;
    private int billStatus;
    private int discount;
    
    public RevenueDTO() throws ParseException{
        SimpleDateFormat datefm =new SimpleDateFormat("dd/MM/yyyy");
        id=0;
        tableId=0;
        checkIn=datefm.parse("01/01/1970");
        checkOut=datefm.parse("01/01/1970");
        billStatus=0;
        discount=0;
        
        billInfoId=0;
        billId=0;
        foodId=0;
        count=0;
    }
    
    public RevenueDTO(int id, int tableId, Date checkIn, Date checkOut, int billStatus, int discount, int billInfoId, int billId, int foodId, int count){
        this.id=id;
        this.tableId=tableId;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        this.billStatus=billStatus;
        this.discount=discount;
        
        this.billInfoId = billInfoId;
        this.billId = billId;
        this.foodId = foodId;
        this.count = count;
    }
    
    public RevenueDTO(RevenueDTO revenue){
        this.id=revenue.id;
        this.tableId=revenue.tableId;
        this.checkIn=revenue.checkIn;
        this.checkOut=revenue.checkOut;
        this.billStatus=revenue.billStatus;
        this.discount=revenue.discount;
        
        this.billId=revenue.billId;
        this.billInfoId=revenue.billInfoId;
        this.foodId=revenue.foodId;
        this.count=revenue.count;
    }

    public int getBillInfoId() {
        return billInfoId;
    }

    public void setBillInfoId(int billInfoId) {
        this.billInfoId = billInfoId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
