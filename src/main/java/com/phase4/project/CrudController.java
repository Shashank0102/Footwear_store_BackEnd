package com.phase4.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phase4.project.ExceptionHandling.BusinessException;
import com.phase4.project.Model.PurchaseReport;
import com.phase4.project.Model.Shoe;
import com.phase4.project.service.ShoeService;

@RestController
public class CrudController {

	@Autowired
	private ShoeService service;
	
	private MultiValueMap<String,String> errorMap;
	
	
	@PostMapping("/owner/shoe")
	public ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe){
		try{
			return new ResponseEntity<>(service.createShoe(shoe),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap= new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/owner/shoe/{id}")
	public ResponseEntity<Shoe> getShoeById(@PathVariable int id){
		try {
			return new ResponseEntity<>(service.getShoebyId(id),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap= new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/owner/shoe")
	public ResponseEntity<Shoe> updateShoe(@RequestBody Shoe shoe ){
		
			return new ResponseEntity<>(service.updateShoe(shoe),HttpStatus.OK);
		
	}
	@DeleteMapping("/owner/shoe/{id}")
	public ResponseEntity<String> deleteShoeById(@PathVariable int id){
		try {
			service.deleteShoeById(id);
			return new ResponseEntity<>("Succesfully delete shoe by id"+id,HttpStatus.OK);
		}catch (BusinessException e) {
			errorMap= new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.BAD_REQUEST);
		}
	}
	
	/*PurchaseReportsCrud*/
	
	@PostMapping("/owner/purchaseReport")
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport p ){
		try{
			return new ResponseEntity<>(service.createPurchaseReport(p),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap= new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/owner/purchaseReport/{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id){
		try {
			return new ResponseEntity<>(service.getPurchaseReportbyId(id),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap= new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/owner/purchaseReport")
	public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport p ){
		
			return new ResponseEntity<>(service.updatePurchaseReport(p),HttpStatus.OK);
		
	}
	@DeleteMapping("/owner/purchaseReport/{id}")
	public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id){
		try {
			service.deletePurchaseReportById(id);
			return new ResponseEntity<>("Succesfully delete PurchaseReport by id"+id,HttpStatus.OK);
		}catch (BusinessException e) {
			errorMap= new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.BAD_REQUEST);
		}
	}
}
