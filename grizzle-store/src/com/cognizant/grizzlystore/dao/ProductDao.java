package com.cognizant.grizzlystore.dao;

                import java.sql.Connection;
                import java.sql.PreparedStatement;
                import java.sql.ResultSet;
                import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
                import java.util.List;

import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.exception.IgrizzlyException;
//import com.cognizant.grizzle.util.ConnectionUtil;
import com.cognizant.grizzlystore.model.ProductBrands;
import com.cognizant.grizzlystore.model.ProductCategory;
import com.cognizant.grizzlystore.model.ProductDetails;
import com.cognizant.grizzlystore.model.VendorDetails;
import com.cognizant.grizzlystore.util.ConnectionUtil;

public class ProductDao {
                private static ProductDao productDao;
private ProductDao() {
                // TODO Auto-generated constructor stub
}
public static ProductDao getProductDao()
{
                if(productDao==null)
                {
                                productDao=new ProductDao();
                }
                return productDao;
}

public List<ProductDetails> getProductDetails(String filter) throws GrizzlyException
{
                List<ProductDetails> list=new ArrayList<>();
                Connection connObj=null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                String query="select pr.*,br.*,cr.*, pg.*,v.* from product pr join product_category cr join product_brand br join product_gallery pg join vendor v on pr.pr_br_fk=br.br_id and cr.ct_id=pr.pr_ct_fk and pg.pr_id_fk=pr.pr_id and pr.pr_id=v.vr_id where pr_availability='available'; " + 
                                                "";
                try
                {   
                                connObj=ConnectionUtil.getConnection();
                                if(connObj==null)
                                {
                                System.out.println("not Got connection");
                                }
                else {
                                System.out.println("Got Connected");
                }
                if(filter==null || filter.isEmpty() || filter=="") {
                
                }else {
                                
                                query+=" and pr.pr_id in "+"("+filter+")";
                                System.out.println(query);
                }              
                                
                                
preparedStatement = connObj.prepareStatement(query);

 
                
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next())
                {              
                                int productId=resultSet.getInt("pr_id");
                                String productName =resultSet.getString("pr_name");
                    String productDescription =resultSet.getString("pr_description");
                     double productPrice=resultSet.getDouble("pr_price");
                    double productRating=resultSet.getDouble("pr_rating");
                   
                    String brandName=resultSet.getString("br_name");
                                int brandId=resultSet.getInt("br_id");
                                int categoryId=resultSet.getInt("ct_id");
                                
                  
                                String categoryName=resultSet.getString("ct_name");
                                ProductCategory productCategory=new ProductCategory(categoryId, categoryName);
                                  ProductBrands productBrands=new ProductBrands(brandId, brandName);
                                                                    
                                String listImages =resultSet.getString("pr_img_name");
                                
                                   String availability=resultSet.getString("pr_availability");

       
                                   int quantity=resultSet.getInt("quantity");
                                   VendorDetails vendorDetails=new VendorDetails(1, productId, quantity);
                                   
                                   
                                   ProductDetails details=new ProductDetails(productId, productName, productDescription, productPrice, productRating, availability, productBrands, productCategory,listImages,vendorDetails);
       
                                list.add(details);
                }
                }
                catch(ClassNotFoundException classNotFoundException)
                {
                                classNotFoundException.printStackTrace();
                                
                                throw new GrizzlyException(IgrizzlyException.DRIVER_MISSING_ERROR);
                }
                catch(SQLException sqlException)
                {
                                sqlException.printStackTrace();
                                
                                throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
                }
                catch(Exception e)
                {
                                e.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
                                }
                     finally {
                                                try {
                                                if(resultSet!=null)
                                                                resultSet.close();
                                                if(preparedStatement!=null)
                                                                preparedStatement.close();
                                                if(connObj!=null)
                                                                connObj.close();
                                                }catch(SQLException exception) {
                                                exception.printStackTrace();
                                                throw new GrizzlyException(IgrizzlyException.CLOSING_RESOURCE_ERROR);
                                                
                                }
}
                return list;
}




