package com.thevarunshah.communityhacks;

import java.util.ArrayList;
import java.util.Calendar;

import com.thevarunshah.communityhacks.classes.Request;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RequestsListScreen extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.requests_list);
		
		ListView requestsLV = (ListView) findViewById(R.id.requestsList);
		
		ArrayList<Request> requests = new ArrayList<Request>();
		for(int i = 1; i <= 20; i ++){
			Request r = new Request("request #" + i, "some task", "Snow Plowing", 20, 60, Calendar.getInstance().getTime());
			requests.add(r);
		}
		ArrayAdapter<Request> requestsAA = new ArrayAdapter<Request>(getApplicationContext(), android.R.layout.simple_list_item_1, requests){

	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            
	        	View view = super.getView(position, convertView, parent);
	            TextView textView=(TextView) view.findViewById(android.R.id.text1);
	            textView.setTextColor(Color.BLACK);
	            return view;
	        }
	    };
		requestsLV.setAdapter(requestsAA);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.person_info_menu, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.person_info_menu:
	        	Intent i = new Intent(RequestsListScreen.this, EditProfileScreen.class);
	        	startActivity(i);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
