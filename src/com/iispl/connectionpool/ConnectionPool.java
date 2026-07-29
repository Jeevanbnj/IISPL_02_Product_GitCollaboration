package com.iispl.connectionpool;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool {
	
	private static ComboPooledDataSource dataSource;
	static {
		try {
			dataSource = new ComboPooledDataSource();
			Properties properties = new Properties();
			InputStream inputStream = new FileInputStream("resources/db.properties");
			properties.load(inputStream);
			dataSource.setDriverClass(properties.getProperty("DRIVER_CLASS"));
			dataSource.setJdbcUrl(properties.getProperty("CONNECTION_STRING"));
			dataSource.getProperties().setProperty("sslmode", "require");
			dataSource.setUser(properties.getProperty("USERNAME"));
			dataSource.setPassword(properties.getProperty("PASSWORD"));
			//optional
			dataSource.setInitialPoolSize(5);
			dataSource.setMinPoolSize(5);
			dataSource.setAcquireIncrement(5);
			dataSource.setMaxPoolSize(5);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public static javax.sql.DataSource getDataSource() {
		// TODO Auto-generated method stub
		return dataSource;
	}
	

}
