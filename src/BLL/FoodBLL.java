/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.ConnectSQLServer;
import DAO.FoodDAO;
import DTO.FoodDTO;
import java.util.ArrayList;

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
    
}
