package com.iispl.main;

import com.iispl.model.Product;
import com.iispl.service.ProductService;
import com.iispl.service.ProductServiceImpl;

public class ProductMain {    
	
	public static ProductService productService = new ProductServiceImpl();
    
    public static void main(String[] args) {
    	
    	
    	
    }
    
    public static void saveProduct(Product product) {
    	productService.saveProduct(product);
    	System.out.println("Product saved");
    }
    
}