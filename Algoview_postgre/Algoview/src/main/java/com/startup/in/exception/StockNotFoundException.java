package com.startup.in.exception;

public class StockNotFoundException extends RuntimeException {

	public StockNotFoundException() {
		super();
	}
	
	public StockNotFoundException(String msg) {
		super(msg);
	}
}
