package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.UserRepository2;

public class UserService2 {
private UserRepository2 repository=UserRepository2.getInstance();
private UserService2()
{
	
}
private static UserService2 service;
//if we want to create that single object then we have to create inside the same class
public static UserService2 getInstance()
{
	//static makes it object dependent
	if(service==null)
		service=new UserService2();
	return service;
}
public String adduser(Register register)
{
	return this.repository.addUser(register);
}
public Register[] getUsers()
{
	return this.repository.getUsers();
}
public Register getUserbyId(String id)
{
	return this.repository.getUserbyId(id);
}
public String deleteUser(String id)
{
	return this.repository.deleteUser(id);
}
public Register updateuserdetails(String id,Register s)
{
	return this.repository.updateuserdetails(id, s);
}
}
