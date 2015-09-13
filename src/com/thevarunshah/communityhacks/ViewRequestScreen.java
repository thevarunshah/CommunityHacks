package com.thevarunshah.communityhacks;

import com.thevarunshah.communityhacks.backend.Database;
import com.thevarunshah.communityhacks.classes.Request;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ViewRequestScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_request);
		
		Request r = (Request) getIntent().getSerializableExtra("request");
		((TextView) findViewById(R.id.title)).setText(r.title);
		((TextView) findViewById(R.id.postedBy)).setText(r.requester.username);
		((TextView) findViewById(R.id.description)).setText(r.description);
		((TextView) findViewById(R.id.type)).setText(r.type);
		((TextView) findViewById(R.id.pays)).setText("$"+r.pays);
		((TextView) findViewById(R.id.time)).setText(r.estTime+" mins");
		((TextView) findViewById(R.id.date)).setText(r.due);
		((TextView) findViewById(R.id.additionalInfo)).setText(r.notes);
		
		if(r.requester.equals(Database.current)){
			((Button) findViewById(R.id.claimRequest)).setEnabled(false);
		}
	}
}
