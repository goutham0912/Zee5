package com.zee.zee5app;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.UserRepository;

public class MainSpring {
	public static void main(String[] args) {
		//we have to initiate application context container
		//using java based container
//		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
		//application context does not have close method
		AbstractApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
		
		UserRepository repository=applicationContext.getBean(UserRepository.class);
		UserRepository repository2=applicationContext.getBean(UserRepository.class);
		System.out.println(repository);
		System.out.println(repository2);
		System.out.println(repository.hashCode());
		System.out.println(repository2.hashCode());
		System.out.println(repository.equals(repository2));
		DataSource datasource=applicationContext.getBean("datasource",DataSource.class);
		System.out.println(datasource!=null);
		Register register=null;
		try {
			register=new Register("goutham15","Goutham","S","goutham15@gmail.com","goutham1");
			register.setContactno(new BigDecimal("7892745107"));
			System.out.println(repository.addUser(register));
		} catch (InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		register.setContactno(new BigDecimal("7892745107"));
		applicationContext.close();
		
	}

}
