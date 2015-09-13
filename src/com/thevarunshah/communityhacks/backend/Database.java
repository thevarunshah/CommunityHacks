package com.thevarunshah.communityhacks.backend;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.thevarunshah.communityhacks.classes.Person;
import com.thevarunshah.communityhacks.classes.Request;

import android.util.Log;

public class Database {
	
	public static ArrayList<Person> users = new ArrayList<Person>();
	public static ArrayList<Request> allRequests = new ArrayList<Request>();
	public static Person current;
	public static String user_token = "";
	
	public static String HttpGet(String url, String params){

		try{

			HttpURLConnection urlConnection = (HttpURLConnection) new URL(url+"?"+params).openConnection();
			InputStream is = new BufferedInputStream(urlConnection.getInputStream());		 
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			String line = "";
			String response = "";
			while ((line = rd.readLine()) != null){
				response += line;
			}

			Log.i("test", response);
			return response;

		} catch(Exception e){

			System.out.println("exception: " + e);
		}

		return null;
	}
	
	/*
	public static String HttpPost(String url, String payload){

		try{

			HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Accept", "application/json");
			urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
	        writer.write(payload);
	        writer.close();
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			
			String line = "";
			String response = "";
			while ((line = br.readLine()) != null){
				response += line;
			}

			Log.i("test", response);
			return response;

		} catch(Exception e){

			System.out.println("exception: " + e);
		}

		return null;
	}
	*/

}
