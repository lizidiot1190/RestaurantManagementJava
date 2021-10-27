/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.StaffDAO;
import DTO.StaffDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vhh01
 */
public class StaffBLL {
    private ArrayList<StaffDTO> listStaff;
    public StaffBLL(){
        listStaff = new ArrayList<>();
    }
    
    public ArrayList<StaffDTO> getListStaff(){
        StaffDAO db=new StaffDAO();
        listStaff=db.GetStaffListdb();
        return this.listStaff;
    }
    
    public void GetStafftList(JTable tblStaff){
        StaffDAO db=new StaffDAO();
        listStaff=db.GetStaffListdb();
        DefaultTableModel stafftable = (DefaultTableModel )tblStaff.getModel();
        stafftable.setRowCount(0);
        
        Object rowstaff[] = new Object[6];
        for(int i=0;i<listStaff.size();i++){
            rowstaff[0] = listStaff.get(i).getStaffId();
            rowstaff[1] = listStaff.get(i).getStaffName();
            rowstaff[2] = listStaff.get(i).getGender();
            rowstaff[3] = listStaff.get(i).getDateOfBirth();
            rowstaff[4] = listStaff.get(i).getPhoneNumber();
            rowstaff[5] = listStaff.get(i).getAddress();
            stafftable.addRow(rowstaff);
                  
        }
    }
    
    public void addStaff(String name, String gender, Date ns, String phoneNumber, String address){
        StaffDAO db = new StaffDAO();
        db.addStaff(name, gender, ns, phoneNumber, address);
    }
    
    public void deleteStaff(int id){
        StaffDAO db = new StaffDAO();
        db.deleteStaff(id);
    }
    
    public void updateStaff(String name, String gender, Date ns, String phoneNumber, String address, int id){
        StaffDAO db = new StaffDAO();
        db.updateStaff(name, gender, ns, phoneNumber, address, id);
    }
}
