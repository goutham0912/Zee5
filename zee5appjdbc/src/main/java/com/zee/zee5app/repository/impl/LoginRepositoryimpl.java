package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.utils.DBUtils;
@Repository
public class LoginRepositoryimpl implements LoginRepository {
	static private DBUtils utils=null;
	@Autowired
	DataSource datasource;
	public LoginRepositoryimpl() throws IOException
	{
//		 utils=DBUtils.getinstance();
	}
	private static LoginRepositoryimpl loginrepo=null;
//	public static LoginRepositoryimpl getInstacnce() throws IOException
//	{
//		if(loginrepo==null)
//			loginrepo=new LoginRepositoryimpl();
//		 return loginrepo;
//	}
	

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override

	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedstatement;
		try {
		System.out.println("---------");
			connection=datasource.getConnection();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String insertstatement="insert into login(username,password,regid,role) values(?,?,?,?)";
		System.out.println(connection);
		try {
			
			preparedstatement=connection.prepareStatement(insertstatement);
			preparedstatement.setString(1,login.getUserName());
			preparedstatement.setString(2,login.getPassword());
			preparedstatement.setString(3, login.getRegid());
			preparedstatement.setString(4,login.getRole().toString());
			System.out.println(preparedstatement);
			System.out.println("hii");
			int result=preparedstatement.executeUpdate();
			System.out.println(result+"--------");
			if(result>0)
			{
				connection.commit();
				return "Success";
			}
			else {
			
				return "Fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail";
		
		}
		
		
	}


	@Override
	public String changerole(String username, ROLE role) {
		Connection connection=null;
		PreparedStatement preparedStatement;
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String updatestatement="update login set role=? where username=?";
		try {
			preparedStatement=connection.prepareStatement(updatestatement);
			preparedStatement.setString(2,username);
			preparedStatement.setString(1, role.toString());
			int result=preparedStatement.executeUpdate();
//			System.out.println(role.t);
			if(result>0)
			{
				connection.commit();
				return "Role Updated";
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed to update the role";
		}
		
		
		return "Failed to update the role";
	}
	

}
