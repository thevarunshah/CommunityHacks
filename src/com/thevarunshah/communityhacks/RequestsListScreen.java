package com.thevarunshah.communityhacks;

import com.thevarunshah.communityhacks.backend.Database;
import com.thevarunshah.communityhacks.classes.Request;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class RequestsListScreen extends Activity{
	
	ArrayAdapter<Request> requestsAA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.requests_list);
		
		ListView requestsLV = (ListView) findViewById(R.id.requestsList);
		
		for(int i = 1; i <= 5; i ++){
			Request r = new Request("request #" + i, "some task", "Snow Plowing", 20, 60, "09/15/15", Database.current);
			Database.allRequests.add(r);
		}
		requestsAA = new ArrayAdapter<Request>(getApplicationContext(), android.R.layout.simple_list_item_1, Database.allRequests){

	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            
	        	View view = super.getView(position, convertView, parent);
	            TextView textView=(TextView) view.findViewById(android.R.id.text1);
	            textView.setTextColor(Color.BLACK);
	            return view;
	        }
	    };
		requestsLV.setAdapter(requestsAA);
		
		Button newRequest = (Button) findViewById(R.id.addRequest);
		newRequest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(RequestsListScreen.this, NewRequestScreen.class);
				startActivity(i);
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		requestsAA.notifyDataSetChanged();
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
