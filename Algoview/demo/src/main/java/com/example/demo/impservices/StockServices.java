package com.example.demo.impservices;


import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.Service.IServiceStock;
import com.example.demo.dto.Stocks;
import com.example.demo.exception.StockNotFoundException;
import com.example.demo.repository.StocksRepository;

import yahoofinance.YahooFinance;
import yahoofinance.Stock;



@Service
public class StockServices implements IServiceStock {

	@Autowired
	private StocksRepository  stocksRepository ;
	
	
//	@Scheduled(initialDelay = 10000,fixedDelay = 30000)
//	public void updateStockPrice() throws IOException {
//		 List <Stocks> listOfStocks=	stocksRepository.findAll();
//		// List<String> listOfsym=listOfStocks.stream().map(Stocks::getSSymbol).collect(Collectors.toList());
//		 
//		 
//		 
//		 //Map<String, Stock> stock =YahooFinance.get(listOfsym.toArray(new String[0]));
//		 
//		 
//		// System.out.println(listOfsym.toArray(new String[0]));
//		 // Map<BigDecimal,Stocks > map = new HashMap<>();
////	
////		 for (Stocks stu : listOfStocks) {
//	//            map.put(stu.getSId(), stu);}
//	         //   stocksRepository.sheduledSave(map);
//	
//	}
	

	public  Stocks stocks( String symbol) throws IOException{

		Stock stock =YahooFinance.get(symbol);
		Stocks stockn =Stocks.builder()
				.sName(stock.getName())
				.sChange(stock.getQuote().getChange())
				.sCurrency(stock.getCurrency())
				.sId(stock.getQuote().getBid())
				.sPrice(stock.getQuote().getPrice())
				.sSymbol(stock.getSymbol())
				.sTime(LocalDateTime.now())
				.build();
		stocksRepository.save(stockn);
		
		return stockn;
	}

	@Override
	public List<Stocks> allStocks() throws IOException {
		System.out.println(stocksRepository.findAll());
		return stocksRepository.findAll();

		
	}
	
}
