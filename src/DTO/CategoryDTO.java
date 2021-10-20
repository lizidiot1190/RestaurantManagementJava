/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class CategoryDTO {
    private int categoryID;
    private String categoryName;
    
    public CategoryDTO()
    {
        categoryID = 0;
        categoryName = "";
    }
    public CategoryDTO(int categoryID, String categoryName)
    {
        this.categoryID=categoryID;
        this.categoryName=categoryName;
    }
    public CategoryDTO(CategoryDTO cat)
    {
        this.categoryID=cat.categoryID;
        this.categoryName=cat.categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
