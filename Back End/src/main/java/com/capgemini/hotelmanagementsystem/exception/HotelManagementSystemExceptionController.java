package com.capgemini.hotelmanagementsystem.exception;

public class HotelManagementSystemExceptionController extends Exception {
	String message;

	public HotelManagementSystemExceptionController(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
