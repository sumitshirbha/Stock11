package com.startup.in.repositorys;

public class StockQuery {
	
	
	public static final String GETUNIQESYMBOL="select distinct stock_symbol from stock_info";

	public static final String UPDATEPRICE="update stock_info set update_stock_price= :updatePrice,update_stock_time= :updateTime where stock_symbol= :stocksym ";
	//public static final String UPDATEPRICE="UPDATE stock_price[1]= :stockPrice from stock_info where stock_symbol=:stockSym";
}
