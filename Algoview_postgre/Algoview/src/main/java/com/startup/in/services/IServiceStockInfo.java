package com.startup.in.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.startup.in.entites.StockInfo;



public interface IServiceStockInfo {

	public StockInfo saveStockinfo(String stocksym) throws IOException ;
	public Optional<List<StockInfo>> allStockInfo()throws IOException;
	
	
	
}
