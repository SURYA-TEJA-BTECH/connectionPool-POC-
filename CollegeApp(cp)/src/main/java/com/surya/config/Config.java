package com.surya.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.surya")
@PropertySource("datasource.properties")
public class Config {
	@Autowired
	private Environment environment;

	@Bean
	public DataSource createDs() {

		
		//creating connection pool by creating the object of the class which is implementing datasource interface
		HikariDataSource config = new HikariDataSource();

		config.setJdbcUrl(environment.getProperty("jdbc.url"));
		config.setPassword(environment.getProperty("jdbc.username"));
		config.setUsername(environment.getProperty("jdbc.password"));
		config.setMinimumIdle(10);
		config.setMaximumPoolSize(20);

		return config;

	}

}
