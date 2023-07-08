package com.example.StockCharting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StockCharting.Entity.StockExchange;

@Repository
public interface StockExchangeRepository  extends JpaRepository<StockExchange,Long> {
	StockExchange findByName(String name);
}