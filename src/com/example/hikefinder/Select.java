package com.example.hikefinder;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Select extends Activity {
	/*
	 * First Grouping
	 */
	
	//textfields
	TextView locationTextView;
	TextView freeParkingTextView;
	TextView foodNearbyTextView;
	TextView dogsAllowedTextView;
	
	//textboxes
	EditText locationText;
	
	//check boxes
	CheckBox freeParkingCheckBox;
	CheckBox foodNearbyCheckBox;
	CheckBox dogsAllowedCheckBox;
	
	/*
	 * Second Grouping
	 */
	
	//textfields
	TextView distanceTextView;
	TextView elevationTextView;
	TextView caloriesTextView;
	TextView steepHillsTextView;
	
	//spinners
	Spinner distanceSpinner;
	Spinner elevationSpinner;
	Spinner caloriesSpinner;
	
	//checkboxes
	CheckBox steepHillsCheckBox;
	
	/*
	 * Third Grouping
	 */
	
	//textfields
	TextView loopTextView;
	TextView oceanViewTextView;
	TextView waterfallTextView;
	TextView riverorLakeTextView;
	TextView historicalFeaturesTextView;
	TextView geographicalFeaturesTextView;
	TextView tallTreesTextView;
	TextView openSpacesTextView;
	
	//checkboxes
	CheckBox loopCheckBox;
	CheckBox oceanViewCheckBox;
	CheckBox waterfallCheckBox;
	CheckBox riverorLakeCheckBox;
	CheckBox historicalFeaturesCheckBox;
	CheckBox geographicalFeaturesCheckBox;
	CheckBox tallTreesCheckBox;
	CheckBox openSpacesCheckBox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// when the screen is first created, show the layout
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);
		Intent intent = getIntent();
		//String value = intent.getStringExtra("key"); //if it's a string you stored.

		final DatabaseHandler db = new DatabaseHandler(this);
		
		/*
		 * First Grouping
		 */
		
		//textviews
		locationTextView = (TextView) findViewById(R.id.textViewLocation);
		freeParkingTextView = (TextView) findViewById(R.id.textViewFreeParking);
		foodNearbyTextView = (TextView) findViewById(R.id.textViewFoodNearby);
		dogsAllowedTextView = (TextView) findViewById(R.id.textViewDogsAllowed);
		
		//textbox
		locationText = (EditText) findViewById(R.id.editTextLocation);
		
		// checkboxes
		freeParkingCheckBox = (CheckBox) findViewById(R.id.checkBoxFreeParking);
		foodNearbyCheckBox = (CheckBox) findViewById(R.id.checkBoxFoodNearby);
		dogsAllowedCheckBox = (CheckBox) findViewById(R.id.checkBoxDogsAllowed);
		
		//make invisible to start
		locationTextView.setVisibility(View.GONE);
		freeParkingTextView.setVisibility(View.GONE);
		foodNearbyTextView.setVisibility(View.GONE);
		dogsAllowedTextView.setVisibility(View.GONE);
		
		locationText.setVisibility(View.GONE);
		
		freeParkingCheckBox.setVisibility(View.GONE);
		foodNearbyCheckBox.setVisibility(View.GONE);
		dogsAllowedCheckBox.setVisibility(View.GONE);
		
		/*
		 * Second Grouping
		 */
		
		//textviews
		distanceTextView = (TextView) findViewById(R.id.textViewDistance);
		elevationTextView = (TextView) findViewById(R.id.textViewElevation);
		caloriesTextView = (TextView) findViewById(R.id.textViewCalories);
		steepHillsTextView = (TextView) findViewById(R.id.textViewSteepHills);
		
		//spinners
		distanceSpinner = (Spinner) findViewById(R.id.spinnerDistance);
		elevationSpinner = (Spinner) findViewById(R.id.spinnerElevation);
		caloriesSpinner = (Spinner) findViewById(R.id.spinnerCalories);
		
		//checkbox
		steepHillsCheckBox = (CheckBox) findViewById(R.id.checkBoxSteepHills);
		
		//Set Visibility to Invisible
		
		distanceTextView.setVisibility(View.GONE);
		elevationTextView.setVisibility(View.GONE);
		caloriesTextView.setVisibility(View.GONE);
		steepHillsTextView.setVisibility(View.GONE);
		
		steepHillsCheckBox.setVisibility(View.GONE);
		
		distanceSpinner.setVisibility(View.GONE);
		elevationSpinner.setVisibility(View.GONE);
		caloriesSpinner.setVisibility(View.GONE);
		
		/*
		 * Third Grouping
		 */
		
		//textviews
		loopTextView = (TextView) findViewById(R.id.textViewLoop);
		waterfallTextView = (TextView) findViewById(R.id.textViewWaterfall);
		oceanViewTextView = (TextView) findViewById(R.id.textViewOceanView);
		riverorLakeTextView = (TextView) findViewById(R.id.textViewRiverorLake);
		historicalFeaturesTextView = (TextView) findViewById(R.id.textViewHistoricalFeatures);
		geographicalFeaturesTextView = (TextView) findViewById(R.id.textViewGeographicalFeatures);
		riverorLakeTextView = (TextView) findViewById(R.id.textViewRiverorLake);
		tallTreesTextView = (TextView) findViewById(R.id.textViewTallTrees);
		openSpacesTextView = (TextView) findViewById(R.id.textViewOpenSpaces);
		
		//checkboxes
		loopCheckBox = (CheckBox) findViewById(R.id.checkBoxLoop);
		waterfallCheckBox = (CheckBox) findViewById(R.id.checkBoxWaterfall);
		oceanViewCheckBox = (CheckBox) findViewById(R.id.checkBoxOceanView);
		riverorLakeCheckBox = (CheckBox) findViewById(R.id.checkBoxRiverorLake);
		historicalFeaturesCheckBox = (CheckBox) findViewById(R.id.checkBoxHistoricalFeatures);
		geographicalFeaturesCheckBox = (CheckBox) findViewById(R.id.checkBoxGeographicalFeatures);
		riverorLakeCheckBox = (CheckBox) findViewById(R.id.checkBoxRiverorLake);
		tallTreesCheckBox = (CheckBox) findViewById(R.id.checkBoxTallTrees);
		openSpacesCheckBox = (CheckBox) findViewById(R.id.checkBoxOpenSpaces);
		
		//set visibility to invisible
		loopTextView.setVisibility(View.GONE);
		waterfallTextView.setVisibility(View.GONE);
		oceanViewTextView.setVisibility(View.GONE);
		riverorLakeTextView.setVisibility(View.GONE);
		historicalFeaturesTextView.setVisibility(View.GONE);
		geographicalFeaturesTextView.setVisibility(View.GONE);
		riverorLakeTextView.setVisibility(View.GONE);
		tallTreesTextView.setVisibility(View.GONE);
		openSpacesTextView.setVisibility(View.GONE);
		
		loopCheckBox.setVisibility(View.GONE);
		waterfallCheckBox.setVisibility(View.GONE);
		oceanViewCheckBox.setVisibility(View.GONE);
		riverorLakeCheckBox.setVisibility(View.GONE);
		historicalFeaturesCheckBox.setVisibility(View.GONE);
		geographicalFeaturesCheckBox.setVisibility(View.GONE);
		riverorLakeCheckBox.setVisibility(View.GONE);
		tallTreesCheckBox.setVisibility(View.GONE);
		openSpacesCheckBox.setVisibility(View.GONE);
	}
	
	/**
	* onClick handler for first grouping
	*/
	public void toggle_contents(View v){
	      locationText.setVisibility( locationText.isShown()
	                          ? View.GONE
	                          : View.VISIBLE );
	      locationTextView.setVisibility( locationTextView.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      freeParkingCheckBox.setVisibility( freeParkingCheckBox.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      foodNearbyCheckBox.setVisibility( foodNearbyCheckBox.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      dogsAllowedCheckBox.setVisibility( dogsAllowedCheckBox.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      freeParkingTextView.setVisibility( freeParkingTextView.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      foodNearbyTextView.setVisibility( foodNearbyTextView.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      dogsAllowedTextView.setVisibility( dogsAllowedTextView.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	}
	
	/**
	* onClick handler for second grouping
	*/
	public void toggle_contents_difficulty(View v){
	      distanceTextView.setVisibility( distanceTextView.isShown()
	                          ? View.GONE
	                          : View.VISIBLE );
	      
	      elevationTextView.setVisibility( elevationTextView.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      caloriesTextView.setVisibility( caloriesTextView.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      steepHillsTextView.setVisibility( steepHillsTextView.isShown()
	    		  ? View.GONE
	    		  : View.VISIBLE );
	      
	      steepHillsCheckBox.setVisibility( steepHillsCheckBox.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      distanceSpinner.setVisibility( distanceSpinner.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      elevationSpinner.setVisibility( elevationSpinner.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	      caloriesSpinner.setVisibility( caloriesSpinner.isShown()
                  ? View.GONE
                  : View.VISIBLE );
	      
	}
	
	public void toggle_contents_features(View v){
	      loopTextView.setVisibility( loopTextView.isShown()
	                          ? View.GONE
	                          : View.VISIBLE );
	      
	      waterfallTextView.setVisibility( waterfallTextView.isShown()
                ? View.GONE
                : View.VISIBLE );
	      
	      oceanViewTextView.setVisibility( oceanViewTextView.isShown()
                ? View.GONE
                : View.VISIBLE );
	      
	      historicalFeaturesTextView.setVisibility( historicalFeaturesTextView.isShown()
	    		  ? View.GONE
	    		  : View.VISIBLE );
	      
	      geographicalFeaturesTextView.setVisibility( geographicalFeaturesTextView.isShown()
	    		  ? View.GONE
	    		  : View.VISIBLE );
	      
	      riverorLakeTextView.setVisibility( riverorLakeTextView.isShown()
	    		  ? View.GONE
	    		  : View.VISIBLE );
	      
	      tallTreesTextView.setVisibility( tallTreesTextView.isShown()
	    		  ? View.GONE
	    		  : View.VISIBLE );
	      
	      openSpacesTextView.setVisibility( openSpacesTextView.isShown()
	    		  ? View.GONE
	    		  : View.VISIBLE );
	      
	      loopCheckBox.setVisibility( loopCheckBox.isShown()
                  ? View.GONE
                  : View.VISIBLE );

		  waterfallCheckBox.setVisibility( waterfallCheckBox.isShown()
			    ? View.GONE
			    : View.VISIBLE );
			
		  oceanViewCheckBox.setVisibility( oceanViewCheckBox.isShown()
			    ? View.GONE
			    : View.VISIBLE );
			
		  historicalFeaturesCheckBox.setVisibility( historicalFeaturesCheckBox.isShown()
				  ? View.GONE
				  : View.VISIBLE );
			
		  geographicalFeaturesCheckBox.setVisibility( geographicalFeaturesCheckBox.isShown()
				  ? View.GONE
				  : View.VISIBLE );
			
		  riverorLakeCheckBox.setVisibility( riverorLakeCheckBox.isShown()
				  ? View.GONE
				  : View.VISIBLE );
			
		  tallTreesCheckBox.setVisibility( tallTreesCheckBox.isShown()
				  ? View.GONE
				  : View.VISIBLE );
			
		  openSpacesCheckBox.setVisibility( openSpacesCheckBox.isShown()
				  ? View.GONE
				  : View.VISIBLE );
	      
	}

}
