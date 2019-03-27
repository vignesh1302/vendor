package com.cognizant.grizzlystore.model;

public class ProductBrands {
    private int brandId;
    private String brandName;
    public int getBrandId() {
           return brandId;
    }
    public void setBrandId(int brandId) {
           this.brandId = brandId;
    }
    public String getBrandName() {
           return brandName;
    }
    public void setBrandName(String brandName) {
           this.brandName = brandName;
    }
    @Override
    public int hashCode() {
           final int prime = 31;
           int result = 1;
           result = prime * result + brandId;
           result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
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
           ProductBrands other = (ProductBrands) obj;
           if (brandId != other.brandId)
                  return false;
           if (brandName == null) {
                  if (other.brandName != null)
                        return false;
           } else if (!brandName.equals(other.brandName))
                  return false;
           return true;
    }
    public ProductBrands() {
           super();
           // TODO Auto-generated constructor stub
    }
    public ProductBrands(int brandId, String brandName) {
           super();
           this.brandId = brandId;
           this.brandName = brandName;
    }
    @Override
    public String toString() {
           return "ProductBrands [brandId=" + brandId + ", brandName=" + brandName + "]";
    }
    
}

