package com.springStudy1.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("pkt");
		ds.setPassword("1234");
		ds.setUrl("jdbc:mysql://210.219.170.244/pkt");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbc(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
