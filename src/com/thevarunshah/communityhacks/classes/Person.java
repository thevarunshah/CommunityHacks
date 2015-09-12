package com.thevarunshah.communityhacks.classes;

import java.util.ArrayList;

public class Person {

	String firstName;
	String lastName;
	String phone;
	String email;
	String address;
	String preferredContactType;
	ArrayList<Request> requests = new ArrayList<Request>();
	
	public Person(String firstName, String lastName, String phone, String email, String address, String preferredContactType){
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.preferredContactType = preferredContactType;
	}
}
