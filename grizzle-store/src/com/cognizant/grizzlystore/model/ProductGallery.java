package com.cognizant.grizzlystore.model;

public class ProductGallery {
	public ProductGallery() {
		// TODO Auto-generated constructor stub
	}

	ProductDetails productDetails;
	String image;
	public ProductDetails getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	public String getimage() {
		return image;
	}
	public void setimage(String image) {
		this.image = image;
	}
	public ProductGallery(ProductDetails productDetails, String image) {
		super();
		this.productDetails = productDetails;
		this.image = image;
	}
	@Override
	public String toString() {
		return "ProductGallery [productDetails=" + productDetails + ", image=" + image + "]";
	}
	
	
}
 