package com.mindtree.util;

import com.mindtree.entity.Apparal;
import com.mindtree.entity.Book;
import com.mindtree.entity.Product;
import com.mindtree.model.Apparal_Stock;
import com.mindtree.model.Book_Stock;
import com.mindtree.model.Product_Stock;

public class ProductStockToProduct {
	
public static Product convertProductStockToProduct(Product_Stock product_stock) {
		
		    Product product = new Product();
			
		if(product_stock instanceof Book_Stock) {
			Book book = new Book();
			book.setProdId(product_stock.getProdId());
			book.setProdName(product_stock.getProdName());
			book.setPrice(product_stock.getPrice());
			book.setQuantity(1);
			book.setAuthor(((Book_Stock) product_stock).getAuthor());
			book.setGenre(((Book_Stock) product_stock).getGenre());
			book.setPublications(((Book_Stock) product_stock).getPublications());
			product=book;
			
		} else if (product_stock instanceof Apparal_Stock) {
			
			Apparal apparal = new Apparal();
			apparal.setProdId(product_stock.getProdId());
			apparal.setProdName(product_stock.getProdName());
			apparal.setPrice(product_stock.getPrice());
			apparal.setQuantity(1);
			apparal.setBrand(((Apparal_Stock) product_stock).getBrand());
			apparal.setDesign(((Apparal_Stock) product_stock).getDesign());
			apparal.setType(((Apparal_Stock) product_stock).getType());
			product=apparal;
			
		}
		return product;	
	}
}
