package com.zee.zee5app.repository;


import com.zee.zee5app.dto.Register;


public class UserRepository2 {
	private Register[] registers=new Register[10];
	private static int count=-1;
	private UserRepository2()
	{
		
	}
	public Register[] getUsers()
	{
		return registers;
	}
	public String update(String id,Register register)
	{
		return "successful";
	}
	public Register getUserbyId(String id)
	{
		for(Register register:registers)
		{
			System.out.println(id);
//			System.out.println(register.getId().equals(id));
			if(register!=null && register.getId().equals(id))
			{
			return register;
			}
		}
		return null;
	}
	public String addUser(Register register)
	{
		if(count==registers.length-1)
		{
			Register[] temp=new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers=temp;
			registers[++count]=register;
			return "Success";
		}
		registers[++count]=register;
		return "added successfully";
	}
	public String deleteUser(String id)
	{
		int c=0;
		for(Register s:registers)
		{
			
			if(s!=null && id.equals(s.getId()))
			{
				for(int i=c;i<registers.length-2;i++)
				{
					registers[i]=registers[i+1];
					
				}
				
				return "Successfully deleted ";
			}
			c+=1;
		}
		return "ID not found";
	}
	public Register updateuserdetails(String id,Register s)
	{

	int c=0;
		for(Register s1:registers)
		{
			if(s1!=null && id.equals(s1.getId()))
			{
				
				registers[c]=s;
				
				return registers[c];
				
				
			}
			c+=1;
		
	}
		return null;
	}
	private static UserRepository2 userrepository;
	public static UserRepository2 getInstance()
	{
		if (userrepository==null)
			userrepository=new UserRepository2();
		return userrepository;
	}
	

}
