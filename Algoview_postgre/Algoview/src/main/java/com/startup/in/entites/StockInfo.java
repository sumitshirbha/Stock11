package com.startup.in.entites;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="STOCK_INFO")
public class StockInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STOCK_ID")
	private Integer stockId;
	@Column(name = "STOCK_NAME")
	private String stockName;
	@Column(name = "STOCK_SYMBOL")
	private String stockSymbol;
	//@Column(name = "STOCK_PRICE")
//	@ElementCollection
//	List<BigDecimal> stockPrice=new ArrayList<>();
	@Column(name = "STOCK_TIME")
	private LocalDateTime stockTime;
	@Column(name = "UPDATE_STOCK_TIME")
	private LocalDateTime updateStockTime;
	@Column(name = "STOCK_PRICE")
	private BigDecimal stockPrice;
	@Column(name = "UPDATE_STOCK_PRICE")
	private BigDecimal updateStockPrice;
	
	
}
