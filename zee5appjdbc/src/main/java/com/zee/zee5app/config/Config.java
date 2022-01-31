package com.zee.zee5app.config;

import java.beans.Beans;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//it is used to mark on config classes
//it is responsible to read the property file
@Configuration
@ComponentScan("com.zee.zee5app")
@PropertySource("classpath:application.properties")
public class Config {
//db related ,reading properties file,password encoder
	@Autowired //will bring the already created objectsbased on ref name /type
	Environment environment;//this impl object is prepared by string 
	@Bean //providing only one object whenever the method is called
	//if we dont specify the bean name //it takes methodName
	public DataSource datasource()
	{
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
//		basicDataSource.setInitialSize(5);
basicDataSource.setDefaultAutoCommit(false);
		return basicDataSource;
		
	}
}
