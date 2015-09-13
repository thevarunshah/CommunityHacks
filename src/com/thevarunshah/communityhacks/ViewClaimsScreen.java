package com.thevarunshah.communityhacks;

import com.thevarunshah.communityhacks.classes.Person;
import com.thevarunshah.communityhacks.classes.Request;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ViewClaimsScreen extends Activity{
	
	ArrayAdapter<Person> claimersAA;
	Request r;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_claims);
		
		ListView requestsLV = (ListView) findViewById(R.id.claimsList);
		
		r = (Request) getIntent().getSerializableExtra("request");
		claimersAA = new ArrayAdapter<Person>(getApplicationContext(), android.R.layout.simple_list_item_1, r.claimers){

	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            
	        	View view = super.getView(position, convertView, parent);
	            TextView textView=(TextView) view.findViewById(android.R.id.text1);
	            textView.setTextColor(Color.BLACK);
	            return view;
	        }
	    };
		requestsLV.setAdapter(claimersAA);
		requestsLV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				final Person p = claimersAA.getItem(position);
				
				new AlertDialog.Builder(getApplicationContext())
				.setIconAttribute(android.R.attr.alertDialogIcon)
				.setTitle("Confirm Help")
				.setMessage("Do you want " + p.username + " to help you?")
				.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						r.claimer = p;
						finish();
					}
				})
				.setNegativeButton("No", null)
				.show();
			}
		});
	}
}
