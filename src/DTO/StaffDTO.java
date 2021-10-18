/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author vhh01
 */
public class StaffDTO {
    private int staffId;
    private String staffName;
    private String gender;
    private int dateOfBirth;
    private String phoneName;
    private String address;
    
    public StaffDTO(){
        
    }

    public StaffDTO(int staffId, String staffName, String gender, int dateOfBirth, String phoneName, String address) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phoneName = phoneName;
        this.address = address;
        
        
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
