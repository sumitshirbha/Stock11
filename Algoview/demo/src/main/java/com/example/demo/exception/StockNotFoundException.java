package com.example.demo.exception;

public class StockNotFoundException extends Exception {

	public StockNotFoundException() {
		super();
	}
	
	public StockNotFoundException(String msg) {
		super(msg);
	}
}
