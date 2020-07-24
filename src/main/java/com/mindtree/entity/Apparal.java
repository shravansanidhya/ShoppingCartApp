package com.mindtree.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Apparal")
public class Apparal extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String brand;
	private String design;
	
	
	public Apparal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Apparal(int prodId, String prodName, float price, int quantity) {
		super(prodId, prodName, price, quantity);
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}

}
