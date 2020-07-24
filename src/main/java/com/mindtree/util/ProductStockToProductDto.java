package com.mindtree.util;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.dto.ProductDto;
import com.mindtree.model.Apparal_Stock;
import com.mindtree.model.Book_Stock;
import com.mindtree.model.Product_Stock;

public class ProductStockToProductDto {

	public static List<ProductDto> convertProductStockToProductDto(List<Product_Stock> products) {
		
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		
		for(Product_Stock product:products) {
			
			ProductDto productDto = new ProductDto();
			
			productDto.setProductId(product.getProdId());
			productDto.setProductName(product.getProdName());
			productDto.setPrice(product.getPrice());
			
		if(product instanceof Book_Stock) {
			
			productDto.setProduct_type("Book");
			productDto.setGenre(((Book_Stock) product).getGenre());
			productDto.setAuthor(((Book_Stock) product).getAuthor());
			productDto.setPublications(((Book_Stock) product).getPublications());
			productDtos.add(productDto);
			
		} else if (product instanceof Apparal_Stock) {
			
			productDto.setProduct_type("Apparal");
			productDto.setApparal_type(((Apparal_Stock) product).getApparal_type());
			productDto.setBrand(((Apparal_Stock) product).getBrand());
			productDto.setDesign(((Apparal_Stock) product).getDesign());
			productDtos.add(productDto);
		}
		}
		return productDtos;	
	}
	
	
}
