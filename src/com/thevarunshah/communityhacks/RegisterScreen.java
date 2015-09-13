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
import android.widget.RadioGroup;

public class RegisterScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		Button register = (Button) findViewById(R.id.register);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText usernameET = (EditText) findViewById(R.id.username);
				String username = usernameET.getText().toString();
				EditText passwordET = (EditText) findViewById(R.id.password);
				String password = passwordET.getText().toString();
				EditText firstNameET = (EditText) findViewById(R.id.firstName);
				String firstName = firstNameET.getText().toString();
				EditText lastNameET = (EditText) findViewById(R.id.lastName);
				String lastName = lastNameET.getText().toString();
				EditText emailET = (EditText) findViewById(R.id.email);
				String email = emailET.getText().toString();
				EditText phoneET = (EditText) findViewById(R.id.phone);
				String phone = phoneET.getText().toString();
				EditText zipET = (EditText) findViewById(R.id.zip);
				String zip = zipET.getText().toString();
				
				String preferredContactType = "";
				RadioGroup rg = (RadioGroup) findViewById(R.id.prefContactType);
				switch(rg.getCheckedRadioButtonId()){
					case R.id.emailPref:
						preferredContactType = "Email";
						break;
					case R.id.phonePref:
						preferredContactType = "Phone";
						break;
				}
				
				Person p = new Person(username, firstName, lastName, phone, email, zip, preferredContactType);
				Database.users.add(p);
				Database.current = p;
				Intent i = new Intent(RegisterScreen.this, RequestsListScreen.class);
				startActivity(i);
			}
		});
	}
}
