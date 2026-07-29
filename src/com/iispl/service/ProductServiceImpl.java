package com.iispl.service;

import java.util.List;

import com.iispl.dao.ProductDao;
import com.iispl.dao.ProductDaoImpl;
import com.iispl.model.Product;

public class ProductServiceImpl implements ProductService{
	
	ProductDao productDao = new  ProductDaoImpl();


	@Override
	public List<Product> listAllProducts() {
		return null;
	}


	@Override
	public void saveProduct(Product product) {
		
	}


	@Override
	public Product getProduct(String productCode) {
		return productDao.getProduct(productCode);
	}


	@Override
	public void deleteProduct(String productCode) {
		productDao.deleteProduct(productCode);
		
		
	}

}
