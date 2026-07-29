package com.iispl.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.iispl.dao.ProductDaoImpl;
import com.iispl.model.Product;
import com.iispl.service.ProductService;
import com.iispl.service.ProductServiceImpl;

public class ProductMain {    
	
	 private static ProductService productService = new ProductServiceImpl();

	public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
    	
    	while (true) {

            System.out.println("\n========= PRODUCT MANAGEMENT =========");
            System.out.println("1. Create Product");
            System.out.println("2. Display Products");
            System.out.println("3. Find Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1:
            	
            	System.out.print("Enter Product Code : ");
                String productCode = scanner.nextLine();

                System.out.print("Enter Product Name : ");
                String productName = scanner.nextLine();


                System.out.print("Enter Product Description : ");
                String productDescription = scanner.nextLine();

                LocalDate activationDate = LocalDate.now();

                LocalDate expiryDate = LocalDate.now().plusYears(3);

                Product product = new Product(productCode, productName,
                        productDescription, activationDate, expiryDate);
                
                saveProduct(product);
                break;

            case 2:
                listAllProducts();
                break;

            case 3:
            	System.out.print("Enter Product Code : ");
                String productCode2 = scanner.next();
                getProduct(productCode2);
                break;

            case 4:
            	System.out.print("Enter Product Code : ");
                String productCode1 = scanner.next();
                deleteProduct(productCode1);
                break;

            case 5:
                System.out.println("Thank You...");
                scanner.close();
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
            }
        }
    }
    
    private static void deleteProduct(String productCode) {
		// TODO Auto-generated method stub
		
	}

	private static void getProduct(String productCode) {
		// TODO Auto-generated method stub
		
	}

	private static void saveProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	private static void listAllProducts() {

        List<Product> productList = productService.listAllProducts();

        System.out.printf("%-15s %-20s %-30s %-15s %-15s%n",
                "Product Code", "Product Name", "Description",
                "Activation", "Expiry");

        for (Product product : productList) {
            System.out.printf("%-15s %-20s %-30s %-15s %-15s%n",
                    product.getProductCode(),
                    product.getProductName(),
                    product.getProductDescription(),
                    product.getActivationDate(),
                    product.getExpiryDate());
        }
    }

    
}