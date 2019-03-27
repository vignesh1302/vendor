package com.cognizant.grizzlystore.model;

public class ProductDetails {
    
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private double productRating;
    private String productAvailability;
    private ProductBrands productBrands;
    private ProductCategory productCategory;
    String image;
    private VendorDetails vendorDetails;
    
    
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getProductRating() {
		return productRating;
	}
	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}
	public String getProductAvailability() {
		return productAvailability;
	}
	public void setProductAvailability(String productAvailability) {
		this.productAvailability = productAvailability;
	}
	public ProductBrands getProductBrands() {
		return productBrands;
	}
	public void setProductBrands(ProductBrands productBrands) {
		this.productBrands = productBrands;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public VendorDetails getVendorDetails() {
		return vendorDetails;
	}
	public void setVendorDetails(VendorDetails vendorDetails) {
		this.vendorDetails = vendorDetails;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((productAvailability == null) ? 0 : productAvailability.hashCode());
		result = prime * result + ((productBrands == null) ? 0 : productBrands.hashCode());
		result = prime * result + ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(productRating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vendorDetails == null) ? 0 : vendorDetails.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDetails other = (ProductDetails) obj;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (productAvailability == null) {
			if (other.productAvailability != null)
				return false;
		} else if (!productAvailability.equals(other.productAvailability))
			return false;
		if (productBrands == null) {
			if (other.productBrands != null)
				return false;
		} else if (!productBrands.equals(other.productBrands))
			return false;
		if (productCategory == null) {
			if (other.productCategory != null)
				return false;
		} else if (!productCategory.equals(other.productCategory))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		if (Double.doubleToLongBits(productRating) != Double.doubleToLongBits(other.productRating))
			return false;
		if (vendorDetails == null) {
			if (other.vendorDetails != null)
				return false;
		} else if (!vendorDetails.equals(other.vendorDetails))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductDetails [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productRating=" + productRating
				+ ", productAvailability=" + productAvailability + ", productBrands=" + productBrands
				+ ", productCategory=" + productCategory + ", image=" + image + ", vendorDetails=" + vendorDetails
				+ "]";
	}
	public ProductDetails(int productId, String productName, String productDescription, double productPrice,
			double productRating, String productAvailability, ProductBrands productBrands,
			ProductCategory productCategory, String image, VendorDetails vendorDetails) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productRating = productRating;
		this.productAvailability = productAvailability;
		this.productBrands = productBrands;
		this.productCategory = productCategory;
		this.image = image;
		this.vendorDetails = vendorDetails;
	}
	
   
  
   
}

