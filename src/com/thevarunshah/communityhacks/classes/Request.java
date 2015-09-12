package com.thevarunshah.communityhacks.classes;

import java.util.ArrayList;
import java.util.Date;

public class Request {

	String title;
	String description;
	String notes;
	String type;
	double paid;
	int estTime;
	Date due;
	Person requester;
	ArrayList<Person> claimers = new ArrayList<Person>();
	
	public Request(String title, String description, String type, double paid, int estTime, Date due){
		
		this.title = title;
		this.description = description;
		this.type = type;
		this.paid = paid;
		this.estTime = estTime;
		this.due = due;
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
