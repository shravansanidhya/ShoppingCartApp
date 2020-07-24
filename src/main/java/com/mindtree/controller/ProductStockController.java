package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.dto.ProductDto;
import com.mindtree.model.Product_Stock;
import com.mindtree.service.ProductStockService;

@RestController
@CrossOrigin("*")
@RequestMapping("/stock")
public class ProductStockController {

	@Autowired
	private ProductStockService service;
	
	@PostMapping("/addProduct")
	public String addProductIntoStock(@RequestBody ProductDto productDto) {
		
		String msg = this.service.addProductIntoStock(productDto);
		
		return msg;
		
	}
	
	@PostMapping("/addProducts")
	public String addProductsIntoStock(@RequestBody List<ProductDto> productDtos) {
		
		String msg = this.service.addProductsIntoStock(productDtos);
		
		return msg;
		
	}
	@GetMapping("/getAllProducts")
	public List<ProductDto> getAllProducts() {
		
		return this.service.getAllProducts();
		
	}
	@GetMapping("/searchById/{pid}")
	public Product_Stock searchProductById(@PathVariable int pid) {
		
		return this.service.searchProductById(pid);
		
	}
	
	@GetMapping("/searchByName/{pname}")
	public Product_Stock searchProductByName(@PathVariable String pname) {
		return this.service.searchProductByName(pname);
	}
	
	
}
