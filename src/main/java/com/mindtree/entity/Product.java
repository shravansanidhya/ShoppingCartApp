package com.mindtree.entity;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type")
public class Product implements Serializable, Comparable<Product>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serialNo;
	protected int prodId;
	protected String prodName;
	protected float price;
	protected int quantity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	protected Cart cart;
	
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int prodId, String prodName, float price, int quantity) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName
				+ ", price=" + price + ", quantity=" + quantity  + "]";
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product that = (Product) o;
        return Objects.equals(getProdId(), that.getProdId()) &&
                Objects.equals(getProdName(), that.getProdName()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getQuantity(), that.getQuantity()) &&
                Objects.equals(getCart(), that.getCart());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getProdId(), getProdName(), getPrice(),getQuantity(),getCart());
    }

	@Override
	public int compareTo(Product arg0) {
		if(arg0.equals(this)){
			return 1;
		}
		return 0;
	}
	
	
}
