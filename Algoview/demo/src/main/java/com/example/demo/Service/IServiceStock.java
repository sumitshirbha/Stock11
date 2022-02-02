package com.example.demo.Service;

import java.io.IOException;
import java.util.List;

import com.example.demo.dto.Stocks;
import com.example.demo.exception.StockNotFoundException;

public interface IServiceStock {
	public Stocks stocks( String symbol) throws IOException;
	public List<Stocks> allStocks()throws IOException;
}
