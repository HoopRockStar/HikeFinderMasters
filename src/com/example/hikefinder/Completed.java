package com.example.hikefinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

public class Completed  extends Activity{
	
	CheckBox completedCheck;
	
	RatingBar rating;
	
	EditText reviewText;
	EditText notesText;
	
	Button saveButton;
	
	Hike selectedHike;
	DatabaseHandler db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// when the screen is first created, show the layout
		super.onCreate(savedInstanceState);
		setContentView(R.layout.completed);
		Intent intent = getIntent();
		//String value = intent.getStringExtra("key"); //if it's a string you stored.

      db = new DatabaseHandler(this);
		
		completedCheck = (CheckBox) findViewById(R.id.checkBox1);
		
		selectedHike = GlobalDataContainer.getSelectedHike();

      boolean completedChecked = (selectedHike.getCompleted() == 1) ? true : false;
		completedCheck.setChecked(completedChecked);
		
		rating = (RatingBar) findViewById(R.id.ratingBar1);
		rating.setRating(selectedHike.getRating());
		
		reviewText = (EditText) findViewById(R.id.editText1);
		reviewText.setText(selectedHike.getReview());
		notesText = (EditText) findViewById(R.id.editText2);
		notesText.setText(selectedHike.getNotes());
		
		saveButton = (Button) findViewById(R.id.button1);
		
		saveButton.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            selectedHike = GlobalDataContainer.getSelectedHike();
            
            int completedChecked = (completedCheck.isChecked()) ? 1 : 0;
            selectedHike.setCompleted(completedChecked);
            
            selectedHike.setRating((int)rating.getRating());
            
            selectedHike.setReview((String)reviewText.getText().toString());
            selectedHike.setNotes((String)notesText.getText().toString());
            
            db.updateHike(selectedHike);
            	
	        	Intent myIntent = new Intent(Completed.this, MainActivity.class);
	        	//myIntent.putExtra("key", value); //Optional parameters
	        	Completed.this.startActivity(myIntent);
            }
        });
		
	}
}
