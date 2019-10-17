package com.foundgrounds.users;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserID;
	private Integer RolesID;
	private String Email;
	private static String Username;
	private static String Password;
	private String AuthToken;
	private String FirstName;
	private String LastName;
	private Boolean CanAdvertise; 
	private String StreetAddress1;
	private String StreetAddress2;
	private String City;
	private String State; 
	private Integer Zip;
	private Boolean AmHome;
	
	
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public Integer getRolesID() {
		return RolesID;
	}
	public void setRolesID(Integer rolesID) {
		RolesID = rolesID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public static String getUsername() {
		return Username;
	}
	public static void setUsername(String username) {
		Username = username;
	}
	public static String getPassword() {
		return Password;
	}
	public static void setPassword(String password) {
		Password = password;
	}
	public String getAuthToken() {
		return AuthToken;
	}
	public void setAuthToken(String authToken) {
		AuthToken = authToken;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Boolean getCanAdvertise() {
		return CanAdvertise;
	}
	public void setCanAdvertise(Boolean canAdvertise) {
		CanAdvertise = canAdvertise;
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
	public Boolean getAmHome() {
		return AmHome;
	}
	public void setAmHome(Boolean amHome) {
		AmHome = amHome;
	}
	
}
