package com.foundgrounds.menu;


import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	private Integer shopId;
	private String name;
	private String text;
	private String imageUrl;
	private Boolean deleted;
	private Date timePosted;
	
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Date getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(Date timePosted) {
		this.timePosted = timePosted;
	}
	
	
	

}
