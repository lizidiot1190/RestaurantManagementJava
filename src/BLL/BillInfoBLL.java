/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.BillDAO;
import DAO.BillInfoDAO;
import DAO.FoodDAO;
import DTO.BillInfoDTO;
import GUI.TableGUI;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizid
 */
public class BillInfoBLL {
    private ArrayList<BillInfoDTO> listBillInfo;
    protected BillInfoDAO billInfoDAO;
    protected BillDAO billDAO;
    
    public BillInfoBLL(){
        listBillInfo = new ArrayList<>();
    }
    
    public void FillBillItem (JTable tblBillItem, int billId){
        billInfoDAO = new BillInfoDAO();
        billDAO = new BillDAO();
        FoodDAO foodDAO = new FoodDAO();
        
        int discount = billDAO.GetDiscount(billId);
        listBillInfo =  billInfoDAO.GetListBillInfoByBillId(billId);
        DefaultTableModel billItemTable = (DefaultTableModel)tblBillItem.getModel();
        billItemTable.setRowCount(0);
        double total=0;
        Object row[] = new Object[6];
        for(int i=0;i<listBillInfo.size();i++){
            double tam;
            row[0]=listBillInfo.get(i).getBillInfoId();
            String foodName=foodDAO.GetFoodNameById(listBillInfo.get(i).getFoodId());
            row[1]=foodName;
            row[2]=listBillInfo.get(i).getNote();
            row[3]=listBillInfo.get(i).getCount();
            double price = foodDAO.GetFoodPriceById(listBillInfo.get(i).getFoodId());
            row[4]= price;
            tam=price* listBillInfo.get(i).getCount();
            total =tam+total;
            row[5]= tam;
            billItemTable.addRow(row);
        }
        TableGUI.txtTotal.setText(Double.toString(total-(total*discount/100)));
        TableGUI.spDiscount.setValue(discount);
    }
    
    public void UpdateBillItem(int id, int quantity, String note){
        billInfoDAO = new BillInfoDAO(); 
        billInfoDAO.UpdateBillInfo(id, quantity, note);
    }
    
    public void DeleteBillInfo(int id){
        billInfoDAO = new BillInfoDAO();
        billInfoDAO.DeleteBillInfo(id);
    }
}
