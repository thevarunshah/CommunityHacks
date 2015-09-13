package com.thevarunshah.communityhacks;

import com.thevarunshah.communityhacks.backend.Database;
import com.thevarunshah.communityhacks.classes.Request;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewRequestScreen extends Activity{

	Request r;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_request);
		
		r = (Request) getIntent().getSerializableExtra("request");
		((TextView) findViewById(R.id.title)).setText(r.title);
		((TextView) findViewById(R.id.postedBy)).setText(r.requester.username);
		((TextView) findViewById(R.id.description)).setText(r.description);
		((TextView) findViewById(R.id.type)).setText(r.type);
		((TextView) findViewById(R.id.pays)).setText("$"+r.pays);
		((TextView) findViewById(R.id.time)).setText(r.estTime+" mins");
		((TextView) findViewById(R.id.date)).setText(r.due);
		((TextView) findViewById(R.id.additionalInfo)).setText(r.notes);
		
		Button claim = (Button) findViewById(R.id.claimRequest);
		if(r.requester.equals(Database.current)){
			claim.setEnabled(false);
		}
		if(r.claimers.contains(Database.current)){
			claim.setEnabled(false);
		}
		
		claim.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				r.claimers.add(Database.current);
				Toast.makeText(getApplicationContext(), "Help offer sent to " + r.requester.username, Toast.LENGTH_LONG).show();
				finish();
			}
		});
	}
}
