package com.startup.in.impService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.startup.in.entites.StockInfo;
import com.startup.in.exception.StockNotFoundException;
import com.startup.in.repositorys.StockInfoRepository;
import com.startup.in.services.IServiceStockInfo;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Service
public class ImpServiceStockInfo implements IServiceStockInfo {

	private static final Logger logger = LoggerFactory.getLogger(ImpServiceStockInfo.class);

	@Autowired
	private StockInfoRepository stockInfoRepository;

	@Scheduled(initialDelay = 10000, fixedDelay = 300000) // (cron = "0 30 9,15 * * 1,2,3,4,5")
	public void updateStockPrice() throws IOException {
		
		try {
			
			
			if(!(stockInfoRepository.findAll()== null)) {
			Map<String, Stock> stock1 = YahooFinance
					.get((String[]) stockInfoRepository.UniqueStockSym().toArray(new String[0]));
			
			stock1.values().stream().forEach((stock) -> {
				stockInfoRepository.updateValue(stock.getQuote().getPrice(), stock.getSymbol(), LocalDateTime.now());
			});// updates date and time using query	
			
			}
		
																								
			
	
		
			throw new StockNotFoundException("No such Symbol for the stock");																							
			}catch(StockNotFoundException exc) {
				
			}

	}

	@Override
	public StockInfo saveStockinfo(String stocksym) throws IOException,StockNotFoundException {

		Stock stock = YahooFinance.get(stocksym);
		if(stock==null) {
			throw new StockNotFoundException("No such Symbol for the stock");	
		}
		StockInfo stockn = StockInfo.builder().stockName(stock.getName())
				// .stockPrice(Arrays.asList(stock.getQuote().getPrice()))
				// .(stockPrice.add(stock.getQuote().getPrice()))
				.stockPrice(stock.getQuote().getPrice()).stockSymbol(stock.getSymbol()).stockTime(LocalDateTime.now())
				.build();

		logger.info("Trying to save stockinfo in database ");
		System.out.println(stockInfoRepository.UniqueStockSym().toString());
		return stockInfoRepository.save(stockn);

	}

	@Override
	public Optional<List<StockInfo>> allStockInfo() throws IOException {
		logger.info("Trying to fetch all stocks from db");

		Optional<List<StockInfo>> allStock = Optional.ofNullable(stockInfoRepository.findAll());

		if (allStock.isEmpty()) {
			throw new StockNotFoundException("NO stock are saved");
		} else {
			return allStock;
		}

	}

}
