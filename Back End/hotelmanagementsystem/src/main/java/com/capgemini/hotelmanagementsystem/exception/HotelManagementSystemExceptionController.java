package com.capgemini.hotelmanagementsystem.exception;

@SuppressWarnings("serial")
public class HotelManagementSystemExceptionController extends RuntimeException {
	
	String message;
	
	public HotelManagementSystemExceptionController(String message) {
		super(message);
	}
}
