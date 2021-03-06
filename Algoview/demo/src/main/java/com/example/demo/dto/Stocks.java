package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor         
@NoArgsConstructor			
@Builder
@RedisHash("Stock")
public class Stocks implements Serializable{
	//private static final long serialVersionUID = 6529685098267757690L;

	@Id
	private BigDecimal sId;
	private String sName;
	private BigDecimal sPrice;
	private BigDecimal sChange;
	private String sCurrency;
	private String sSymbol;
	private LocalDateTime sTime;
}