public ProductDetails getProductDetailsById(int pid) throws GrizzlyException
{
ProductDetails details=null;
                Connection connObj=null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                String query="select pr.*,br.*,cr.*, pg.*,v.* from product pr join product_category cr  join product_brand br join product_gallery pg join v on pr.pr_br_fk=br.br_id and cr.ct_id=pr.pr_ct_fk and pg.pr_id_fk=pr.pr_id pr.pr_id=v.pr_id_fk where pr.pr_id=?\r\n" + 
                                                "";
                try
                {   
                                connObj=ConnectionUtil.getConnection();
                                if(connObj==null)
                                {
                                System.out.println("not Got connection");
                                }
                else {
                                System.out.println("Got Connected");
                }
                                
preparedStatement = connObj.prepareStatement(query);
preparedStatement.setInt(1, pid);

                
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {              
                                int productId=resultSet.getInt("pr_id");
                                String productName =resultSet.getString("pr_name");
                    String productDescription =resultSet.getString("pr_description");
                     double productPrice=resultSet.getDouble("pr_price");
                    double productRating=resultSet.getDouble("pr_rating");
                   
                    String brandName=resultSet.getString("br_name");
                                int brandId=resultSet.getInt("br_id");
                                int categoryId=resultSet.getInt("ct_id");
                                
                  
                                String categoryName=resultSet.getString("ct_name");
                                ProductCategory productCategory=new ProductCategory(categoryId, categoryName);
                                  ProductBrands productBrands=new ProductBrands(brandId, brandName);
                                                                    
                                String listImages =resultSet.getString("pr_img_name");
                                
                                  String availability=resultSet.getString("pr_availability");
                                  int quantity=resultSet.getInt("quantity");
                                   VendorDetails vendorDetails=new VendorDetails(1, productId, quantity);
                                   details=new ProductDetails(productId, productName, productDescription, productPrice, productRating, availability, productBrands, productCategory,listImages,vendorDetails);
                                   
                }
                
                }
                catch(ClassNotFoundException classNotFoundException)
                {
                                classNotFoundException.printStackTrace();
                                //classNotFoundException.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.DRIVER_MISSING_ERROR);
                }
                catch(SQLException sqlException)
                {
                                sqlException.printStackTrace();
                                //classNotFoundException.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
                }
                catch(Exception e)
                {
                                e.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
                                }
                     finally {
                                                try {
                                                if(resultSet!=null)
                                                                resultSet.close();
                                                if(preparedStatement!=null)
                                                                preparedStatement.close();
                                                if(connObj!=null)
                                                                connObj.close();
                                                }catch(SQLException exception) {
                                                exception.printStackTrace();
                                                throw new GrizzlyException(IgrizzlyException.CLOSING_RESOURCE_ERROR);
                                                
                                }
}
                return details ;
}

