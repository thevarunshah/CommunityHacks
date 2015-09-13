package com.thevarunshah.communityhacks;

import org.json.JSONException;
import org.json.JSONObject;

import com.thevarunshah.communityhacks.backend.Database;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		
		Button login = (Button) findViewById(R.id.login);
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String username = ((EditText) findViewById(R.id.username)).getText().toString();
				String password = ((EditText) findViewById(R.id.password)).getText().toString();
				
				String payload = "username="+username+"&password="+password;
				JSONObject response;
				try {
					response = new JSONObject(Database.HttpGet("http://jayravaliya.com:5000/api/v0.1/login", payload));
					String user_token = response.getString("success");
					Database.user_token = user_token;
					Intent i = new Intent(LoginScreen.this, RequestsListScreen.class);
					startActivity(i);
				} catch (JSONException e) {
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), "wrong username/password - try again.", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		Button register = (Button) findViewById(R.id.register);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(LoginScreen.this, RegisterScreen.class);
				startActivity(i);
			}
		});
	}
}
