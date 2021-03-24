package com.example.tdadm.conf;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfiguration {
	
	@Primary
	@Bean
	@ConfigurationProperties("app.datasource.first")
	public DataSourceProperties firstDataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Primary
	@Bean
	@ConfigurationProperties("app.datasource.first.configuration")
	public HikariDataSource firstDataSource() {
	    return firstDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Bean
	@ConfigurationProperties("app.datasource.second")
	public DataSourceProperties secondDataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("app.datasource.second.configuration")
	public HikariDataSource secondDataSource() {
	    return secondDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
}
