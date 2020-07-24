package com.mindtree.util;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.dto.ProductDto;
import com.mindtree.entity.Apparal;
import com.mindtree.entity.Book;
import com.mindtree.entity.Product;

public class ProductToProductDto {

	public static ProductDto ConvertProductToProductDto(Product product) {
		
		ProductDto productDto = new ProductDto();
		
		productDto.setProductId(product.getProdId());
		productDto.setProductName(product.getProdName());
		productDto.setPrice(product.getPrice());
		productDto.setQuantity(product.getQuantity());
		
		if (product instanceof Book) {
			productDto.setPublications(((Book) product).getPublications());
			productDto.setAuthor(((Book) product).getPublications());
			productDto.setGenre(((Book) product).getGenre());
			productDto.setProduct_type("Book");

		} else if (product instanceof Apparal) {
			productDto.setApparal_type(((Apparal) product).getType());
			productDto.setDesign(((Apparal) product).getDesign());
			productDto.setBrand(((Apparal) product).getBrand());
			productDto.setProduct_type("Apparal");
		}
		return productDto;
	}
	
public static List<ProductDto> ConvertProductsToProductDtos(List<Product> products) {
		
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		
		for(Product product : products) {
			
		ProductDto productDto = new ProductDto();
		
		productDto.setProductId(product.getProdId());
		productDto.setProductName(product.getProdName());
		productDto.setPrice(product.getPrice());
		productDto.setQuantity(product.getQuantity());
		
		if (product instanceof Book) {
			productDto.setPublications(((Book) product).getPublications());
			productDto.setAuthor(((Book) product).getPublications());
			productDto.setGenre(((Book) product).getGenre());
			productDto.setProduct_type("Book");
			productDtos.add(productDto);

		} else if (product instanceof Apparal) {
			productDto.setApparal_type(((Apparal) product).getType());
			productDto.setDesign(((Apparal) product).getDesign());
			productDto.setBrand(((Apparal) product).getBrand());
			productDto.setProduct_type("Apparal");
			productDtos.add(productDto);
		}
		}
		return productDtos;
	}
	
}
