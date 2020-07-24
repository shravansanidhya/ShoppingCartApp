package com.mindtree.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable,Comparable<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	private String userName;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Cart cart;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String userName, Cart cart) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.cart = cart;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", cart=" + cart + "]";
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User that = (User) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getUserName(), that.getUserName()) &&
                Objects.equals(getCart(), that.getCart());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserName(), getCart());
    }

	@Override
	public int compareTo(User arg0) {
		if(arg0.equals(this)){
			return 1;
		}
		return 0;
	}
	
	
}
