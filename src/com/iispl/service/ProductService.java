package com.iispl.service;

import java.util.List;

import com.iispl.model.Product;

public interface ProductService {
	
	public void saveProduct(Product product);

	public List<Product> listAllProducts();
	
	public Product getProduct(String productCode);
	
	public void deleteProduct(String productCode);

}
