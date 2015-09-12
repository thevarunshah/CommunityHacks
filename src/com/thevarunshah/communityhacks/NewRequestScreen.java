package com.thevarunshah.communityhacks;

import java.util.ArrayList;

import com.thevarunshah.communityhacks.backend.Database;
import com.thevarunshah.communityhacks.classes.Request;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewRequestScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_request);
		
		ArrayList<String> types = new ArrayList<String>();
		types.add("Shoveling");
		types.add("Lawn Mowing");
		types.add("Moving");
		types.add("Groceries");
		types.add("Pets");
		types.add("Other");
		Spinner requestTypes = (Spinner) findViewById(R.id.type);
		ArrayAdapter<String> typesAA = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, types);
		requestTypes.setAdapter(typesAA);
		
		Button postRequest = (Button) findViewById(R.id.addRequest);
		postRequest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String title = ((EditText) findViewById(R.id.title)).getText().toString();
				String description = ((EditText) findViewById(R.id.description)).getText().toString();
				String type = ((Spinner) findViewById(R.id.type)).getSelectedItem().toString();
				double pays = Double.parseDouble(((EditText) findViewById(R.id.pays)).getText().toString());
				int time = Integer.parseInt(((EditText) findViewById(R.id.time)).getText().toString());
				String date = ((EditText) findViewById(R.id.date)).getText().toString();
				String additionalInfo = ((EditText) findViewById(R.id.additionalInfo)).getText().toString();
				
				Request r = new Request(title, description, type, pays, time, date, Database.current);
				r.setNotes(additionalInfo);
				Database.allRequests.add(r);
				finish();
			}
		});
	}
}
