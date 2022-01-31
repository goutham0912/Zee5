package com.zee.zee5app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface UserRepository {
	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
	public Optional<List<Register>> getAllUsers1() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
	public String deleteUserById(String id) throws IdNotFoundException;
	//can't create objects
	//only references
	//get access only to overriden method
}
