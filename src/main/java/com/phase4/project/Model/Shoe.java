package com.phase4.project.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name="Shoe")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Shoe {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String brand;
	private String Price;
	public Shoe(String name, String brand, String price) {
		super();
		this.name = name;
		this.brand = brand;
		Price = price;
	}
	
	
}
