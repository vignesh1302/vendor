package com.cognizant.grizzlystore.service;

import com.cognizant.grizzlystore.dao.GalleryDao;
import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.model.ProductGallery;

public class GalleryService implements IGallery {
    GalleryDao dao=GalleryDao.getGalleryDao();
                @Override
                public int saveProductImages(ProductGallery productGallery)throws GrizzlyException {
                                // TODO Auto-generated method stub
                                return dao.saveProductImages(productGallery);
                }

                @Override
                public int deleteProductImages(int[] pid) throws GrizzlyException{
                                // TODO Auto-generated method stub
                                return dao.deleteProductImages(pid);
                }

}
