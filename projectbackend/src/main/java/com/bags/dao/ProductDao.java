package com.bags.dao;

import java.util.List;

import com.bags.model.Category;
import com.bags.model.Product;

public interface ProductDao {
	boolean saveProduct(Product product);
	boolean deleteProduct(int id);
	boolean updateProduct(Product product);
	Product getId(int id);
	public List<Product> getAllProduct();
	List<Category> getAllCategories();
}
