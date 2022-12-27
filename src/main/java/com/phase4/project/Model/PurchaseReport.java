package com.phase4.project.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="PurchaseReport")
@ToString
public class PurchaseReport {
	@Id
	@GeneratedValue
	private int id;
	private String PurchaserName;
	private String brand;
	@Temporal(TemporalType.DATE)
	private Date dop;
	String orderlist;
	public PurchaseReport(String purchaserName, String brand, Date dop, String orderlist) {
		super();
		PurchaserName = purchaserName;
		this.brand = brand;
		this.dop = dop;
		this.orderlist = orderlist;
	}
	
}
