package com.example.hikefinder;

import android.os.Parcel;
import android.os.Parcelable;

public class Hike implements Parcelable
{
	int id;
	String name;
	String description;
	double distance;
	int elevationChange;
	int waterfall;
	int geological;
	int historical;
	int dogFriendly;
	int oceanView;
	String location;
	String trails;
	
	int completed;
	int rating;
	String review;
	String notes;
	
	
	Hike()
	{
		id = -1;
		name = "default";
		description = "default";
		distance = 0;
		elevationChange = 0;
		waterfall = 0;
		geological = 0;
		historical = 0;
		dogFriendly = 0;
		oceanView = 0;
		location = "default";
		trails = "default";

		completed = 0;
		rating = 0;
		review = "default";
		notes = "default";
	}
	
	Hike(	String new_name, String new_description, double new_distance, int new_elevationChange, int new_waterfall,
			int new_geological, int new_historical, int new_dogFriendly, int new_oceanView, String new_location, String new_trails)
	{
		name = new_name;
		description = new_description;
		distance = new_distance;
		elevationChange = new_elevationChange;
		waterfall = new_waterfall;
		geological = new_geological;
		historical = new_historical;
		dogFriendly = new_dogFriendly;
		oceanView = new_oceanView;
		location = new_location;
		trails = new_trails;
		
		completed = 0;
		rating = 0;
		review = "default";
		notes = "default";
	}
	
	//used for query hike comparison
	Hike( int new_waterfall,int new_geological, int new_historical, int new_dogFriendly, int new_oceanView )
	{
		name = "";
		description = "";
		distance = 0;
		elevationChange = 0;
		waterfall = new_waterfall;
		geological = new_geological;
		historical = new_historical;
		dogFriendly = new_dogFriendly;
		oceanView = new_oceanView;
		location = "";
		trails = "";
		
		completed = 0;
		rating = 0;
		review = "default";
		notes = "default";
	}
	
	Hike( int new_id, String new_name, String new_description, double new_distance, int new_elevationChange, int new_waterfall,
			int new_geological, int new_historical, int new_dogFriendly, int new_oceanView, String new_location, String new_trails,
			int new_completed, int new_rating, String new_review, String new_notes)
	{
		id = new_id;
		name = new_name;
		description = new_description;
		distance = new_distance;
		elevationChange = new_elevationChange;
		waterfall = new_waterfall;
		geological = new_geological;
		historical = new_historical;
		dogFriendly = new_dogFriendly;
		oceanView = new_oceanView;
		location = new_location;
		trails = new_trails;
		
		completed = new_completed;
		rating = new_rating;
		review = new_review;
		notes = new_notes;
	}
	
	public Hike( Parcel in ) 
	{
        readFromParcel( in );
    }
	
	// getters
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
	public double getDistance() { return this.distance; }
	public int getElevationChange() { return this.elevationChange; }
	public int getWaterfall() { return this.waterfall; }
	public int getGeological() { return this.geological; }
	public int getHistorical() { return this.historical; }
	public int getDogFriendly() { return this.dogFriendly; }
	public int getOceanView() { return this.oceanView; }
	public String getLocation() { return this.location; }
	public String getTrails() { return this.trails; }
	public int getCompleted() { return this.completed; }
	public int getRating() { return this.rating; }
	public String getReview() { return this.review; }
	public String getNotes() { return this.notes; }
	
	// setters
	public void setId(int newId) { this.id = newId; }
	public void setName(String newName) { this.name = newName; }
	public void setDescription(String newDescripion) { this.description = newDescripion; }
	public void setDistance(double newDistance) { this.distance = newDistance; }
	public void setElevationChange(int newElevationChange) { this.elevationChange = newElevationChange; }
	public void setWaterfall(int newWaterfall) { this.waterfall = newWaterfall; }
	public void setGeological(int newGeological) { this.geological = newGeological; }
	public void setHistorical(int newHistorical) { this.historical = newHistorical; }
	public void setDogFriendly(int newdogFriendly) { this.dogFriendly = newdogFriendly; }
	public void setOveanView(int newOceanView) { this.oceanView = newOceanView; }
	public void setLocation(String newLocation) { this.location = newLocation; }
	public void setTrails(String newTrails) { this.trails = newTrails; }
	public void setCompleted(int newCompleted) { this.completed = newCompleted; }
	public void setRating(int newRating) { this.rating = newRating; }
	public void setReview(String newReview) { this.review = newReview; }
	public void setNotes(String newNotes) { this.notes = newNotes; }
	
	public String getFeaturesString(){
		String features = "";
		
		if (this.getWaterfall() == 1) {
			features += "waterfall, ";
		}
		
		if (this.getOceanView() == 1) {
			features += "ocean view, ";
		}
		
		if (this.getGeological() == 1) {
			features += "geological, ";
		}
		
		if (this.getHistorical() == 1) {
			features += "historical, ";
		}
		
		if (this.getDogFriendly() == 1) {
			features += "dog-friendly, ";
		}
		
		return features.substring(0, features.length()-2);
	}
	
	public String toString()
	{
		String hikeString = "Hike Name:" + this.name;		
		return hikeString;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Hike createFromParcel(Parcel in ) {
            return new Hike( in );
        }

        public Hike[] newArray(int size) {
            return new Hike[size];
        }
    };


	@Override
	public void writeToParcel(Parcel destination, int flags) {
		destination.writeInt(this.waterfall);
		destination.writeInt(this.geological);
		destination.writeInt(this.historical);
		destination.writeInt(this.dogFriendly);
		destination.writeInt(this.oceanView);
		
	}
	
	private void readFromParcel(Parcel in ) {

        this.waterfall = in.readInt();
        this.geological = in.readInt();
        this.historical = in.readInt();
        this.dogFriendly = in.readInt();
        this.oceanView = in.readInt();
        
    }
}
