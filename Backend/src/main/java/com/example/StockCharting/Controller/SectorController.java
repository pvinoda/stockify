package com.example.StockCharting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StockCharting.Entity.Company;
import com.example.StockCharting.Entity.Sector;
import com.example.StockCharting.Service.SectorService;

@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping("/sectors")
public class SectorController {

	@Autowired
	private SectorService sectorService;
	
	@GetMapping(path = "")
	public ResponseEntity<List<Sector>> findAll() {
		return ResponseEntity.ok(sectorService.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Sector> findById(@PathVariable long id)
	{
		Sector sector = sectorService.findById(id);
	/*	if(sector == null) {
			throw new SectorNotFoundException("Sector not found for id : " + id);
		}*/
		return ResponseEntity.ok(sector);
	}
	
	@PostMapping(path = "")
	public ResponseEntity<Sector> save(@RequestBody Sector sector) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(sectorService.save(sector));
	}
	@PutMapping(path = "")
	public ResponseEntity<Sector> update(@RequestBody Sector sector)
	{
		Sector updatedSector = sectorService.save(sector);
		/*if(updatedSectorDto == null) {
			throw new SectorNotFoundException("Sector not found for id : " + sector.getId());
		}*/
		return ResponseEntity.ok(updatedSector);
	}
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable long id) {
		sectorService.deleteById(id);
	}
	
	@GetMapping(path = "/{id}/companies")
	public ResponseEntity<List<Company>> getCompanies(@PathVariable long id) 
	{
		List<Company> companies = sectorService.getCompanies(id);
		/*if(company == null) {
			throw new SectorNotFoundException("Sector not found for id : " + id);
		}*/
		return ResponseEntity.ok(companies);
	}
	
}
