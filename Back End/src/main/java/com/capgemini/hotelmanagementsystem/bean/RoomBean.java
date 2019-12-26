package com.capgemini.hotelmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "room")
public class RoomBean {
	@Id
	@Column(name = "room_id")
	@Pattern(regexp="[0-9]", message="It Accepts only number")
	private int roomId;
	
	
	@Column(name = "room_rent")
	private double roomRent;
	@Column(name = "room_type")
	private String roomType;
	
	@Column(name = "room_capacity")
	@Pattern(regexp="[0-9]", message="It Accepts only number")
	private int roomCapacity;
	
	@Column(name = "room_status")
	private String roomStatus;
	
	@Column(name = "hotel_id")
	@Pattern(regexp="[0-9]", message="It Accepts only number")
	private int hotelId;
	
	@Column(name = "room_facility")
	private String roomFacility;

	public String getRoomFacility() {
		return roomFacility;
	}

	public void setRoomFacility(String roomFacility) {
		this.roomFacility = roomFacility;
	}

	// getter & setter
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getRoomRent() {
		return roomRent;
	}

	public void setRoomRent(double roomRent) {
		this.roomRent = roomRent;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

}
