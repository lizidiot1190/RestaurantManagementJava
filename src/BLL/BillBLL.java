/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.BillDAO;
import DAO.CategoryDAO;
import DTO.BillDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizid
 */
public class BillBLL {
    private ArrayList<BillDTO> listBill;
    public BillBLL(){
        listBill = new ArrayList<>();
    }
    
    public void AddOrUpdateBill(int billId, int tableId, int discount){
        BillDAO billDAO = new BillDAO();
        if(billDAO.CheckBillStatus(tableId)==true){
            billDAO.UpdateBill(billId, tableId, discount);
        }
        else{
            Date checkIn = new Date();
            Date checkOut= null;
            discount=0;
            billDAO.AddBill(tableId, checkIn, checkOut, discount);
        }
    }
    
    public void CheckOutBill(int billId){
        BillDAO billDAO = new BillDAO();
        Date checkOut=new Date();
        billDAO.CheckOutBill(billId, checkOut);
    }
    
    /*public void GetBillList(JTable table)
    {
        BillDAO billDAO = new BillDAO();
        listBill=billDAO.GetBillList();
        DefaultTableModel billtb=(DefaultTableModel)table.getModel();
        billtb.setRowCount(0);
        Object row[] = new Object[2];
        for(int i = 0; i < listBill.size(); i++)
        {
            row[0]=listBill.get(i).getTableId();
            row[1]=listBill.get(i).getCheckIn();
            row[2]=listBill.get(i).getCheckOut();
            row[3]=;
            //System.out.print(categoryList.get(i).getCategoryName());
            billtb.addRow(row);
        }
    }*/
}
