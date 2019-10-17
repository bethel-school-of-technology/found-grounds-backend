package com.foundgrounds.coffeeRefs;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CoffeeReference")
public class CoffeeRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ShopID;
	private Integer DrinkID;
	private Integer FoodID;
	private Integer EventsID;
	private Boolean IsCurrent;
	private Date DateModified;
	
	
	public Integer getShopID() {
		return ShopID;
	}
	public void setShopID(Integer shopID) {
		ShopID = shopID;
	}
	public Integer getDrinkID() {
		return DrinkID;
	}
	public void setDrinkID(Integer drinkID) {
		DrinkID = drinkID;
	}
	public Integer getFoodID() {
		return FoodID;
	}
	public void setFoodID(Integer foodID) {
		FoodID = foodID;
	}
	public Integer getEventsID() {
		return EventsID;
	}
	public void setEventsID(Integer eventsID) {
		EventsID = eventsID;
	}
	public Boolean getIsCurrent() {
		return IsCurrent;
	}
	public void setIsCurrent(Boolean isCurrent) {
		IsCurrent = isCurrent;
	}
	public Date getDateModified() {
		return DateModified;
	}
	public void setDateModified(Date dateModified) {
		DateModified = dateModified;
	}
	
	
}
