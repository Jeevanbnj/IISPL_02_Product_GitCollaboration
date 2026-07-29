package com.iispl.dao;

import java.sql.Connection;
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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> listAllProducts() {
		List<Product> productList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement prepStmt = null;
		
		String listProduct="Select * from  products";
		
		try {
			DataSource datasource = ConnectionPool.getDataSource();
			connection = datasource.getConnection();
			prepStmt = connection.prepareStatement(listProduct);
			
			ResultSet resultSet = prepStmt.executeQuery();
			while(resultSet.next()) {
				Product product = new Product(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getDate(4).toLocalDate(),
						resultSet.getDate(5).toLocalDate());
				productList.add(product);
			}
			connection.close();
		}catch(SQLException e) {
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
