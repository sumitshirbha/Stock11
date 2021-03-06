package com.example.demo.controllers;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Service.IServiceStock;
import com.example.demo.dto.Stocks;



@RequestMapping(path="Stocks")
@RestController
public class StockController {
	
	@Autowired
	private IServiceStock iServiceStock;
	
	@GetMapping("/{name}")
	public ResponseEntity<Stocks>addStockInfo(@PathVariable String name){
		try{
			Stocks stock=iServiceStock.stocks(name);
		return new ResponseEntity<Stocks>(stock,HttpStatus.CREATED);
	
		}catch(IOException exe){
			 throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Stock not found", exe);
		}
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<Stocks>>allStockInfo(){
		try{
			List<Stocks> stock=iServiceStock.allStocks();
		return new ResponseEntity<List<Stocks>>(stock,HttpStatus.CREATED);
	
		}catch(IOException exe){
			 throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Stock not found", exe);
		}
		
	}

}
