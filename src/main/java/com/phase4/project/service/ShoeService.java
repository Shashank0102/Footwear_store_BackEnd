package com.phase4.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.phase4.project.ExceptionHandling.BusinessException;
import com.phase4.project.Model.PurchaseReport;
import com.phase4.project.Model.Shoe;
@Service
public interface ShoeService {

	public Shoe createShoe(Shoe shoe) throws BusinessException;
	public Shoe getShoebyId(int id) throws BusinessException;
	public Shoe updateShoe(Shoe shoe);
	public void deleteShoeById(int id) throws BusinessException; 
	public List<Shoe> getAllShoes();
	
	public PurchaseReport createPurchaseReport(PurchaseReport purchasereport)throws BusinessException ;
	public PurchaseReport getPurchaseReportbyId(int id)throws BusinessException ;
	public PurchaseReport updatePurchaseReport(PurchaseReport purchasereport);
	public void deletePurchaseReportById(int id)throws BusinessException ;
	public List<PurchaseReport> getAllPurchaseReports();
	public List<PurchaseReport> getAllPurchaseReportsByDop(Date dop);
	public List<PurchaseReport> getAllPurchaseReportsBrand(String brand);
	
}
