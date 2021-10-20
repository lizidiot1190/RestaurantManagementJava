/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.CategoryDAO;
import DTO.CategoryDTO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Admin
 */
public class CategoryBLL {
    private ArrayList<CategoryDTO> categoryList;
    
    public ArrayList<CategoryDTO>GetCategoryList()
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryList=categoryDAO.GetCategoryList();
        return this.categoryList;
    }
    
    public void GetListCategory(JTable table)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryList=categoryDAO.GetCategoryList();
        DefaultTableModel cattb=(DefaultTableModel)table.getModel();
        cattb.setRowCount(0);
        Object row[] = new Object[2];
        for(int i = 0; i < categoryList.size(); i++)
        {
            row[0]=categoryList.get(i).getCategoryID();
            row[1]=categoryList.get(i).getCategoryName();
            //System.out.print(categoryList.get(i).getCategoryName());
            cattb.addRow(row);
        }
    }
    /*private ArrayList<CategoryDTO> categoryDTO;
    public CategoryBLL()
    {
        categoryDTO = new ArrayList<CategoryDTO>();        
    }
    public void AddCategoy(CategoryDTO cat)
    {
        this.categoryDTO.add(cat);
    }*/
    public void AddCategory(String categoryName)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.AddCategory(categoryName);
    }
    public void UpdateCategory(String categoryName, int categoryID)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.UpdateCategory(categoryName, categoryID);
    }
    public void DeleteCategory(int categoryID)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.DeleteCategory(categoryID);
    }   
}
