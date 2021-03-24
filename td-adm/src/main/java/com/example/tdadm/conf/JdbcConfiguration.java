package com.example.tdadm.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcConfiguration {

	@Primary
	@Bean(name = "primaryJdbcTemplate")
	JdbcTemplate primaryJdbcTemplate(@Qualifier("firstDataSource") DataSource primaryDataSource) {
		return new JdbcTemplate(primaryDataSource);
	}

	@Bean(name = "secondaryJdbcTemplate")
	JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondDataSource") DataSource secondaryDataSource) {
		JdbcTemplate secondaryJdbcTemplate = new JdbcTemplate(secondaryDataSource);
		return  secondaryJdbcTemplate;
	}
	
}
