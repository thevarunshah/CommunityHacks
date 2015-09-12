package com.thevarunshah.communityhacks;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RequestsListScreen extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.requests_list);
		
		ListView requestsLV = (ListView) findViewById(R.id.requestsList);
		;
		ArrayList<String> requests = new ArrayList<String>();
		for(int i = 1; i <= 20; i ++){
			requests.add("request #" + i);
		}
		ArrayAdapter<String> requestsAA = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, requests){

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
}
