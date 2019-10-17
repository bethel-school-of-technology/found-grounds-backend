package com.foundgrounds.events;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Drinks")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer EventsID;
	private String Description;
	private Date Time;
	private Boolean IsCurrent;
	
	
	public Integer getEventsID() {
		return EventsID;
	}
	public void setEventsID(Integer eventsID) {
		EventsID = eventsID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public Boolean getIsCurrent() {
		return IsCurrent;
	}
	public void setIsCurrent(Boolean isCurrent) {
		IsCurrent = isCurrent;
	}
	
	

}
