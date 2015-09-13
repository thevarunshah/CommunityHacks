package com.thevarunshah.communityhacks.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable, Comparable<Person>{

	private static final long serialVersionUID = 1L;
	public String username;
	public String token;
	public String firstName;
	public String lastName;
	public String phone;
	public String email;
	public String zip;
	public String preferredContactType;
	public ArrayList<Request> requests = new ArrayList<Request>();
	
	public Person(String username, String firstName, String lastName, String phone, String email, String zip, String preferredContactType){
		
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.zip = zip;
		this.preferredContactType = preferredContactType;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == null || !(o instanceof Person)){
            return false;
		}
		
		Person op = (Person)o;
		if(this.username.equals(op.username)){
			return true;
		}
        
		return false;
	}

	@Override
	public int compareTo(Person p) {
		
		return this.username.compareTo(p.username);
	}
}
