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
import android.widget.RadioGroup;

public class RegisterScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
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
				String payload = "username="+username+"&name="+firstName+"%20"+lastName+"&password="+password+"&email="+email+"&phone="+phone+"&zip_code="+zip;
				JSONObject response;
				try {
					response = new JSONObject(Database.HttpGet("http://jayravaliya.com:5000/api/v0.1/register", payload));
					String user_token = response.getJSONObject("success").getString("user_token");
					Database.user_token = user_token;
					Intent i = new Intent(RegisterScreen.this, RequestsListScreen.class);
					startActivity(i);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
