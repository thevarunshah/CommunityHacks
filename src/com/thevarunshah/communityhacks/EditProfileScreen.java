package com.thevarunshah.communityhacks;

import com.thevarunshah.communityhacks.backend.Database;
import com.thevarunshah.communityhacks.classes.Person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditProfileScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile);
		
		Person p = Database.current;
		
		TextView username = (TextView) findViewById(R.id.username);
		username.setText(p.username);
		EditText firstName = (EditText) findViewById(R.id.firstName);
		firstName.setText(p.firstName);
		EditText lastName = (EditText) findViewById(R.id.lastName);
		lastName.setText(p.lastName);
		EditText email = (EditText) findViewById(R.id.email);
		email.setText(p.email);
		EditText phone = (EditText) findViewById(R.id.phone);
		phone.setText(p.phone);
		EditText zip = (EditText) findViewById(R.id.zip);
		zip.setText(p.zip);
		
		if(p.preferredContactType.equals("email")){
			RadioButton emailPref = (RadioButton) findViewById(R.id.emailPref);
			emailPref.setChecked(true);
		}
		else{
			RadioButton phonePref = (RadioButton) findViewById(R.id.phonePref);
			phonePref.setChecked(true);
		}
		
		Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Person p = Database.current;
				
				EditText firstName = (EditText) findViewById(R.id.firstName);
				p.firstName = firstName.getText().toString();
				EditText lastName = (EditText) findViewById(R.id.lastName);
				p.lastName = lastName.getText().toString();
				EditText email = (EditText) findViewById(R.id.email);
				p.email = email.getText().toString();
				EditText phone = (EditText) findViewById(R.id.phone);
				p.phone = phone.getText().toString();
				EditText zip = (EditText) findViewById(R.id.zip);
				p.zip = zip.getText().toString();
				
				RadioGroup rg = (RadioGroup) findViewById(R.id.prefContactType);
				switch(rg.getCheckedRadioButtonId()){
					case R.id.emailPref:
						p.preferredContactType = "email";
						break;
					case R.id.phonePref:
						p.preferredContactType = "phone";
						break;
				}
				
				finish();
			}
		});
		
		Button selfRequests = (Button) findViewById(R.id.viewSelfRequests);
		selfRequests.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(EditProfileScreen.this, SelfRequestsListScreen.class);
				startActivity(i);
			}
		});
		
	}
}
