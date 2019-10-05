package com.foundgrounds.Food;

import java.sql.Date;
import java.text.DecimalFormat;

import javax.persistence.*;

@Entity
@Table(name="Food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer FoodID;
	private Integer ShopID;
	private Integer PhotoID;
	private String Description;
	private DecimalFormat Price;
	private Boolean IsCurrent; 
	private Boolean TastesGood;
	private Date DateTried;
	public Integer getFoodID() {
		return FoodID;
	}
	public void setFoodID(Integer foodID) {
		FoodID = foodID;
	}
	public Integer getShopID() {
		return ShopID;
	}
	public void setShopID(Integer shopID) {
		ShopID = shopID;
	}
	public Integer getPhotoID() {
		return PhotoID;
	}
	public void setPhotoID(Integer photoID) {
		PhotoID = photoID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public DecimalFormat getPrice() {
		return Price;
	}
	public void setPrice(DecimalFormat price) {
		Price = price;
	}
	public Boolean getIsCurrent() {
		return IsCurrent;
	}
	public void setIsCurrent(Boolean isCurrent) {
		IsCurrent = isCurrent;
	}
	public Boolean getTastesGood() {
		return TastesGood;
	}
	public void setTastesGood(Boolean tastesGood) {
		TastesGood = tastesGood;
	}
	public Date getDateTried() {
		return DateTried;
	}
	public void setDateTried(Date dateTried) {
		DateTried = dateTried;
	}
	
	
}
