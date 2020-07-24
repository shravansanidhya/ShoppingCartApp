package com.mindtree.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.model.Product_Stock;

@Repository
public interface ProductStockDao extends JpaRepository<Product_Stock, Object>{

	@Query("select p from Product_Stock p where p.prodId=:id")
	public Product_Stock findProductById(int id);
	
	@Query("select p from Product_Stock p where p.prodName=:pname")
	public Product_Stock findProductByName(String pname);
	
	
}
