package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.LoginServiceimpl;
import com.zee.zee5app.service.impl.UserServiceimpl;

public class Main3 {
public static void main(String[] args) {
//	Register register = null;
//	try {
//		register=new Register("goutham6","Goutham","S","goutham6@gmail.com","goutham1");
//		register.setContactno(new BigDecimal("7892745107"));
//		UserService service=UserServiceimpl.getInstance();
//		String result=service.addUser(register);
//		System.out.println(result);
//	} catch (InvalidIdLengthException | InvalidNameException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	UserService service=null;
//	try {
//		service = UserServiceimpl.getInstance();
//		Optional<Register> result=service.getUserById("goutham2");
//		System.out.println(result.get());
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IdNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (InvalidIdLengthException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (InvalidNameException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (InvalidPasswordException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	try {
//		service = UserServiceimpl.getInstance();
//		Optional<List<Register>> result=service.getAllUsers1();
//		if(result.isEmpty())
//		{
//			System.out.println("NO values");
//		}
//		else
//		{
//			result.get().forEach(e->System.out.println(e));
//		}	
////		for(Register r:result.get())
////		{
////			System.out.println(r);
////		}
//	} catch (InvalidIdLengthException | InvalidNameException | InvalidPasswordException | IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	try {
		LoginService lservice=LoginServiceimpl.getInstance();
		String result=lservice.changerole("goutham6@gmail.com",ROLE.ROLE_ADMIN);
		System.out.println(result);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
