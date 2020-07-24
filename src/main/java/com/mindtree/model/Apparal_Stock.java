package com.mindtree.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Apparal_Stock")
public class Apparal_Stock extends Product_Stock{

	private String apparal_type;
	private String brand;
	private String design;
	
	public Apparal_Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Apparal_Stock(String apparal_type, String brand, String design) {
		super();
		this.apparal_type = apparal_type;
		this.brand = brand;
		this.design = design;
	}

	public String getApparal_type() {
		return apparal_type;
	}

	public void setApparal_type(String apparal_type) {
		this.apparal_type = apparal_type;
	}

	public String getType() {
		return apparal_type;
	}
	public void setType(String type) {
		this.apparal_type = type;
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
	@Override
	public String toString() {
		return "Apparal_Stock [apparal_type=" + apparal_type + ", brand="
				+ brand + ", design=" + design + "]";
	}
	
	
	
	
}
