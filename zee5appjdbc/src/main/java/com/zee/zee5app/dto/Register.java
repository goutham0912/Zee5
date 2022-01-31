package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.Objects;

import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@Setter
@Getter

public class Register implements Comparable<Register>
{
	

	//private only accessible inside class
	//setter:set a value of a particular field
	//getter:to get values
	@Setter(value = AccessLevel.NONE)
 private String id;
	@Setter(value = AccessLevel.NONE)
 private String firstName;
	@Setter(value = AccessLevel.NONE)
 private String lastName;
 private String email;
 @Setter(value = AccessLevel.NONE)
 private String password;
 private BigDecimal contactno;
 public Register()
 {
	 //Explicit default constructor
	 //Customization has to be done while initialization of object
	 System.out.println("  hello");
 }
 
public void setId(String id) throws InvalidIdLengthException {
	//throws is required because it has list of all checked exceptions
	if(id.length()<6)
		throw new InvalidIdLengthException("id length less than 6");
	this.id = id;
}

public void setFirstName(String firstName) throws InvalidNameException {
	if(firstName=="" || firstName==null || firstName.length()<2 )
		throw new InvalidNameException("Invalid firstname");
	this.firstName = firstName;
}

public void setLastName(String lastName) throws InvalidNameException {
	if(lastName=="" ||lastName==null || lastName.length()<1 )
		throw new InvalidNameException("Invalid firstname");
	
	this.lastName = lastName;
}

public Register(String id, String firstName, String lastName, String email, String password) throws InvalidIdLengthException, InvalidNameException {
	super();
	this.setId(id);
	this.setFirstName(firstName);
	this.setLastName(lastName);
	this.email = email;
	this.password = password;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Register other = (Register) obj;
	return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
			&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
			&& Objects.equals(password, other.password);
}

@Override
public int hashCode() {
	return Objects.hash(email, firstName, id, lastName, password);
}

public void setPassword(String password) throws InvalidPasswordException {
	if(password=="" | password.length()<6 )
		throw new InvalidParameterException("Password is not valid");
	this.password = password;
}

@Override
public int compareTo(Register o) {
//	// TODO Auto-generated method stub
//	//used for sorting 
//	//Descending order
////	return o.id.compareTo(this.id);
return this.id.compareTo(o.getId());//Ascending order
//}

 


}
}
