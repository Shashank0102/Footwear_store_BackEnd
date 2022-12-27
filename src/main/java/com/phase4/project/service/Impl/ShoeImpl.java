package com.phase4.project.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase4.project.ExceptionHandling.BusinessException;
import com.phase4.project.Model.PurchaseReport;
import com.phase4.project.Model.Shoe;
import com.phase4.project.Repository.Repository_Shoe;
import com.phase4.project.Repository.Repository_purchaseReport;
import com.phase4.project.service.ShoeService;

import lombok.NoArgsConstructor;
@NoArgsConstructor
@Service
public class ShoeImpl implements ShoeService{

	@Autowired
	private Repository_purchaseReport purchaseRepo;
	
	@Autowired
	private Repository_Shoe shoeRepo;
	
	@PostConstruct
	public void init() {
		Shoe s1 = new Shoe("Shoe Name 1","Basketball","1000.24");
		Shoe s2 = new Shoe("Shoe Name 2","Cricket","1100.24");
		Shoe s3 = new Shoe("Shoe Name 3","Running","900.24");
		Shoe s4 = new Shoe("Shoe Name 4","Football","1900.24");
		
		shoeRepo.save(s1);
		shoeRepo.save(s2);
		shoeRepo.save(s3);
		shoeRepo.save(s4);
		
		Date d = new Date(0);
		PurchaseReport pr1 = new PurchaseReport("user_1","Running",d,"adidas_runner:5,nike_airmax:10");
		PurchaseReport pr2 = new PurchaseReport("user_2","BDM",d,"adidas_cricket:5,nike_cricket:10");
		PurchaseReport pr3 = new PurchaseReport("user_3","Vintage",d,"adidas_basketball:5,nike_basketball:10");
		PurchaseReport pr4 = new PurchaseReport("user_4","SoccerBall",d,"adidas_football:5,nike_football:10");
		
		purchaseRepo.save(pr1);
		purchaseRepo.save(pr2);
		purchaseRepo.save(pr3);
		purchaseRepo.save(pr4);
	}

	public Shoe createShoe(Shoe shoe) throws BusinessException {
		int id=shoe.getId();
		Shoe newshoe=null;
		try {
			newshoe=shoeRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(newshoe!=null) throw new BusinessException("Shoe already exists");
		return shoeRepo.save(shoe);
	}

	
	public Shoe getShoebyId(int id) throws BusinessException {
		Shoe shoe=null;
		try {
			if(id<=0) throw new BusinessException("Id cannot be negative");
			shoe=shoeRepo.findById(id).get();
		}catch(NoSuchElementException e){
			throw new BusinessException("SHoe does not exist with id: "+id);
		}
		return shoe;
	}


	public Shoe updateShoe(Shoe shoe) {
		return shoeRepo.save(shoe);
	}

	
	public void deleteShoeById(int id) throws BusinessException {
		try {
			shoeRepo.deleteById(id);
		}catch(NoSuchElementException e) {
			throw new BusinessException("SHoe does not exist with id: "+id);
		}
		
	}

	
	public List<Shoe> getAllShoes() {
		return shoeRepo.findAll();
	}


	public PurchaseReport createPurchaseReport(PurchaseReport purchasereport) throws BusinessException {
		int id=purchasereport.getId();
		PurchaseReport old=null;
		try {
			old=purchaseRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(old!=null) throw new BusinessException("Purchase report already exists with id: "+id);
		return purchaseRepo.save(purchasereport);
	}

	
	public PurchaseReport getPurchaseReportbyId(int id) throws BusinessException {
		PurchaseReport p=null;
		try {
			if(id<=0)throw new BusinessException("Purchase Report id cannot be negative");
			p=purchaseRepo.findById(id).get();
			}catch(NoSuchElementException e){
				throw new BusinessException("Purchase report not found with Id"+id);
			}
		return p;
	}

	
	public PurchaseReport updatePurchaseReport(PurchaseReport purchasereport) {
		return purchaseRepo.save(purchasereport);
	}

	
	public void deletePurchaseReportById(int id) throws BusinessException {
		try {
			purchaseRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("Purchase Report does not exist with that Id"+id);
		}
		
	}

	
	public List<PurchaseReport> getAllPurchaseReports() {
		return purchaseRepo.findAll();
	}

	
	public List<PurchaseReport> getAllPurchaseReportsByDop(Date dop) {
		return purchaseRepo.findByDop(dop);
	}

	
	public List<PurchaseReport> getAllPurchaseReportsBrand(String brand) {
		return purchaseRepo.findByBrand(brand);
	}

}