public int saveProductDetails(ProductDetails productDetails) throws GrizzlyException {

                Connection connObj=null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                int empId = 0;

                String query = "insert into product(pr_name, pr_description, pr_price, pr_rating, pr_br_fk  ,pr_ct_fk  ,pr_availability) values(?,?,?,?,?,?,?)\r\n" ;
                try {
                                connObj=ConnectionUtil.getConnection();
                                if (connObj == null) {
                                                System.out.println("not Got connection");
                                } else {
                                                System.out.println("Got Connected");
                                }
                                preparedStatement = connObj.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                                preparedStatement.setString(1, productDetails.getProductName());
                                preparedStatement.setString(2, productDetails.getProductDescription());
                                preparedStatement.setDouble(3, productDetails.getProductPrice());
                                preparedStatement.setDouble(4, productDetails.getProductRating());
                                preparedStatement.setInt(5, productDetails.getProductBrands().getBrandId());
                                preparedStatement.setInt(6, productDetails.getProductCategory().getCategoryId());
                                preparedStatement.setString(7, "available");
                                preparedStatement.setInt(8, productDetails.getVendorDetails().getVendorId());
                
                                int count = preparedStatement.executeUpdate();

                                resultSet = preparedStatement.getGeneratedKeys();
                                if (resultSet.next()) {
                                                empId = resultSet.getInt(1);
                                }

                                if (count >= 1) {
                                                System.out.println("Product is save");
                                } else {

                                                throw new GrizzlyException("Product is not saved some internal error");
                                }


                } catch (SQLException sqlException) {
                                sqlException.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
                } catch (Exception e) {
                                e.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
                } finally {
                                try {
                                                if(resultSet!=null)
                                                                resultSet.close();
                                                if(preparedStatement!=null)
                                                                preparedStatement.close();
                                                if(connObj!=null)
                                                                connObj.close();
                                                }
                                catch (SQLException e2) {
                                                throw new GrizzlyException(IgrizzlyException.CLOSING_RESOURCE_ERROR);
                                                
                                }
                }

                return empId;
}
public int deleteProductDetails(int []pid) throws GrizzlyException {

                Connection connObj=null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                int count = 0;
                String query = "delete from product  where pr_id in" ;
                try {
                                connObj=ConnectionUtil.getConnection();
                                if (connObj == null) {
                                                System.out.println("not Got connection");
                                } else {
                                                System.out.println("Got Connected");
                                }
                                
                                
                                StringBuffer sb=new StringBuffer();
                                
                                for (int i = 0; i < pid.length; i++) {
                                                sb.append(pid[i]+",");
                                }
                                sb.deleteCharAt(sb.length()-1);
                                
                                System.out.println(sb);
                                query+="("+sb.toString()+")";
                System.out.println(query);
                preparedStatement = connObj.prepareStatement(query);

                                count = preparedStatement.executeUpdate();

                                

                                if (count >= 1) {
                                                System.out.println("Product is deleted"+count);
                                } else {

                                                throw new GrizzlyException("Product is not deleted some internal error");
                                }


                } catch (SQLException sqlException) {
                                sqlException.printStackTrace();
                                // classNotFoundException.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
                } catch (Exception e) {
                                e.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
                } finally {
                                try {
                                                if(resultSet!=null)
                                                                resultSet.close();
                                                if(preparedStatement!=null)
                                                                preparedStatement.close();
                                                if(connObj!=null)
                                                                connObj.close();
                                                }
                                catch (SQLException e2) {
                                                throw new GrizzlyException(IgrizzlyException.CLOSING_RESOURCE_ERROR);
                                                
                                }
                                
                
                }

                return count;
}
public int updateProductDetails(int []pid,String status) throws GrizzlyException {

                Connection connObj=null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                int count = 0;

                String query = "update product set pr_availability=? where pr_id in " ;
                try {
                                connObj=ConnectionUtil.getConnection();
                                if (connObj == null) {
                                                System.out.println("not Got connection");
                                } else {
                                                System.out.println("Got Connected");
                                }
       StringBuffer sb=new StringBuffer();
                                
                                for (int i = 0; i < pid.length; i++) {
                                                sb.append(pid[i]+",");
                                }
                                sb.deleteCharAt(sb.length()-1);
                                
                                System.out.println(sb);
                                String s=sb.toString();
                                query+="("+s+")";
                                System.out.println(s);
                                System.out.println(query);
                                preparedStatement = connObj.prepareStatement(query);

                                preparedStatement.setString(1, status);
                
                                count = preparedStatement.executeUpdate();

                                

                                if (count >= 1) {
                                                System.out.println("Product is updated"+count);
                                } else {

                                                throw new GrizzlyException("Product is not updated Error");
                                }

                } catch (SQLException sqlException) {
                                sqlException.printStackTrace();
                                // classNotFoundException.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
                } catch (Exception e) {
                                e.printStackTrace();
                                throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
                } finally {
                                try {
                                                if(resultSet!=null)
                                                                resultSet.close();
                                                if(preparedStatement!=null)
                                                                preparedStatement.close();
                                                if(connObj!=null)
                                                                connObj.close();
                                                }
                                catch (SQLException e2) {
                                                throw new GrizzlyException(IgrizzlyException.CLOSING_RESOURCE_ERROR);
                                                
                                }
                                

                }

                return count;
}
                   
                }
                

