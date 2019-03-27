package com.cognizant.grizzlystore.model;

public class VendorDetails {
               
                private int vendorId;
                private int prId;
                private int quantity;
				public int getVendorId() {
					return vendorId;
				}
				public void setVendorId(int vendorId) {
					this.vendorId = vendorId;
				}
				public int getPrId() {
					return prId;
				}
				public void setPrId(int prId) {
					this.prId = prId;
				}
				public int getQuantity() {
					return quantity;
				}
				public void setQuantity(int quantity) {
					this.quantity = quantity;
				}
				public VendorDetails(int vendorId, int prId, int quantity) {
					super();
					this.vendorId = vendorId;
					this.prId = prId;
					this.quantity = quantity;
				}
				@Override
				public String toString() {
					return "VendorDetails [vendorId=" + vendorId + ", prId=" + prId + ", quantity=" + quantity + "]";
				}
				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + prId;
					result = prime * result + quantity;
					result = prime * result + vendorId;
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
					VendorDetails other = (VendorDetails) obj;
					if (prId != other.prId)
						return false;
					if (quantity != other.quantity)
						return false;
					if (vendorId != other.vendorId)
						return false;
					return true;
				}
}
