package com.iispl.main;

import java.util.List;

import com.iispl.dao.ProductDaoImpl;
import com.iispl.model.Product;
import com.iispl.service.ProductService;
import com.iispl.service.ProductServiceImpl;

public class ProductMain {    
	public static ProductService productService = new ProductServiceImpl();
    public static void main(String[] args) {
    	
    }
    
    private static void getProduct(String productCode) {
		Product product = productService.getProduct(productCode);
		if(productCode == null) {
			System.out.println("product code should not be empty");
		}else {
			System.out.println("product code: " + product.getProductCode());
			System.out.println("product name: " + product.getProductName());
			System.out.println("product description: " + product.getProductDescription());
			System.out.println("product activation date: " + product.getActivationDate());
			System.out.println("product expiry date: " + product.getExpiryDate());
		}
	}
    
}