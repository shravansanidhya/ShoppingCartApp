package com.mindtree.service;

import java.util.List;


import com.mindtree.dto.ProductDto;
import com.mindtree.model.Product_Stock;

public interface ProductStockService {

	public String addProductIntoStock(ProductDto productDto);
	
	public String addProductsIntoStock(List<ProductDto> productDto);
	
	public List<ProductDto> getAllProducts();
	
	public Product_Stock searchProductById(int pid);

	public Product_Stock searchProductByName(String pname);
	
}
