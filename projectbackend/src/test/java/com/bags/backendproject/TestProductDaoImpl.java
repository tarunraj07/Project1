package com.bags.backendproject;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bags.dao.ProductDao;
import com.bags.model.Product;

public class TestProductDaoImpl {
	static ProductDao productDao;
	
	@BeforeClass
	public static void executeFist() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.bags");
		context.refresh();
		productDao=(ProductDao) context.getBean("productDaoImpl");
	}
	
	/*Add a product*/
	@Ignore
	@Test
	public void addProduct() {
		Product prod=new Product();
		prod.setProductname("Spring MVC");
		prod.setDescription("Introduction to Spring MVC");
		prod.setQuantity(5);
		prod.setPrice(500);
		assertTrue("Problem in inserting a product",productDao.saveProduct(prod));
	}
	
	/*Display a all product*/
	@Ignore
	@Test
	public void getAllProducts() {
		List<Product> prod=productDao.getAllProduct();
		for(Product product:prod)
			System.out.println(product.getId()+" "+product.getProductname()+" "+product.getDescription()+" "+product.getQuantity()+" "+product.getPrice());
	}
	
	/*Display product by id*/
	/*@Ignore
	@Test
	public void getProduct() {
		Product product=productDao.getId(1);
		for(Product p:product)
			System.out.println(p.getId()+" "+p.getProductname()+" "+p.getDescription()+" "+p.getQuantity()+" "+p.getPrice());
	}*/
	
	/*Delete a product*/
	@Ignore
	@Test
	public void deleteProduct() {
		assertTrue("Problem in deleting prodcution",productDao.deleteProduct(3));	
	}
	
	/*Update a product*/
	@Test
	public void updateProduct() {
		Product prod=new Product();
		prod.setId(5);
		prod.setProductname("Hibernate");
		prod.setDescription("Introduction to hibernate");
		prod.setPrice(500);
		prod.setQuantity(15);
		assertTrue("Problem in updation a product",productDao.updateProduct(prod));
	}
}
