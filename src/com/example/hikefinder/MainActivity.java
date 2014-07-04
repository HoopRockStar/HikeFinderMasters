package com.example.hikefinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	Button clickButton;
	Button clickButton2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DatabaseHandler db = new DatabaseHandler(this);
		
		//db.onUpgrade(db, oldVersion, newVersion)

      // add Hikes
     // db.addHike(new Hike("Loch Lomond", "The Loch Lomond Recreation Area offers a unique hiking experience, boasting a 175-acre lake surrounded by redwood forest. The area is dog-friendly and features a variety of recreation activities besides hiking.", 4.8, 800, 0, 1, 1, 1, 0, "100 Loch Lomond Way, Felton, CA 95018", "Loch Trail\nHighland Trail (at Deer Flat Picnic Area)\nTake the paved road back to headquarters"));
      //db.addHike(new Hike("Wilder Ranch, Baldwin Loop", "If you love hikes with ocean views, this is the hike for you! The hike begins across the street from Four Mile Beach, a beach famous for its surfers. From this starting point, climb up approximately 800 feet, enjoying spectacular views of the Monterey Bay the entire way. At the top of the hill, take the Enchanted Loop trail through some lovely, cool redwoods until you encounter the Baldwin Loop trail again. Then, wind back down again, enjoying the ocean vistas.", 6, 800, 0, 0, 0, 0, 1, "Highway 1, Santa Cruz; near 3810 Coast Rd Santa Cruz, CA 95060", "Baldwin Loop Trail\nEnchanted Forest Trail\nBaldwin Loop Trail"));
      //db.addHike(new Hike("Berry Creek Falls Hike", "This beautiful hike features three waterfalls and a variety of terrain from old-growth redwoods to sand hills. It is one of the must-experience hikes in this region!", 10.2, 1500, 1, 1, 0, 0, 0, "Big Basin State Park Highway 9", "Sunset Trail\nBerry Creek Trail\nSkyline-to-the-Sea"));
      //db.addHike(new Hike("Purisima Creek Hike", "This lovely hike through the mostly second-generation redwoods, also features a variety of plant and tree species, a flowing creek and views of Half Moon Bay. This place is beautiful and somewhat off the beaten path.", 7, 2000, 0, 0, 0, 0, 1, "Higgins Canyon Rd, Half Moon Bay, CA 94019", "Purisima Creek Trail\nHarkins Ridge Trail\nCraig Britton Trail\nPurisima Creek Trail"));
      
      db.getHikesCount();
      //db.getAllHikes();
      //db.queryHike(new Hike(null, null, 0, 0, 0, 1, 0, 0, 0, null));
		
		// to make the button do stuff
		clickButton = (Button) findViewById(R.id.button1);
		clickButton2 = (Button) findViewById(R.id.button2);
		// create listner for button clicks
		clickButton.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
	        	Intent myIntent = new Intent(MainActivity.this, Select.class);
	        	//myIntent.putExtra("key", value); //Optional parameters
	        	MainActivity.this.startActivity(myIntent);
            }
        });
		
		clickButton2.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
	        	Intent myIntent = new Intent(MainActivity.this, Profile.class);
	        	//myIntent.putExtra("key", value); //Optional parameters
	        	MainActivity.this.startActivity(myIntent);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}

