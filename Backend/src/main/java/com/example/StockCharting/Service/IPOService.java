package com.example.StockCharting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StockCharting.Entity.IPODetail;
import com.example.StockCharting.Repository.IPOrepository;

@Service
public class IPOService {
    @Autowired
    private IPOrepository iporepo;
	public List<IPODetail> getAllIPO() {
		List<IPODetail> ipos=iporepo.findAll();
		return ipos;
	}

}
