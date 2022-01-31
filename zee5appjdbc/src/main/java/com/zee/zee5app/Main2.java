package com.zee.zee5app;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
//if hashcode and equals are overwritten then objects with same parameter will be same hashcode value and return true
//if not overwritten then it gives different value.
public class Main2 {
	public static void main(String []args )
	{
		try {
			Register register = new Register("ab00001", "abhinandan", "chivate", "abhi@gmail.com", "123456");
			
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			Register register2 = new Register("ab00001", "abhinandan", "chivate", "abhi@gmail.com", "123456");
			System.out.println(register2);
			System.out.println(register2.toString());
			System.out.println(register2.hashCode());
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			System.out.println("equals method call"+register.equals(register2));
			
		} catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
