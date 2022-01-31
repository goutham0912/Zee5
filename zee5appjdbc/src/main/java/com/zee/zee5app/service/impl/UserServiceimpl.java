package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryimpl;
import com.zee.zee5app.service.UserService;
@Service
public class UserServiceimpl implements UserService {
	
	//private static UserService service;
	
	
	UserRepository repository=null;
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return repository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return repository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return this.repository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.deleteUserById(id);
	}

	@Override
	public Optional<List<Register>> getAllUsers1() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException{
		// TODO Auto-generated method stub
		return this.repository.getAllUsers1();
	}

}
