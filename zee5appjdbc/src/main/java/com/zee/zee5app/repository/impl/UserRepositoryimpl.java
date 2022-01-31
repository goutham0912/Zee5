package com.zee.zee5app.repository.impl;

import java.awt.Window.Type;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;
@Repository//it creates singelton objects for us
public class UserRepositoryimpl implements UserRepository {
	
//	private List<Register> registers1=new ArrayList<Register>();
	//it constructs list size of 10
	@Autowired
	LoginRepository loginRepository ;
//	private static UserRepository repository=null;
//	private static DBUtils utils =null;
	@Autowired //it will bring already created objects either using name or type
	DataSource dataSource;
	public UserRepositoryimpl() throws IOException
	{
//		repository=new UserRepositoryimpl();
//		utils=DBUtils.getinstance();
	}
	
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedstatement;
		String insertStatement="insert into register"
				+ "(regid,firstname,lastname,email,contactnumber,password)" 
						+ "values(?,?,?,?,?,?)";
		try {
			connection =dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedstatement=connection.prepareStatement(insertStatement);
			preparedstatement.setString(1, register.getId());
			preparedstatement.setString(2, register.getFirstName());
			preparedstatement.setString(3, register.getLastName());
			preparedstatement.setString(4, register.getEmail());
			preparedstatement.setBigDecimal(5, register.getContactno());
			String salt=PasswordUtils.getSalt(30);
			String encrypted_password=PasswordUtils.generateSecurePassword(register.getPassword(), salt);
			preparedstatement.setString(6, encrypted_password);
			int result=preparedstatement.executeUpdate();//returns no of rows affected using insert statement
			if(result>0)
			{
				connection.commit();
		Login login=new Login();
				login.setUserName(register.getEmail());
				login.setPassword(encrypted_password);
				login.setRegid(register.getId());
				login.setRole(ROLE.ROLE_USER);
				System.out.println(result+"---");
				String res=loginRepository.addCredentials(login);
			
				if(res.equals("Success"))
				{
					
					System.out.println(res+"----");
			
				return "Success";
				}
			else {
				System.out.println("-----------------");
					connection.rollback();
					return "Fail";
				}
			}
			else
			{
				connection.rollback();
				return "Fail";
			}
		}
			
		
			
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
			}
		
		
	
		
	
	}
	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException,InvalidPasswordException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		//hold the complete set
		
		ResultSet resultset=null;
		String selectstatement="select * from register where regid=?";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(selectstatement);
			preparedStatement.setString(1, id);
			resultset=preparedStatement.executeQuery();
			
			if(resultset.next())
			{
				//next is used to traverse the result set
				//Initially rs is placed at first record
				//when it is called first time it retrieves first record and then then refres to second row
//				System.out.println("hii");
				Register register=new Register();
				 register.setId(resultset.getString("regid"));
			register.setFirstName(resultset.getString("firstname"));
			register.setLastName(resultset.getString("lastname"));
			register.setEmail(resultset.getString("email"));
			register.setContactno(resultset.getBigDecimal("contactnumber"));
			
			register.setPassword(resultset.getString("password"));
//			System.out.println(register);
			return Optional.of(register);
			
			
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Optional<List<Register>> result=getAllUsers1();
		if(result.isEmpty())
		{
			return null;
		}
		else {
			List<Register> result1=result.get();
			Register[] register=new Register[result1.size()];
			result1.toArray(register);
			return register;
		}
	}
	@Override
	public Optional<List<Register>> getAllUsers1() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		//hold the complete set
      List<Register> result=new ArrayList<Register>();
		ResultSet resultset=null;
		String selectstatement="select * from register";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			preparedStatement=connection.prepareStatement(selectstatement);
		
			resultset=preparedStatement.executeQuery();
			
			while(resultset.next())
			{
				//next is used to traverse the result set
				//Initially rs is placed at first record
				//when it is called first time it retrieves first record and then then refres to second row
				
				Register register=new Register();
				 register.setId(resultset.getString("regid"));
			register.setFirstName(resultset.getString("firstname"));
			register.setLastName(resultset.getString("lastname"));
			register.setEmail(resultset.getString("email"));
			register.setContactno(resultset.getBigDecimal("contactnumber"));
			register.setPassword(resultset.getString("password"));
//			System.out.println(register);
			result.add(register);
			//return Optional.of(register);
			
			
			
				
			}
			return Optional.ofNullable(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedstatement;
		String deleteStatement="delete from register where regid=?";
		String result2="";
				
		try {
			connection =dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedstatement=connection.prepareStatement(deleteStatement);
			preparedstatement.setString(1, id);
			
			int result=preparedstatement.executeUpdate();//returns no of rows affected using insert statement
			if(result>0)
			{
				//on delete cascade deletes the child row automatically if parent is 
				//deleted
			
				return "Success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	
		
		return null;
	}
	
//	@Override
//	public String addUser(Register register) {
//		// TODO Auto-generated method stub
////		if(count==registers.length-1)
////		{
////			Register[] temp=new Register[registers.length*2];
////			System.arraycopy(registers, 0, temp, 0, registers.length);
////			registers=temp;
////			registers[++count]=register;
////			return "Success";
////		}
////		registers[++count]=register;
////		return "added successfully";
//		System.out.println(register.getId());
//	
//		boolean result=this.registers.add(register);
//		System.out.println(registers.size());
//		if(result)
//		{
//			return "Added successfuly--";
//		}
//		return "failed to add";
//		
//	}
//
//	@Override
//	public String updateUser(String id, Register register) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public Optional<Register> getUserById(String id) throws IdNotFoundException {
//		Register register2=null;
//		for (Register register : registers) {
//			if(id.equals(register.getId()))
//			{
//				register2=register;
//				break;
//			}
//			
//			
//		}
//		return Optional.of(Optional.ofNullable(register2).orElseThrow(()->new IdNotFoundException("id not found")));
//		// TODO Auto-generated method stub
//		
//	}
////	@Override
////	public Register getUserById(String id) throws IdNotFoundException {
////		//Optional is uset to handle null pointer exception
////		Register register2=null;
////		for(Register r:registers)
////		{
////			System.out.println(r.getId());
////			if( r.getId().equals(id))
////			{
////				
//////				return Optional.of(r);//sure there is a object
////				register2=r;
////			}
////		}
////		if(register2==null)
////			throw new IdNotFoundException("id not found");
//////		return Optional.empty();//similar to return null
////		return register2;
////	}
//
//	@Override
//	public Register[] getAllUsers() {
//		// TODO Auto-generated method stub
//		Register[] registers2=new Register[registers.size()];
//		
//		return registers.toArray(registers2);
//		
//	}
//
//	@Override
//	public String deleteUserById(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//	Optional<Register> optional=this.getUserById(id);
//	System.out.println(optional);
//	if(optional.isPresent())
//	{
//		boolean result=registers.remove(optional.get());
//		System.out.println("resut"+result);
//		if(result)
//			return "Success";
//		else {
//			return "Fail";
//		}
//	}
//	else {
//		throw new IdNotFoundException("id not found");
//	}
//	}
//	@Override
//	public List<Register> getAllUsers1() {
//		// TODO Auto-generated method stub
//	
//		return new ArrayList(registers.descendingSet());
////		ArrayList<Register> a=new ArrayList<Register>(registers);
////		Collections.sort(a);
////		return a;
//	
////		return 
//	}
	

}
