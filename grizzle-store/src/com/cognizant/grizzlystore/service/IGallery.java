package com.cognizant.grizzlystore.service;

import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.model.ProductGallery;

public interface IGallery {
                
                public int saveProductImages(ProductGallery productGallery)throws GrizzlyException;
                public int deleteProductImages(int []pid)throws GrizzlyException;

}

