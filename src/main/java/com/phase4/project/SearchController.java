package com.phase4.project;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.phase4.project.Model.PurchaseReport;
import com.phase4.project.Model.Shoe;
import com.phase4.project.service.ShoeService;

@RestController
public class SearchController {

	@Autowired
	private ShoeService service;
	
	@GetMapping ("/owner/shoe/all")
	public ResponseEntity<List<Shoe>> getAllShoe(){
		return new ResponseEntity<>(service.getAllShoes(),HttpStatus.OK);
	}
	
	@GetMapping ("/owner/PurchaseReport/all")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReport(){
		return new ResponseEntity<>(service.getAllPurchaseReports(),HttpStatus.OK);
	}
	
	@GetMapping ("/owner/PurchaseReport/brand")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportByBrand(@PathVariable String brand){
		return new ResponseEntity<>(service.getAllPurchaseReportsBrand(brand),HttpStatus.OK);
	}
	
	@GetMapping ("/owner/PurchaseReport/dop")
	public ResponseEntity<List<PurchaseReport>> getAllShoe(@PathVariable Date dop){
		return new ResponseEntity<>(service.getAllPurchaseReportsByDop(dop),HttpStatus.OK);
	}
}
