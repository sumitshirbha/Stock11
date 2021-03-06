package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Stocks;

@Repository
public class StocksRepository {
public static final String HASH_KEY ="Stock";
@Autowired

private RedisTemplate rTemplate;
public Map<BigDecimal, Stocks> sheduledSave(Map<BigDecimal,Stocks> stock){
	
    rTemplate.opsForHash().putAll(HASH_KEY, stock);
    return stock;
}

public Stocks save(Stocks stock){
	
    rTemplate.opsForHash().put(HASH_KEY,stock.getSId(),stock);
    return stock;
}


public List<Stocks> findAll(){
    return rTemplate.opsForHash().values(HASH_KEY);
//	 return rTemplate.opsForHash().entries(HASH_KEY);Map<Integer,Stocks>
}
public Stocks findStockById(int id){
	
    return (Stocks) rTemplate.opsForHash().get(HASH_KEY,id);
}


public String deleteProduct(int id){
	rTemplate.opsForHash().delete(HASH_KEY,id);
    return "stock removed !!";
}


}
