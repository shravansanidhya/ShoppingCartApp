package com.mindtree.dto;

public class ProductDto {

	private int productId;
	private String productName;
	private float price;
	private String product_type;
	private int quantity;
	private String author;
	private String genre;
	private String publications;
	private String brand;
	private String apparal_type;
	private String Design;
	
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int productId, String productName, float price,
			String product_type, int quantity, String author, String genre,
			String publications, String brand, String apparal_type,
			String design) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.product_type = product_type;
		this.quantity = quantity;
		this.author = author;
		this.genre = genre;
		this.publications = publications;
		this.brand = brand;
		this.apparal_type = apparal_type;
		Design = design;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getApparal_type() {
		return apparal_type;
	}

	public void setApparal_type(String apparal_type) {
		this.apparal_type = apparal_type;
	}

	public String getDesign() {
		return Design;
	}

	public void setDesign(String design) {
		Design = design;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName="
				+ productName + ", price=" + price + ", product_type="
				+ product_type + ", quantity=" + quantity + ", author="
				+ author + ", genre=" + genre + ", publications="
				+ publications + ", brand=" + brand + ", apparal_type="
				+ apparal_type + ", Design=" + Design + "]";
	}
	
	
	
	
	
}
