package com.mindtree.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.cart.cartId=:id")
	public List<Product> findProductsByCartId(int id);
	
	@Transactional
	@Modifying
	@Query("delete Product p where p.prodId=:pid and p.cart.cartId=:cid")
	public void DeleteProductsFromCart(int pid,int cid);
	
	@Query("select p from Product p where p.prodId=:pid and p.cart.cartId=:cid")
	public Product findProductFromCart(int pid,int cid);
	
	@Transactional
	@Modifying
	@Query("UPDATE Product p set p.quantity = ?1 , p.price=?2 where p.prodId=?3 and p.cart.cartId=?4")
	public void updateProductInCart(int quantity,float price, int pid, int cid);
	
	@Query("select sum(p.price) from Product p where p.cart.cartId=:cid")
	public float getTotalPrice(int cid);
	
}
