package com.example.hikefinder;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Route extends Activity
{
	TextView address;
	TextView trails;
	// buttons
	Button checklistButton;
	Button mapButton;
	Button completedButton;
	
	Hike selectedHike;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.route);
		Intent intent = getIntent();
		
		selectedHike = GlobalDataContainer.getSelectedHike();
		
		address = (TextView) findViewById(R.id.textView3);
		trails = (TextView) findViewById(R.id.textView1);
		
		trails.setText("Trails :\n" + selectedHike.getTrails());
		address.setText("Address: \n" + selectedHike.getLocation());

		checklistButton = (Button) findViewById(R.id.button1);
		mapButton = (Button) findViewById(R.id.button2);
		completedButton = (Button) findViewById(R.id.button3);
		
		
		checklistButton.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
		        	Intent myIntent = new Intent(Route.this, Checklist.class);
		        	//myIntent.putExtra("key", value); //Optional parameters
		        	Route.this.startActivity(myIntent);
            }
        });
		
		mapButton.setOnClickListener( new OnClickListener() {
         @Override
         public void onClick(View v) {
         	
	        	Intent myIntent = new Intent(Route.this, Map.class);
	        	//myIntent.putExtra("key", value); //Optional parameters
	        	Route.this.startActivity(myIntent);
         }
     });
		
		completedButton.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
		        	Intent myIntent = new Intent(Route.this, Completed.class);
		        	//myIntent.putExtra("key", value); //Optional parameters
		        	Route.this.startActivity(myIntent);
            }
        });
		
	}
}
