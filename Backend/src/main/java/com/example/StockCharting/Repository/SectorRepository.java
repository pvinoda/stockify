package com.example.StockCharting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StockCharting.Entity.Sector;
@Repository
public interface SectorRepository  extends JpaRepository<Sector,Long> {
   Sector  findByName(String Name);
   
}