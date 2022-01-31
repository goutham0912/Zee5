package com.zee.zee5app.exception;

import lombok.ToString;
//in service and repository throws can be executed,but in main inly try.catch
@ToString(callSuper = true)
public class InvalidIdLengthException extends Exception {
	public InvalidIdLengthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
//source->Generate Constructor from super class->string
	//source->generate to string->select to string //@ToString(call super=true)(Lambok)

	
//user defined exception

//	@Override
//	public String toString() {
//		return "IdNotFoundException [toString()=" + super.toString() + "]";
//	}
	
}
