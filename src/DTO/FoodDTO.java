/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author lizid
 */
public class FoodDTO {
    private int foodId;
    private String foodName;
    private int catId;
    private String foodPrice;
    public FoodDTO(){
        foodId=0;
        foodName="";
        catId=0;
        foodPrice="";
    }
    
    public FoodDTO(int foodId, String foodName, int catId, String foodPrice){
        this.foodId=foodId;
        this.foodName=foodName;
        this.catId=catId;
        this.foodPrice=foodPrice;
    }
    
    public FoodDTO(FoodDTO food){
        this.foodId=food.foodId;
        this.foodName=food.foodName;
        this.catId=food.catId;
        this.foodPrice=food.foodPrice;
    }

    /**
     * @return the foodId
     */
    public int getFoodId() {
        return foodId;
    }

    /**
     * @param foodId the foodId to set
     */
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    /**
     * @return the foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * @param foodName the foodName to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * @return the catId
     */
    public int getCatId() {
        return catId;
    }

    /**
     * @param catId the catId to set
     */
    public void setCatId(int catId) {
        this.catId = catId;
    }

    /**
     * @return the foodPrice
     */
    public String getFoodPrice() {
        return foodPrice;
    }

    /**
     * @param foodPrice the foodPrice to set
     */
    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }
}
