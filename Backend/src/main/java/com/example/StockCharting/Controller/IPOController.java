package com.example.StockCharting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StockCharting.Entity.IPODetail;
import com.example.StockCharting.Repository.Companyrepository;
import com.example.StockCharting.Repository.IPOrepository;
import com.example.StockCharting.Service.IPOService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/ipos")
public class IPOController {
	@Autowired
	private IPOrepository iporepo;
	@Autowired
	private Companyrepository cmprepo;
	@Autowired
	private IPOService iposervice;
@PostMapping(path="")
public ResponseEntity<IPODetail> addIPO(@RequestBody IPODetail ipodetail)
{    
	return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(iporepo.save(ipodetail));
}
@GetMapping(path="")
public ResponseEntity<List<IPODetail>> getAllIPO()
{
	return ResponseEntity.ok(iposervice.getAllIPO());
}
}
