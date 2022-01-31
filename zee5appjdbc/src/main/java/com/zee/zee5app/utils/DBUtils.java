package com.zee.zee5app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Component;
@Component
public class DBUtils {
	Connection connection=null;
private DBUtils() throws IOException {
	// TODO Auto-generated constructor stub
	properties=loadProperties();
	
}
public static DBUtils dbutils;
Properties properties=null;
//public static DBUtils getinstance() throws IOException
//{
//	if(dbutils==null)
//		dbutils=new DBUtils();
//	return dbutils;
//}
public Connection getConnection()
{
	
	try {
//		properties = loadProperties();
		System.out.println(properties);
		if(connection==null||connection.isClosed())
		{
		connection=DriverManager.getConnection(properties.getProperty("jdbc.url"), 
				properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
		connection.setAutoCommit(false);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	
}
public void closeConnection(Connection connection)
{
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private Properties loadProperties() throws IOException{
	//getResourceasStream searches in src/main/resources file
	InputStream inputstream=DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
	Properties properties=new Properties();
	properties.load(inputstream);
	return properties;
	
}
//public static void main(String[] args) throws IOException {
//	DBUtils utils=DBUtils.getinstance();
//	Connection connection=utils.getConnection();
//	System.out.println(connection!=null);
//}
}
