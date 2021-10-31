/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.CategoryDAO;
import DAO.ConnectSQLServer;
import DAO.FoodDAO;
import DTO.FoodDTO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizid
 */
public class FoodBLL {
    private ArrayList<FoodDTO> listFood;
    public FoodBLL(){
        listFood = new ArrayList<>();
    }
    
    public ArrayList<FoodDTO> getListFood(){
        FoodDAO db=new FoodDAO();
        listFood =db.GetFoodList();
        return this.listFood;
    }
    
    public void GetListFood(JTable table){
        FoodDAO db=new FoodDAO();
        listFood =db.GetFoodList();
        DefaultTableModel foodtb=(DefaultTableModel)table.getModel();
        foodtb.setRowCount(0);
        Object row[] = new Object[4];
        for(int i = 0; i < listFood.size(); i++)
        {
            row[0]=listFood.get(i).getFoodId();
            row[1]=listFood.get(i).getFoodName();
            CategoryDAO cate =new CategoryDAO();
            
            row[2]=cate.GetCateNameById(listFood.get(i).getCatId());
            row[3]=listFood.get(i).getFoodPrice();
            //System.out.print(categoryList.get(i).getCategoryName());
            foodtb.addRow(row);
        }
    }
    
    public void AddFood(String foodName, String catName, String Price)
    {
        FoodDAO foodDAO = new FoodDAO();
        CategoryDAO catDAO = new CategoryDAO();
        int catID= catDAO.GetCateIdByName(catName);
        foodDAO.AddFood(foodName, catID, Price);
    }
    public void UpdateFood(String foodName, String catName, String Price, int foodID)
    {
        FoodDAO foodDAO = new FoodDAO();
        CategoryDAO catDAO = new CategoryDAO();
        int catID = catDAO.GetCateIdByName(catName);
        foodDAO.UpdateFood(foodName, catID, Price, foodID);
    }
    public void DeleteFood(int foodID)
    {
        FoodDAO foodDAO = new FoodDAO();
        foodDAO.DeleteFood(foodID);
    }
}
