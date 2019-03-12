package com.bags.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bags.dao.CartItemDao;
import com.bags.dao.CategoryDao;
import com.bags.dao.CustomerDao;
import com.bags.dao.PaymentModeDao;
import com.bags.dao.PlaceOrderHistoryDao;
import com.bags.dao.ProductDao;
import com.bags.dao.SupplierDao;
import com.bags.dao.UserProcessDao;
import com.bags.daoimpl.CartItemDaoImpl;
import com.bags.daoimpl.CategoryDaoImpl;
import com.bags.daoimpl.CustomerDaoImpl;
import com.bags.daoimpl.PaymentModeDaoImpl;
import com.bags.daoimpl.PlaceOrderHistoryDaoImpl;
import com.bags.daoimpl.ProductDaoImpl;
import com.bags.daoimpl.SupplierDaoImpl;
import com.bags.daoimpl.UserProcessDaoImpl;
import com.bags.model.Authorities;
import com.bags.model.BillingAddress;
import com.bags.model.CartItem;
import com.bags.model.Category;
import com.bags.model.Customer;
import com.bags.model.PaymentMode;
import com.bags.model.PlaceOrderHistory;
import com.bags.model.Product;
import com.bags.model.ShippingAddress;
import com.bags.model.Supplier;
import com.bags.model.User;

@Configuration
@ComponentScan("com.bags")
@EnableTransactionManagement   //commit / rollback
public class DBConfiguration {
//to create beans
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		System.out.println("Entering DataSource Bean creation method ");
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/db");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("sa");
	    System.out.println("DataSource bean " +dataSource);
	    return dataSource;
	}
	/*
	 * <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBuilder">
	 * <property name="dataSource" ref="dataSource">
	 */
	@Bean(name="sessionFactory") //SessionFactory - factory of session objects
	public SessionFactory sessionFactory() {
		System.out.println("Entering sessionFactory creation method");
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		//An array of Class objects of all the entities
		//Map all entities to relational table
		Class classes[]=new Class[]{Product.class,Supplier.class,Category.class,Customer.class,User.class,Authorities.class,BillingAddress.class,ShippingAddress.class,CartItem.class,PlaceOrderHistory.class,PaymentMode.class};
		//localsesionfactorybuilder -> sessionfactory -> map all entities with relation table
		System.out.println("SessionFactory bean " + lsf);
	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	
	@Bean(name="userProcessDaoImpl")
	public UserProcessDao getUserProcess() {
		System.out.println("User Process Dao Created");
		return new UserProcessDaoImpl();
	}
	
	@Bean(name="productDaoImpl")
	public ProductDao getProduct() {
		System.out.println("Product Dao Created");
		return new ProductDaoImpl();
	}
	
	@Bean(name="supplierDaoImpl")
	public SupplierDao getSupplier() {
		System.out.println("Supplier Dao Created");
		return new SupplierDaoImpl();
	}
	
	@Bean(name="categoryDaoImpl")
	public CategoryDao getCategroy() {
		System.out.println("Category Dao Created");
		return new CategoryDaoImpl();
	}
	
	@Bean(name="customerDaoImpl")
	public CustomerDao getCustomer() {
		System.out.println("Customer Dao Created");
		return new CustomerDaoImpl();
	}
	
	@Bean(name="cartItemDaoImpl")
	public CartItemDao getCartItem() {
		System.out.println("Cart Item Dao Created");
		return new CartItemDaoImpl();
	}
	
	@Bean(name="placeOrderHistoryDaoImpl")
	public PlaceOrderHistoryDao getPlaceOrderHistory() {
		System.out.println("Place Order History Dao Created");
		return new PlaceOrderHistoryDaoImpl();
	}
	
	@Bean(name="paymentModeDaoImpl")
	public PaymentModeDao getPaymentMode() {
		System.out.println("Place Order History Dao Created");
		return new PaymentModeDaoImpl();
	}
	
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}
}
