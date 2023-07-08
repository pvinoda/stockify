package com.example.StockCharting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StockCharting.Entity.IPODetail;

@Repository
public interface IPOrepository extends JpaRepository<IPODetail, Long>{

}
