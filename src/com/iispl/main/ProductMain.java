package com.iispl.main;

import java.util.List;

import com.iispl.dao.ProductDaoImpl;
import com.iispl.model.Product;

public class ProductMain {    
    
    public static void main(String[] args) {
    	
    	
    	List<Product> products = new ProductDaoImpl().listAllProducts();
    	for (Product product : products) {
    		System.out.println(product);
    	}

        
    }
    
}