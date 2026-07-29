package com.iispl.main;


import com.iispl.service.ProductService;
import com.iispl.service.ProductServiceImpl;

public class ProductMain {    
    public static ProductService productService=new ProductServiceImpl();
    public static void main(String[] args) {
    	
    	
        
    }
    private static void deleteProduct(String productCode) {
    	if(productCode==null) {
    		System.out.println("ProductCode cannot be null");
    	}else {
    		productService.deleteProduct(productCode);

    
		
    	}  

    }
}