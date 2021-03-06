package com.startup.in.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.startup.in.entites.StockInfo;
import com.startup.in.exception.StockNotFoundException;
import com.startup.in.services.IServiceStockInfo;

@RequestMapping(path="StockInfo")
@RestController
public class ControllerStockInfo {
	@Autowired
	private IServiceStockInfo serviceStockInfo;

	@GetMapping("/{name}")
	public ResponseEntity<StockInfo> addStockInfo(@PathVariable String name) throws IOException {
		StockInfo stockInfo = serviceStockInfo.saveStockinfo(name);
		return new ResponseEntity<StockInfo>(stockInfo, HttpStatus.CREATED);

	}

	@GetMapping
	public   ResponseEntity<List<StockInfo>> allStockInfo() {
		try {
			Optional<List<StockInfo>> stock = serviceStockInfo.allStockInfo();
//			return cookie.map(c -> ResponseEntity.ok().body(c))
//	                .orElse(ResponseEntity.notFound().build());
			return stock.map(c->new ResponseEntity<List<StockInfo>>(c, HttpStatus.CREATED)).orElse(ResponseEntity.notFound().build());
			
//			if(stock.isPresent()) {
//				//throw new StockNotFoundException();
//			
//			return new ResponseEntity<List<StockInfo>>(stock, HttpStatus.CREATED);}
//			throw new StockNotFoundException();
			
		} catch (IOException |StockNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock not found", exc);
		}

	}
}
