package com.cognizant.grizzlystore.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.grizzlystore.dao.GalleryDao;
import com.cognizant.grizzlystore.dao.ProductDao;
import com.cognizant.grizzlystore.dao.VendorDao;
import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.model.LoginDetails;
import com.cognizant.grizzlystore.model.ProductDetails;
import com.cognizant.grizzlystore.model.ProductGallery;
import com.cognizant.grizzlystore.model.VendorDetails;
import com.cognizant.grizzlystore.service.LoginService;
import com.cognizant.grizzlystore.service.ProductService;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

@Controller
public class LoginController {
	ProductService service=new ProductService();
	GalleryDao galleryservice=GalleryDao.getGalleryDao();
	ProductDao productDao=ProductDao.getProductDao();
	VendorDao vendorDao=VendorDao.getVendorDao();
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	String home()
	{
		return "login1";
	}
	
	
	
	@RequestMapping(value="/LoginController",method=RequestMethod.POST)
	public ModelAndView login(LoginDetails loginDetails,HttpServletRequest request)
	{
		ModelAndView modelAndView=null;
		
		LoginService service2=new LoginService();
		System.out.println(loginDetails);
		
		try {
			 int dblogin=service2.doLogin(loginDetails);
			 System.out.println(dblogin);
			 if(dblogin==0)
			 {
				 HttpSession session=request.getSession();
				 session.setAttribute("user", loginDetails);
				List<ProductDetails> list = service.getAllProductDetails("");
				System.out.println(list);
				modelAndView=new ModelAndView("list1");
				modelAndView.addObject("productList",list);
				 
			 }
			 else
			 {
					modelAndView=new ModelAndView("login1");
					modelAndView.addObject("error","username or password is wrong");
				 
			 }
			
		} catch (GrizzlyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	
@RequestMapping(value="/addProduct",method=RequestMethod.GET)	
String addProduct()
{
	return "add";
}
@RequestMapping(value="/saveproduct",method=RequestMethod.POST)
public ModelAndView addProduct(ProductDetails productDetails,ModelAndView modelAndView,String[] filenames)
{   
	
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<filenames.length;i++)
	{
		System.out.println(filenames[i]);
		sb.append(filenames[i]).append(",");
	}
	sb.deleteCharAt(sb.length()-1);
	
	productDetails.setImage(sb.toString());
	
	modelAndView.setViewName("success");
	if(productDetails!=null)
	{
		
		try {
			int count = service.saveProductDetails(productDetails);
			productDetails.setProductId(count);
			ProductGallery gallery=new ProductGallery(productDetails, productDetails.getImage());
			
			int count2=galleryservice.saveProductImages(gallery);
			System.out.println(count+" "+count2);
			
		
			if(count >0 && count2>0)
			{
				List<ProductDetails> list = service.getAllProductDetails("");
				System.out.println(list);
				modelAndView=new ModelAndView("list1");
				modelAndView.addObject("message","data is successfully added");
				modelAndView.addObject("productList",list);
		        System.out.println("save");
			}
			else
			{

	
				modelAndView.addObject("message","data is not successfully added");
				System.out.println("not save");
			}
		} catch (GrizzlyException e) {
			modelAndView.addObject("error",e.getMessage());
		}
		
	}
	return modelAndView;
}

@RequestMapping(value="/viewProduct1",params="Show",method=RequestMethod.POST)	
ModelAndView viewProductPage(String productId,ModelAndView modelAndView)
{
System.out.println(productId);	
	
	try {
		ProductDetails productDetails=service.getProductById(Integer.parseInt(productId));
	    if(productDetails!=null)
		{
	    	modelAndView.setViewName("view");
	    	
	    	modelAndView.addObject("product", productDetails);
			System.out.println("not available");
		}
		else
		{
			modelAndView.setViewName("success");
			modelAndView.addObject("message","Product is not available");
			System.out.println("available");
		}
		
		
		
		
	} catch (GrizzlyException e) {
		modelAndView.setViewName("success");
		modelAndView.addObject("error","error page");
	}
	
	
	
	return modelAndView;
}
@RequestMapping(value="/viewProduct1" , params="Finish",method=RequestMethod.POST)
ModelAndView finishShow(ModelAndView modelAndView)
{
	try {
		List<ProductDetails> list = service.getAllProductDetails("");
		System.out.println(list);
		modelAndView=new ModelAndView("list1");
		modelAndView.addObject("productList",list);
		modelAndView.addObject("message", "Saw the Product Details");
	} catch (GrizzlyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return modelAndView;
	
}



@RequestMapping(value="/viewProduct1",params="Block",method=RequestMethod.POST)
ModelAndView blockProudct(String[] productId,ModelAndView modelAndView)
{
	int cd[];
    cd=new int[productId.length];
	for (int i = 0; i < productId.length; i++) {
		cd[i]=Integer.parseInt(productId[i]);
		
	}
	try {
		if(cd!=null)
		{
			int count=productDao.updateProductDetails(cd, "block");
			if(count>0) {
				
				List<ProductDetails> list = service.getAllProductDetails("");
				System.out.println(list);
				modelAndView=new ModelAndView("list1");
				modelAndView.addObject("message","successsfully Blocked");
				modelAndView.addObject("productList",list);
				System.out.println("updated to block");
			}	else {
				modelAndView.setViewName("success");
				modelAndView.addObject("message", "Product not updated to block");
				System.out.println("not updatd to block");
			}
		}
		
		
	} catch (GrizzlyException e) {
		modelAndView.setViewName("success");
		modelAndView.addObject("error","error page");
	}

return modelAndView;
}
@RequestMapping(value="/viewProduct1",params="Remove",method=RequestMethod.POST)
ModelAndView deleteProduct(String[] productId,ModelAndView modelAndView)
{
	ProductDao dao=ProductDao.getProductDao();
	GalleryDao dao2=GalleryDao.getGalleryDao();
	int pidd[];
	
	pidd=new int[productId.length];
	for (int i = 0; i < productId.length; i++) {
		pidd[i]=Integer.parseInt(productId[i]);
		
	}
	
	try {
	int count=dao.deleteProductDetails(pidd);
	int count1=	dao2.deleteProductImages(pidd);
	
	if(count>0 && count1>0) {
		

		List<ProductDetails> list = service.getAllProductDetails("");
		System.out.println(list);
		modelAndView=new ModelAndView("list1");
		modelAndView.addObject("message","successsfully Deleted");
		modelAndView.addObject("productList",list);
		System.out.println("removed product and its gallery");
	}	else {
		modelAndView.setViewName("success");
		modelAndView.addObject("message", "Not removed product and its gallery");
		System.out.println("not removes product and gallery");
	}
	
	
		
	} catch (GrizzlyException e) {
		// TODO Auto-generated catch block	
		modelAndView.setViewName("success");
		modelAndView.addObject("error","error page");
	}
	
return modelAndView;
}
@RequestMapping(value="/viewProduct1" , params="Back",method=RequestMethod.POST)
ModelAndView backPage(ModelAndView modelAndView)
{
	try {
		List<ProductDetails> list = service.getAllProductDetails("");
		System.out.println(list);
		modelAndView=new ModelAndView("list1");
		modelAndView.addObject("productList",list);
	} catch (GrizzlyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return modelAndView;
	
}


@RequestMapping(value="/vendorProduct",method=RequestMethod.POST)
public ModelAndView vendor(LoginDetails loginDetails,HttpServletRequest request)
{
	ModelAndView modelAndView=null;
	LoginService service2=new LoginService();
	System.out.println(loginDetails);
	
	try {
			List<ProductDetails> list = vendorDao.getVendortDetails("");
			System.out.println(list);
			modelAndView=new ModelAndView("vendor");
			modelAndView.addObject("productList",list);
		
	} catch (GrizzlyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return modelAndView;
}


@RequestMapping(value="/updateQuantity",method=RequestMethod.POST)
ModelAndView vendorPage(String productId,String quantity,ModelAndView modelAndView)
{
	
	System.out.println("updateQuantity");
	
	System.out.println("Ima");
	System.out.println(productId);
	
	int y=Integer.parseInt(quantity.replaceAll(",", ""));
System.out.println(quantity.replaceAll(",", ""));

	
	try {
		
int count=	vendorDao.updateQuantity(Integer.parseInt(productId),y);
			if(count>0)
			{
				modelAndView=new ModelAndView("vendor");
				modelAndView.addObject("message","successsfully updated");
				modelAndView.addObject("productList",quantity);
			}
			else
			{
				modelAndView=new ModelAndView("success");
				modelAndView.addObject("message", "Not updated");
				System.out.println("not updated in vendor");
			}
		
	} catch (GrizzlyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return modelAndView;
}


}