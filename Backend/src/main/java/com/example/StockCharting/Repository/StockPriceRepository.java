package com.example.StockCharting.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StockCharting.Entity.StockPrice;

public interface StockPriceRepository  extends JpaRepository<StockPrice,Long> {
	List<StockPrice> findByCodeAndName(String companycode,String exchangename);
}