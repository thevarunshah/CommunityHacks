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
import android.widget.Toast;

public class LoginScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		
		Button login = (Button) findViewById(R.id.login);
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String username = ((EditText) findViewById(R.id.username)).getText().toString();
				String password = ((EditText) findViewById(R.id.password)).getText().toString();
				
				if(username.equals("demo") && password.equals("demo")){
					Person p = new Person("Joe", "Smith", "123-456-7890", "me@something.com", "1 Demo Way, New Brunswick, NJ 08901", "email");
					Database.users.add(p);
					Database.current = p;
					Intent i = new Intent(LoginScreen.this, RequestsListScreen.class);
					startActivity(i);
				}
				else{
					Toast.makeText(getApplicationContext(), "wrong username/password - try again.", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
