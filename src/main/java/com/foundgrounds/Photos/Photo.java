package com.foundgrounds.Photos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Photos")
public class Photo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PhotoID;
    private Integer FoodID;
    private Integer DrinkID;
    private String Path;
    private String Caption;
    private Boolean IsDrink; 
    private Boolean IsFood;
	
    
    public Integer getPhotoID() {
		return PhotoID;
	}
	public void setPhotoID(Integer photoID) {
		PhotoID = photoID;
	}
	public Integer getFoodID() {
		return FoodID;
	}
	public void setFoodID(Integer foodID) {
		FoodID = foodID;
	}
	public Integer getDrinkID() {
		return DrinkID;
	}
	public void setDrinkID(Integer drinkID) {
		DrinkID = drinkID;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getCaption() {
		return Caption;
	}
	public void setCaption(String caption) {
		Caption = caption;
	}
	public Boolean getIsDrink() {
		return IsDrink;
	}
	public void setIsDrink(Boolean isDrink) {
		IsDrink = isDrink;
	}
	public Boolean getIsFood() {
		return IsFood;
	}
	public void setIsFood(Boolean isFood) {
		IsFood = isFood;
	}
    
    

}
