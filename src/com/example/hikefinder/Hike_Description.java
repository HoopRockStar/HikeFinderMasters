package com.example.hikefinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Hike_Description extends Activity{
	
	Hike selectedHike;
	
	TextView tv4;
	TextView tv5;
	TextView tv6;
	
	Button selectHike;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// when the screen is first created, show the layout
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hike_description);
		Intent intent = getIntent();
		//String value = intent.getStringExtra("key"); //if it's a string you stored.
	
		selectedHike = GlobalDataContainer.getSelectedHike();
		
		tv6 = (TextView) findViewById(R.id.textView6);
		tv6.setText(selectedHike.getName());
		
		tv4 = (TextView) findViewById(R.id.textView4);
		tv4.setText(selectedHike.getFeaturesString());

		tv5 = (TextView) findViewById(R.id.textView5);
		tv5.setText(selectedHike.getDescription());
		
	//Below to be filled in after remaining layout.xml files are added
		selectHike = (Button) findViewById(R.id.button1);
		
		selectHike.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
            // TODO Auto-generated method stub
        	Intent myIntent = new Intent(Hike_Description.this, Route.class);
        	//myIntent.putExtra("key", value); //Optional parameters
        	Hike_Description.this.startActivity(myIntent);
        }
    });
	
	}

}






