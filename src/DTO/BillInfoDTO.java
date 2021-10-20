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
public class BillInfoDTO {
    private int billInfoId;
    private int billId;
    private int foodId;
    private int count;
    private String note;
    
    public BillInfoDTO(int billInfoId, int billId, int foodId, int count, String note) {
        this.billInfoId = billInfoId;
        this.billId = billId;
        this.foodId = foodId;
        this.count = count;
        this.note = note;
    }
    
    public BillInfoDTO(){
        billInfoId=0;
        billId=0;
        foodId=0;
        count=0;
        note="";
    }
    
    public BillInfoDTO(BillInfoDTO billInfo){
        this.billId=billInfo.billId;
        this.billInfoId=billInfo.billInfoId;
        this.foodId=billInfo.foodId;
        this.count=billInfo.count;
        this.note=billInfo.note;
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

    public void setBillID(int billID) {
        this.billId = billID;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
