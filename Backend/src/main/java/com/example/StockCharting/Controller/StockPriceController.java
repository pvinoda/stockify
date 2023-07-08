package com.example.StockCharting.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.StockCharting.Entity.Company;
import com.example.StockCharting.Entity.CompanyCompareRequest;
import com.example.StockCharting.Entity.Companystockexchangemap;
import com.example.StockCharting.Entity.StockPrice;
import com.example.StockCharting.Repository.Companystockexchangemaprepository;
import com.example.StockCharting.Repository.StockPriceRepository;
import com.example.StockCharting.Service.StockPriceSERVICE;

@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping("/stockprices")
public class StockPriceController {
@Autowired
StockPriceRepository stkpricerepo;
@Autowired
StockPriceSERVICE stkpriceservice;
@Autowired
Companystockexchangemaprepository cmpstkmaprepo;

/*{    "exchangename": "bse",
    "companycode": "TCS",

        "datee ": "2014-01-01T23:28:56.782Z",
        "timee" :"10:20:00"  } expected json format*/
 
//@CrossOrigin(origins ="http://reactive01.herokuapp.com")
//@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping(value = "/addstockprices",method=RequestMethod.POST)
public  ResponseEntity<List<StockPrice>> stockpriceapi(@RequestBody List<StockPrice> stockprices) throws ClassNotFoundException, IOException {
    List<StockPrice> stkprice=new ArrayList<StockPrice>();
	for(StockPrice stockprice:stockprices) {
		System.out.println(stockprice.toString());
	Companystockexchangemap  csemap=cmpstkmaprepo.
			findByCodeAndName(stockprice.getCompanycode(), stockprice.getExchangename());
	Company company=csemap.getCompany();
	stockprice.setCompany(company);
    stockprice=stkpricerepo.save(stockprice);
    stkprice.add(stockprice);
    }
   // make sure your entity class properties of price are in lower case and match the json,to avoid errors
/*    System.out.println(stkprice +"check this " +stkprice.getCompanycode());
 
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stkprice.getId())
            .toUri();
*/
	
    return ResponseEntity.ok(stkprice);
}
@PostMapping(path = "/compareCompany")
@CrossOrigin(origins ="http://localhost:4200")
public ResponseEntity<List<StockPrice>> companyComparison(@RequestBody CompanyCompareRequest compareRequest)
{   System.out.println(compareRequest.toString());
	List<StockPrice> stockPrice= stkpriceservice.getStockPricesForCompanyComparison(compareRequest);
	HttpHeaders headers = new HttpHeaders();
	headers.add("Access-Control-Allow-Origin", "*");
	//System.out.println(stockPrice.toString());
	return ResponseEntity.ok(stockPrice);
}
//@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping(value = "/getstockprices",method=RequestMethod.GET, headers = "Accept=application/json"  )
public List<StockPrice> getstockprice() throws ClassNotFoundException, IOException {

  List<StockPrice> stkprice= stkpricerepo.findAll();
 // make sure your entity class properties of user are in lower case and match the json,to avoid errors
  return stkprice;
}
@DeleteMapping(path="/deleteAll")
public void deleteAllPrices()
{
	stkpricerepo.deleteAll();
}

}