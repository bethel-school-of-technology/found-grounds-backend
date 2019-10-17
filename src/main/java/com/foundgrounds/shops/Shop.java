package com.foundgrounds.shops;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CoffeeShops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ShopID;
	private Integer DrinkID;
	private Integer FoodID;
	private Integer SpecialsID;
	private Integer EventsID;
	private String Name;
	private String Tagline;
	private Date HoursOfOp;
	private String StreetAddress1;
	private String StreetAddress2;
	private String City;
	private String State;
	private Integer Zip;
	private String MapsLocationInfo;
	private Boolean IsOpen;
	private Integer NumVisits;
	
	
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
	public Integer getSpecialsID() {
		return SpecialsID;
	}
	public void setSpecialsID(Integer specialsID) {
		SpecialsID = specialsID;
	}
	public Integer getEventsID() {
		return EventsID;
	}
	public void setEventsID(Integer eventsID) {
		EventsID = eventsID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTagline() {
		return Tagline;
	}
	public void setTagline(String tagline) {
		Tagline = tagline;
	}
	public Date getHoursOfOp() {
		return HoursOfOp;
	}
	public void setHoursOfOp(Date hoursOfOp) {
		HoursOfOp = hoursOfOp;
	}
	public String getStreetAddress1() {
		return StreetAddress1;
	}
	public void setStreetAddress1(String streetAddress1) {
		StreetAddress1 = streetAddress1;
	}
	public String getStreetAddress2() {
		return StreetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		StreetAddress2 = streetAddress2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public Integer getZip() {
		return Zip;
	}
	public void setZip(Integer zip) {
		Zip = zip;
	}
	public String getMapsLocationInfo() {
		return MapsLocationInfo;
	}
	public void setMapsLocationInfo(String mapsLocationInfo) {
		MapsLocationInfo = mapsLocationInfo;
	}
	public Boolean getIsOpen() {
		return IsOpen;
	}
	public void setIsOpen(Boolean isOpen) {
		IsOpen = isOpen;
	}
	public Integer getNumVisits() {
		return NumVisits;
	}
	public void setNumVisits(Integer numVisits) {
		NumVisits = numVisits;
	}
	
	
}
