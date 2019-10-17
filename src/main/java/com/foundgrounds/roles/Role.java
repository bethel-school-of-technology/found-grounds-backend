package com.foundgrounds.roles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Role {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer RolesID;
	private String Description;
	private Boolean IsActive;
	
	public Integer getRolesID() {
		return RolesID;
	}
	public void setRolesID(Integer rolesID) {
		RolesID = rolesID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Boolean getIsActive() {
		return IsActive;
	}
	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	} 

}
