package com.zee.zee5app;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.UserServiceimpl;

public class Main {
	public static void main(String[] args)
	{
	
		Register register =new Register();
		//register=reference which will refer your object(holds address of object)
//		Register register1=new Register("1","goutham","S","goutham@gmail.com","goutham123");
		//new create the object
		//Register()-constructor -default
		try {
			register.setId("123456");
		} catch (InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			register.setFirstName("goutham");
			register.setLastName("S");
		
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		register.setEmail("goutham@gmail.com");
		try {
			register.setPassword("Goutham123");
		} catch (InvalidPasswordException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(register);
		//same output default calls toString
		System.out.println(register.toString());
		System.out.println(register.getEmail());
		Login login=new Login();
		UserService2 service=UserService2.getInstance();
		
//	Day1
//		for(int i=1;i<=21;i++)
//		{
//			Register register2 =new Register();
//			register2.setId("g"+i);
//			register2.setFirstName("goutham"+i);
//			register2.setLastName("S"+i);
//			register2.setEmail("goutham@gmail.com"+i);
//			register2.setPassword("Goutham123"+i);
//			String result=service.adduser(register2);
////			System.out.println(result);
//			
//			
//		}
//		Register register3=service.getUserbyId("g22");
////		System.out.println(register3.toString());
//		System.out.println(register3!=null);
//	for(Register register4:service.getUsers())
//	{
//		System.out.println(register4);
//	}
	UserService service2=UserServiceimpl.getInstance();
	System.out.println(service2);
	for(int i=1;i<=21;i++)
		{
			Register register2 =new Register();
			try {
				register2.setId("g000001"+i);
				register2.setFirstName("goutham");
				register2.setLastName("S");
				
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			register2.setEmail("goutham@gmail.com");
			try {
				register2.setPassword("Goutham123");
			} catch (InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result=service2.addUser(register2);
			System.out.println(result);
			
			
		}
	UserService s1=UserServiceimpl.getInstance();
	try {
		Optional<Register> optional=s1.getUserById("g0000011");

		System.out.println("Found"+optional.get());
	} catch (IdNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("ID not found");
		e.printStackTrace();
	}
	

	s1.getAllUsers1().forEach(e->System.out.println(e));
	try {
		String optional2=s1.deleteUserById("g0000011");
		System.out.println(optional2);
	} catch (IdNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	}

}
