package com.mindtree.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable, Comparable<Cart> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL)
	private List<Product> products;
	
	@OneToOne(fetch=FetchType.LAZY)
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, List<Product> products) {
		super();
		this.cartId = cartId;
		this.products = products;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + "]";
	}	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart that = (Cart) o;
        return Objects.equals(getCartId(), that.getCartId()) &&
                Objects.equals(getProducts(), that.getProducts()) &&
                Objects.equals(getUser(), that.getUser());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getProducts(), getUser());
    }

	@Override
	public int compareTo(Cart arg0) {
		if(arg0.equals(this)){
			return 1;
		}
		return 0;
	}
	
}
