package com.example.hikefinder;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Collections;

import java.util.ArrayList;
import android.app.ListActivity;

public class Results extends ListActivity
{
	// list view
	ListView resultsListView;
	
	// button
	Button submitButton;
	
	// declare class variables
	private ArrayList<Hike> hikeResults;
	private Runnable viewParts;
	private ItemAdapter m_adapter;
	private Hike queryHike;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results);
		
		
		Intent intent = getIntent();
		Bundle data = getIntent().getExtras();
		
		queryHike = (Hike) data.getParcelable("query_hike");
		
		//resultsListView = (ListView) findViewById(R.id.);
		resultsListView = getListView();
		submitButton = (Button) findViewById(R.id.submitButton);
		
		hikeResults = new ArrayList<Hike>(GlobalDataContainer.getQueryResults());
		
		for (Hike hike : hikeResults) {
			hike.setRating(rateHike(hike, queryHike));
		}
		
		Collections.sort(hikeResults, new HikeComparison());
		
		for (Hike hike : hikeResults) {
			System.out.println(hike.getName() + ": " + hike.getRating());
		}
		
		
		 m_adapter = new ItemAdapter(this, R.layout.list_item, hikeResults);
	        setListAdapter(m_adapter);	   
	        
		
		
	}
	
	@Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
	    Hike item = (Hike)getListAdapter().getItem(position);
	   GlobalDataContainer.setSelectedHike(item);
	   Intent myIntent = new Intent(Results.this, Hike_Description.class);
	    Results.this.startActivity(myIntent);
	    //Toast.makeText(this, item.getName() + " selected", Toast.LENGTH_LONG).show();
	  }
	
	private int rateHike(Hike hikeToRate, Hike queryHike) {
		int rating=0;
		
		if (queryHike.getGeological() != 0) {
			if (hikeToRate.getGeological() != 0)
				rating++;
		}
		
		if (queryHike.getHistorical() != 0) {
			if (hikeToRate.getHistorical() != 0)
				rating++;
		}
		
		if (queryHike.getOceanView() != 0) {
			if (hikeToRate.getOceanView() != 0)
				rating++;
		}
		
		if (queryHike.getWaterfall() != 0) {
			if (hikeToRate.getWaterfall() != 0)
				rating++;
		}
		
		if (queryHike.getDogFriendly() != 0) {
			if (hikeToRate.getDogFriendly() != 0)
				rating++;
		}
		return rating;
	}
	
	
}
