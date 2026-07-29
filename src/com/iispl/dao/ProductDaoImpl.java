package com.iispl.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.iispl.connectionpool.ConnectionPool;
import com.iispl.model.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void saveProduct(Product product) {
		
		Connection connection = null;
		String insertSQL = "insert into products values(?, ?, ?, ?, ?)";
		PreparedStatement prepStmt = null;
		
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(insertSQL);
			prepStmt.setString(1, product.getProductCode());
			prepStmt.setString(2, product.getProductName());
			prepStmt.setString(3, product.getProductDescription());
			prepStmt.setDate(4, Date.valueOf(product.getActivationDate()));
			prepStmt.setDate(5, Date.valueOf(product.getExpiryDate()));
			
			prepStmt.executeUpdate();
			
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> listAllProducts() {

	    List<Product> productList = new ArrayList<>();

	    String selectSQL = "SELECT * FROM products";

	    try {
	        DataSource ds = ConnectionPool.getDataSource();
	        Connection connection = ds.getConnection();

	        PreparedStatement prepStmt = connection.prepareStatement(selectSQL);

	        ResultSet resultSet = prepStmt.executeQuery();

	        while (resultSet.next()) {

	            Product product = new Product(
	                    resultSet.getString(1),
	                    resultSet.getString(2),
	                    resultSet.getString(3),
	                    resultSet.getDate(4).toLocalDate(),
	                    resultSet.getDate(5).toLocalDate());

	            productList.add(product);
	        }

	        connection.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return productList;
	}

	@Override
	public Product getProduct(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(String productCode) {
		// TODO Auto-generated method stub

	}

}
