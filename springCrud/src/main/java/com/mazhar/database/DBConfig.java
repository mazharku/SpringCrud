package com.mazhar.database;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBConfig {
    
	
	public DataSource jdbcDataSource() {
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		
		datasource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		
		datasource.setUsername("root");
		
		datasource.setPassword("");
		
		return datasource;
		
	}
}
