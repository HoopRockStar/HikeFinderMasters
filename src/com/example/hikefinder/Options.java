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

public class Options  extends Activity implements LocationListener{
	//textboxes
	EditText locationText;
	
	//check boxes
	CheckBox oceanCheckBox;
	CheckBox waterfallCheckBox;
	CheckBox geologicalCheckBox;
	CheckBox historicalCheckBox;
	CheckBox dogCheckBox;
	// buttons
	Button submitButton;
	//dropdown
	private Spinner spinner;
	//For location
	LocationManager locationManager;
	String provider;
	
	private String[] miles;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// when the screen is first created, show the layout
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);
		Intent intent = getIntent();
		//String value = intent.getStringExtra("key"); //if it's a string you stored.

		final DatabaseHandler db = new DatabaseHandler(this);
		//textbox
		locationText = (EditText) findViewById(R.id.editText1);
		
		// checkboxes
		oceanCheckBox = (CheckBox) findViewById(R.id.checkBox1);
		waterfallCheckBox = (CheckBox) findViewById(R.id.checkBox2);
		geologicalCheckBox = (CheckBox) findViewById(R.id.checkBox3);
		historicalCheckBox = (CheckBox) findViewById(R.id.checkBox4);
		dogCheckBox = (CheckBox) findViewById(R.id.checkBox5);
	
		
		//dropdown stuff
		spinner = (Spinner) findViewById(R.id.spinner1);
		//spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View v, int position, long id) {
                // your code here
                 
                // Get selected row data to show on screen
                
                 
                Toast.makeText(
                        getApplicationContext(),"hello: " + parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }
 
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
 
        });
		
		
		// buttons
		submitButton = (Button) findViewById(R.id.button1);
		
		// Get the location manager
	    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    // Define the criteria for selecting a location provider
	    Criteria criteria = new Criteria();
	    provider = locationManager.getBestProvider(criteria, false);
	    Location location = locationManager.getLastKnownLocation(provider);

	    // Initialize the location fields
	    if (location != null) {
	      System.out.println("Provider " + provider + " has been selected.");
	      onLocationChanged(location);
	    } else {
	      locationText.setText("Location not available");
	    }
	  

		
		
		//Submitting
		submitButton.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	int oceanChecked = (oceanCheckBox.isChecked()) ? 1 : 0;
            	int waterfallChecked = (waterfallCheckBox.isChecked()) ? 1 : 0;
            	int geologicalChecked = (geologicalCheckBox.isChecked()) ? 1 : 0;
            	int historicalChecked = (historicalCheckBox.isChecked()) ? 1 : 0;
            	int dogChecked = (dogCheckBox.isChecked()) ? 1 : 0;
            	
            	// create query hike
            	Hike queryHike = new Hike(
            			null, null,
            			0, 0,
            			oceanChecked,
            			waterfallChecked,
            			geologicalChecked,
            			historicalChecked,
            			dogChecked,
            			null,null);
            	
            	List<Hike> hikeResults = db.queryHike(queryHike);
            	
            	System.out.println("Size of hike list returned by query: " + hikeResults.size());
            	GlobalDataContainer.setQueryResults(hikeResults);
            	
		        Intent myIntent = new Intent(Options.this, Results.class);
		        myIntent.putExtra("query_hike", new Hike(waterfallChecked, geologicalChecked, historicalChecked, dogChecked, oceanChecked)); //Optional parameters
		        Options.this.startActivity(myIntent);
            }
        });
		
	}
	
	 /* Request updates at startup */
	  @Override
	  protected void onResume() {
	    super.onResume();
	    locationManager.requestLocationUpdates(provider, 400, 1, this);
	  }

	  /* Remove the locationlistener updates when Activity is paused */
	  @Override
	  protected void onPause() {
	    super.onPause();
	    locationManager.removeUpdates(this);
	  }

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		int lat = (int) (location.getLatitude());
	    int lng = (int) (location.getLongitude());
	    locationText.setText(String.valueOf(lat) + " " +String.valueOf(lng));
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Disabled provider " + provider,
		        Toast.LENGTH_SHORT).show();	
	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(this, "Enabled new provider " + provider,
		        Toast.LENGTH_SHORT).show();	
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}
