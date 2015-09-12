package com.thevarunshah.communityhacks.classes;

import java.util.ArrayList;

public class Request {

	String title;
	String description;
	String notes;
	String type;
	double pays;
	int estTime;
	String due;
	Person requester;
	ArrayList<Person> claimers = new ArrayList<Person>();
	
	public Request(String title, String description, String type, double pays, int estTime, String due, Person requester){
		
		this.title = title;
		this.description = description;
		this.type = type;
		this.pays = pays;
		this.estTime = estTime;
		this.due = due;
		this.requester = requester;
	}
	
	public void setNotes(String notes){
		this.notes = notes;
	}
	
	public void addClaimer(Person person){
		claimers.add(person);
	}
	
	@Override
	public String toString() {
		
		return this.title;
	}
}
