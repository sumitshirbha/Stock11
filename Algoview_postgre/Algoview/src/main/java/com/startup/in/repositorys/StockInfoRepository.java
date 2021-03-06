package com.startup.in.repositorys;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.startup.in.entites.StockInfo;

public interface StockInfoRepository extends JpaRepository<StockInfo, Integer>{
	
	
@Query(value = StockQuery.GETUNIQESYMBOL,nativeQuery = true)
public List<String> UniqueStockSym();	
@Transactional
@Modifying
@Query(value = StockQuery.UPDATEPRICE,nativeQuery = true)
public void updateValue(@Param("updatePrice") BigDecimal updatePrice,@Param("stocksym") String stocksym,@Param("updateTime") LocalDateTime updateTime);	


	
	
	
	
}
