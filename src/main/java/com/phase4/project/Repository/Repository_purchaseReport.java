package com.phase4.project.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase4.project.Model.PurchaseReport;
@Repository
public interface Repository_purchaseReport extends JpaRepository<PurchaseReport,Integer>{

	public List<PurchaseReport> findByDop(Date dop);
	public List<PurchaseReport> findByBrand(String brand);
}
