/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.BillDAO;
import DAO.BillInfoDAO;
import DAO.CategoryDAO;
import DAO.FoodDAO;
import DAO.TableDAO;
import DTO.BillDTO;
import DTO.BillInfoDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class RevenueBLL {
    private ArrayList<BillDTO> listBill;
    private ArrayList<BillInfoDTO> listBillInfo;
    public RevenueBLL(){
        listBill= new ArrayList<>();
        listBillInfo= new ArrayList<>();
    }
    
    
    public void ShowRevenue(JTable jtable){
        FoodDAO foodDAO ;
        TableDAO tableDAO = new TableDAO();
        BillDAO billDAO =new BillDAO();       
        BillInfoDAO billInfoDAO =new BillInfoDAO();
        
        listBill =billDAO.GetBillListByStatus();
        
        DefaultTableModel revenuetb=(DefaultTableModel)jtable.getModel();
        revenuetb.setRowCount(0);
        
        Object row[] = new Object[5];
        for(int i = 0; i < listBill.size(); i++)
        {
            double total=0;
            
            listBillInfo =billInfoDAO.GetBillInfoListByBillId(listBill.get(i).getId());
            for(int j=0;j<listBillInfo.size();j++){
                double tam=0;
                foodDAO =new FoodDAO();
                double price= Double.parseDouble(foodDAO.GetFoodPriceById(listBillInfo.get(j).getFoodId()));
                tam=price* listBillInfo.get(j).getCount();
                total=tam+total;
            }
            row[0]=tableDAO.GetTableNameById(listBill.get(i).getTableId());
            row[1]=listBill.get(i).getCheckIn();
            row[2]=listBill.get(i).getCheckOut();
            row[3]=listBill.get(i).getDiscount();
            row[4]= total-(total*listBill.get(i).getDiscount()/100);
            //System.out.print(categoryList.get(i).getCategoryName());
            revenuetb.addRow(row);
        }
    }
    
    public void ShowRevenueByDate(JTable jtable, String fd, String scd){
        FoodDAO foodDAO ;
        TableDAO tableDAO = new TableDAO();
        BillDAO billDAO =new BillDAO();       
        BillInfoDAO billInfoDAO =new BillInfoDAO();
        
        
        
        listBill = billDAO.GetBillListByDate(fd, scd);
        
        DefaultTableModel revenuetb=(DefaultTableModel)jtable.getModel();
        revenuetb.setRowCount(0);
        
        Object row[] = new Object[5];
        for(int i = 0; i < listBill.size(); i++)
        {
            double total=0;
            
            listBillInfo =billInfoDAO.GetBillInfoListByBillId(listBill.get(i).getId());
            for(int j=0;j<listBillInfo.size();j++){
                double tam=0;
                foodDAO =new FoodDAO();
                double price= Double.parseDouble(foodDAO.GetFoodPriceById(listBillInfo.get(j).getFoodId()));
                tam=price* listBillInfo.get(j).getCount();
                total=tam+total;
            }
            row[0]=tableDAO.GetTableNameById(listBill.get(i).getTableId());
            row[1]=listBill.get(i).getCheckIn();
            row[2]=listBill.get(i).getCheckOut();
            row[3]=listBill.get(i).getDiscount();
            row[4]= total-(total*listBill.get(i).getDiscount()/100);
            //System.out.print(categoryList.get(i).getCategoryName());
            revenuetb.addRow(row);
        }
    }
    
    //===============================================================================================================
    /*
    public String valueOf(double i)
    {
        String s = String.valueOf(i);
        return s;
    }
    
    
    public double TotalPrice()
    {
        FoodDAO foodDAO ;
        TableDAO tableDAO = new TableDAO();
        BillDAO billDAO =new BillDAO();       
        BillInfoDAO billInfoDAO =new BillInfoDAO();
        
        listBill =billDAO.GetBillListByStatus();
        double Total=0;
        for(int i = 0; i < listBill.size(); i++)
        {
            double total=0;       
            listBillInfo =billInfoDAO.GetBillInfoListByBillId(listBill.get(i).getId());
            for(int j=0;j<listBillInfo.size();j++){
                double tam=0;
                foodDAO =new FoodDAO();
                double price= Double.parseDouble(foodDAO.GetFoodPriceById(listBillInfo.get(j).getFoodId()));
                tam=price* listBillInfo.get(j).getCount();
                total=tam+total;
            }
            Total=Total+(total-(total*listBill.get(i).getDiscount()/100));
        }
        return Total;
    }
    */
    //================================================================================================
    
    public String valueOf(long i)
    {
        String s = String.valueOf(i);
        return s;
    }
    
    public long TotalPrice()
    {
        FoodDAO foodDAO ;
        TableDAO tableDAO = new TableDAO();
        BillDAO billDAO =new BillDAO();       
        BillInfoDAO billInfoDAO =new BillInfoDAO();
        
        listBill =billDAO.GetBillListByStatus();
        long Total=0;
        for(int i = 0; i < listBill.size(); i++)
        {
            long total=0;       
            listBillInfo =billInfoDAO.GetBillInfoListByBillId(listBill.get(i).getId());
            for(int j=0;j<listBillInfo.size();j++){
                long tam=0;
                foodDAO =new FoodDAO();
                long price= Long.parseLong(foodDAO.GetFoodPriceById(listBillInfo.get(j).getFoodId()));
                tam=price* listBillInfo.get(j).getCount();
                total=tam+total;
            }
            Total=Total+(total-(total*listBill.get(i).getDiscount()/100));
        }
        return Total;
    }
    
}
