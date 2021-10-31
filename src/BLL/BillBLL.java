/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.BillDAO;
import DAO.BillInfoDAO;
import DAO.TableDAO;
import DTO.BillDTO;
import DTO.BillInfoDTO;
import GUI.MainGUI;
import GUI.TableGUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lizid
 */

public class BillBLL {
    protected BillDAO billDAO;
    protected TableDAO tableDAO;
    protected TableBLL tableBLL;
    private ArrayList<BillDTO> listBill;
    public BillBLL(){
        listBill = new ArrayList<>();
    }
    
    public void AddOrUpdateBill(int tableId, int foodId, int quantity, String note){
        billDAO = new BillDAO();
        tableDAO =new TableDAO();
        BillInfoDAO billInfoDAO = new BillInfoDAO();
        if(billDAO.CheckBillStatus(tableId)==false){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
            Date now = new Date();
            String checkIn = formatter.format(now);
            String checkOut = null;
            //tao ra 1 bill moi
            billDAO.AddBill(tableId, checkIn, checkOut);
            //tao ra 1 bill info moi theo bill id
            billInfoDAO.AddBillInfo(billDAO.GetBillId(tableId), foodId, quantity, note);
            tableDAO.updateTableStatus(tableId, "Có người");
            TableGUI.lbCheckIn.setText(checkIn);
            
        }
        else{
            int billId=billDAO.GetBillId(tableId);
            BillInfoDTO billInfoDTO = new BillInfoDTO();
            billInfoDTO =billInfoDAO.CheckBillInfoByBillIdAndFoodId(billId, foodId,note);
            if(billInfoDTO==null){
                billInfoDAO.AddBillInfo(billDAO.GetBillId(tableId), foodId, quantity, note);
            }
            else{
                if(!billInfoDTO.getNote().equals(note)){
                    billInfoDAO.AddBillInfo(billDAO.GetBillId(tableId), foodId, quantity, note);
                }
                else{
                    billInfoDAO.UpdateBillInfo(billInfoDTO.getBillInfoId(), billInfoDTO.getCount()+quantity,note);
                }
                
            }
        }
    }
    
    public void CheckOutBill(int tableId, int discount){
        billDAO = new BillDAO();
        if(billDAO.CheckBillStatus(tableId)==false){
            JOptionPane.showMessageDialog(null, "Bàn chưa có bill không thể thanh toán!");
        }
        else{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
            Date now =new Date();
            int billId = billDAO.GetBillId(tableId);
            String checkOut = formatter.format(now);
            billDAO.CheckOutBill(billId, checkOut, discount);
            tableDAO =new TableDAO();
            tableDAO.updateTableStatus(tableId, "Trống");
            
        }

    }
    
    public void Discount(int tableId, int discount){
        billDAO = new BillDAO();
        if(billDAO.CheckBillStatus(tableId)==false){
            JOptionPane.showMessageDialog(null, "Bàn chưa có bill không thể áp dụng giảm giá!");
            TableGUI.spDiscount.setValue(0);
        }else{
            int billId = billDAO.GetBillId(tableId);
            billDAO.UpdateDiscount(billId, discount);
            JOptionPane.showMessageDialog(null, "Đã áp dụng giảm giá thành công");
        }

    }

}
