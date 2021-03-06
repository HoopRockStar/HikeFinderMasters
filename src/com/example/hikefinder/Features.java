package com.example.hikefinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
 
public class Features extends Activity {
 
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.features);
 
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
    }
 
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("Location and Accessibility");
        listDataHeader.add("Difficulty");
        listDataHeader.add("Features");
 
        // Adding child data
        List<String> loca_access = new ArrayList<String>();
        loca_access.add("Near");
        loca_access.add("Free Parking");
        loca_access.add("Food Nearby");
 
        List<String> difficulty = new ArrayList<String>();
        difficulty.add("Distance");
        difficulty.add("Elevation");
        difficulty.add("Calories");
        difficulty.add("No Steep Hills");
 
        List<String> features = new ArrayList<String>();
        features.add("Ocean View");
        features.add("Waterfall");
        features.add("Geological Interest");
        features.add("Historical Interest");
        features.add("Loop");
        features.add("No Bike Traffic");
        features.add("Dog-friendly");
 
        listDataChild.put(listDataHeader.get(0), loca_access); // Header, Child data
        listDataChild.put(listDataHeader.get(1), difficulty);
        listDataChild.put(listDataHeader.get(2), features);
    }
}