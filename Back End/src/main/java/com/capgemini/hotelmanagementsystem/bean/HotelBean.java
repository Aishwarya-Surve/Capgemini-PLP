package com.capgemini.hotelmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "hotel")
public class HotelBean {
	@Id
	@Column(name = "hotel_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hotelId;
	@Column(name = "hotel_name")
	private String hotelName;
	@Column(name = "location")
	private String location;
	@Column(name = "available_ac")
	private int availableAcRoom;
	@Column(name = "available_non_ac")
	private int availableNonAcRoom;
	// getter & setter

	public int getHotelId() {
		return hotelId;
	}

	public int getAvailableAcRoom() {
		return availableAcRoom;
	}

	public void setAvailableAcRoom(int availableAcRoom) {
		this.availableAcRoom = availableAcRoom;
	}

	public int getAvailableNonAcRoom() {
		return availableNonAcRoom;
	}

	public void setAvailableNonAcRoom(int availableNonAcRoom) {
		this.availableNonAcRoom = availableNonAcRoom;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}// end of bean class
