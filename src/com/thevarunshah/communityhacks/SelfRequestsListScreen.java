package com.thevarunshah.communityhacks;

import java.util.ArrayList;

import com.thevarunshah.communityhacks.backend.Database;
import com.thevarunshah.communityhacks.classes.Request;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SelfRequestsListScreen extends Activity{
	
	ArrayAdapter<Request> requestsAA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.self_requests_list);
		
		ListView requestsLV = (ListView) findViewById(R.id.selfRequestsList);
		
		ArrayList<Request> selfRequests = new ArrayList<Request>();
		for(Request r : Database.allRequests){
			if(r.requester.equals(Database.current)){
				selfRequests.add(r);
			}
		}
		if(selfRequests.size() == 0){
			Toast.makeText(getApplicationContext(), "No Self Requests", Toast.LENGTH_SHORT).show();
			finish();
		}
		requestsAA = new ArrayAdapter<Request>(getApplicationContext(), android.R.layout.simple_list_item_1, selfRequests){

	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            
	        	View view = super.getView(position, convertView, parent);
	            TextView textView=(TextView) view.findViewById(android.R.id.text1);
	            textView.setTextColor(Color.BLACK);
	            return view;
	        }
	    };
		requestsLV.setAdapter(requestsAA);
		requestsLV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				Request r = requestsAA.getItem(position);
				Intent i = new Intent(SelfRequestsListScreen.this, ViewClaimsScreen.class);
				i.putExtra("request", r);
				startActivity(i);
			}
		});
	}
}
