package com.mindtree.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.ProductStockDao;
import com.mindtree.dto.ProductDto;
import com.mindtree.model.Apparal_Stock;
import com.mindtree.model.Book_Stock;
import com.mindtree.model.Product_Stock;
import com.mindtree.service.ProductStockService;
import com.mindtree.util.ProductStockToProductDto;

@Service
public class ProductStockServiceImpl implements ProductStockService{

	@Autowired
	private ProductStockDao ProductStockDao;
	
	@Override
	public String addProductIntoStock(ProductDto productDto) {
		
		if(productDto.getProduct_type().equalsIgnoreCase("Book")) {
			
			Book_Stock book = new Book_Stock();
			
			book.setProdId(productDto.getProductId());
			book.setProdName(productDto.getProductName());
			book.setPrice(productDto.getPrice());
			book.setGenre(productDto.getGenre());
			book.setAuthor(productDto.getAuthor());
			book.setPublications(productDto.getPublications());
			
			this.ProductStockDao.save(book);
			
		} else if (productDto.getProduct_type().equalsIgnoreCase("Apparal")) {
			
			Apparal_Stock apparal = new Apparal_Stock();
			
			apparal.setProdId(productDto.getProductId());
			apparal.setProdName(productDto.getProductName());
			apparal.setPrice(productDto.getPrice());
			apparal.setBrand(productDto.getBrand());
			apparal.setDesign(productDto.getDesign());
			apparal.setType(productDto.getApparal_type());
			
			this.ProductStockDao.save(apparal);
		}
		return "Added Successfully";
	}
	
	public String addProductsIntoStock(List<ProductDto> productDtos) {

		//Product_Stock product = new Product_Stock();
		for(ProductDto productDto:productDtos) {
			
			Product_Stock product = new Product_Stock();
			
			product.setProdId(productDto.getProductId());
			product.setProdName(productDto.getProductName());
			product.setPrice(productDto.getPrice());
			
		if(productDto.getProduct_type().equalsIgnoreCase("Book")) {
			
			Book_Stock book = new Book_Stock();
			
			book.setProdId(productDto.getProductId());
			book.setProdName(productDto.getProductName());
			book.setPrice(productDto.getPrice());
			book.setGenre(productDto.getGenre());
			book.setAuthor(productDto.getAuthor());
			book.setPublications(productDto.getPublications());
			product = book;
			this.ProductStockDao.save(product);
			
		} else if (productDto.getProduct_type().equalsIgnoreCase("Apparal")) {
			
			Apparal_Stock apparal = new Apparal_Stock();
			
			apparal.setProdId(productDto.getProductId());
			apparal.setProdName(productDto.getProductName());
			apparal.setPrice(productDto.getPrice());
			apparal.setBrand(productDto.getBrand());
			apparal.setDesign(productDto.getDesign());
			apparal.setType(productDto.getApparal_type());
			product=apparal;
			this.ProductStockDao.save(product);
		}
	}
		return "Added Successfully";
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto> productList = ProductStockToProductDto.convertProductStockToProductDto(this.ProductStockDao.findAll());
		return productList;
	}

	@Override
	public Product_Stock searchProductById(int pid) {
       Product_Stock product =  this.ProductStockDao.findProductById(pid);
       return product;
	}

	@Override
	public Product_Stock searchProductByName(String pname) {
		Product_Stock product = this.ProductStockDao.findProductByName(pname);
		return product;
	}
}
