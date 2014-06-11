package com.example.hikefinder;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper 
{
  // Database Version
   private static final int DATABASE_VERSION = 1;
   // Database Name
   private static final String DATABASE_NAME = "HikesDB_v2";

   public DatabaseHandler(Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);  
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
   	Log.d("CREATE DB", "Creating HikeDB");
      // SQL statement to create book table
      String CREATE_HIKE_TABLE = "CREATE TABLE " + HIKES_TABLE +" ( " +
               "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
               "name TEXT, "+
               "description TEXT, "+
               "distance INTEGER, "+
               "elevationChange INTEGER, "+
               "waterfall INTEGER, "+
               "geological INTEGER, "+
               "historical INTEGER, "+
               "dogFriendly INTEGER, "+
               "oceanView INTEGER, "+
               "location TEXT, "+
               "trails TEXT, "+
               
               "completed INTEGER, "+
               "rating INTEGER, "+
               "review TEXT, "+
               "notes TEXT )";

      // create hikesDB table
      db.execSQL(CREATE_HIKE_TABLE);
      
      this.addHike(new Hike("Loch Lomond", "The Loch Lomond Recreation Area offers a unique hiking experience, boasting a 175-acre lake surrounded by redwood forest. The area is dog-friendly and features a variety of recreation activities besides hiking.", 4.8, 800, 0, 1, 1, 1, 0, "100 Loch Lomond Way, Felton, CA 95018", "Loch Trail\nHighland Trail (at Deer Flat Picnic Area)\nTake the paved road back to headquarters"));
      this.addHike(new Hike("Wilder Ranch, Baldwin Loop", "If you love hikes with ocean views, this is the hike for you! The hike begins across the street from Four Mile Beach, a beach famous for its surfers. From this starting point, climb up approximately 800 feet, enjoying spectacular views of the Monterey Bay the entire way. At the top of the hill, take the Enchanted Loop trail through some lovely, cool redwoods until you encounter the Baldwin Loop trail again. Then, wind back down again, enjoying the ocean vistas.", 6, 800, 0, 0, 0, 0, 1, "Highway 1, Santa Cruz; near 3810 Coast Rd Santa Cruz, CA 95060", "Baldwin Loop Trail\nEnchanted Forest Trail\nBaldwin Loop Trail"));
      this.addHike(new Hike("Berry Creek Falls Hike", "This beautiful hike features three waterfalls and a variety of terrain from old-growth redwoods to sand hills. It is one of the must-experience hikes in this region!", 10.2, 1500, 1, 1, 0, 0, 0, "Big Basin State Park Highway 9", "Sunset Trail\nBerry Creek Trail\nSkyline-to-the-Sea"));
      this.addHike(new Hike("Purisima Creek Hike", "This lovely hike through the mostly second-generation redwoods, also features a variety of plant and tree species, a flowing creek and views of Half Moon Bay. This place is beautiful and somewhat off the beaten path.", 7, 2000, 0, 0, 0, 0, 1, "Higgins Canyon Rd, Half Moon Bay, CA 94019", "Purisima Creek Trail\nHarkins Ridge Trail\nCraig Britton Trail\nPurisima Creek Trail"));
      
      //this.getHikesCount();
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // Drop older table if existed
       db.execSQL("DROP TABLE IF EXISTS '" + HIKES_TABLE + "'");

       // create books table
       this.onCreate(db);
   }
   
   //======================================================================================

	static final String HIKES_TABLE = "hikes";

	static final String ID = "id";
	static final String NAME = "name";
	static final String DESC = "description";
	static final String DIST = "distance";
	static final String ELEVCH = "elevationChange";
	static final String WTRFL = "waterfall";
	static final String GEO = "geological";
	static final String HIST = "historical";
	static final String DOG = "dogFriendly";
	static final String OCNVW = "oceanView";
	static final String LOC = "location";
	static final String TRAILS = "trails";
	               
	static final String COMP = "completed";
	static final String RATE = "rating";
	static final String REVW = "review";
	static final String NOTES = "notes";
   
   
   // Adding new Hike
   public void addHike(Hike newHike) {
   	Log.d("ADD_HIKE", newHike.toString()); 
   	
      SQLiteDatabase db = this.getWritableDatabase();
      
      ContentValues values = new ContentValues();
      values.put(NAME, newHike.getName());
      values.put(DESC, newHike.getDescription());
      values.put(DIST, newHike.getDistance());
      values.put(ELEVCH, newHike.getElevationChange());
      values.put(WTRFL, newHike.getWaterfall());
      values.put(GEO, newHike.getGeological());
      values.put(HIST, newHike.getHistorical());
      values.put(DOG, newHike.getDogFriendly());
      values.put(OCNVW, newHike.getOceanView());
      values.put(LOC, newHike.getLocation());
      values.put(TRAILS, newHike.getTrails());
      
      values.put(COMP, newHike.getCompleted());
      values.put(RATE, newHike.getRating());
      values.put(REVW, newHike.getReview());
      values.put(NOTES, newHike.getNotes());
   
      // Inserting Row
      db.insert(HIKES_TABLE, null, values);
      db.close(); // Closing database connection
   }
   
   private List<Hike> createResultsList(Cursor cursor)
   {
   	List<Hike> hikes = new LinkedList<Hike>();
   	
		Hike hike = null;
		if (cursor.moveToFirst()) {
			do {
				hike = new Hike();
				hike.setId(cursor.getInt(0));
				hike.setName(cursor.getString(1));
				hike.setDescription(cursor.getString(2));
				hike.setDistance(cursor.getDouble(3));
				hike.setElevationChange(cursor.getInt(4));
				hike.setWaterfall(cursor.getInt(5));
				hike.setGeological(cursor.getInt(6));
				hike.setHistorical(cursor.getInt(7));
				hike.setDogFriendly(cursor.getInt(8));
				hike.setOveanView(cursor.getInt(9));
				hike.setLocation(cursor.getString(10));
				hike.setTrails(cursor.getString(11));
				hike.setCompleted(cursor.getInt(12));
				hike.setRating(cursor.getInt(13));
				hike.setReview(cursor.getString(14));
				hike.setNotes(cursor.getString(15));
			
			   // Add hike to hikes
				hikes.add(hike);
			} while (cursor.moveToNext());
		}
		cursor.close();
		return hikes;
   }
 
   // Getting single Hike
   public List<Hike> queryHike(Hike queryHike) {
   	int columnArgNumber = 0;
   	String whereClause = "";
   	
   	List<Hike> hikes;
   	
   	SQLiteDatabase db=this.getReadableDatabase();
   	
   	// create where clause for sql query
   	if(queryHike.getWaterfall() == 1)
   	{
   		whereClause += WTRFL + "=? OR ";
   		columnArgNumber++;
   	}
   	if(queryHike.getGeological() == 1)
   	{
   		whereClause += GEO + "=? OR ";
   		columnArgNumber++;
   	}
   	if(queryHike.getHistorical() == 1)
   	{
   		whereClause += HIST + "=? OR ";
   		columnArgNumber++;
   	}
   	if(queryHike.getDogFriendly() == 1)
   	{
   		whereClause += DOG + "=? OR ";
   		columnArgNumber++;
   	}
   	if(queryHike.getOceanView() == 1)
   	{
   		whereClause += OCNVW + "=? OR ";
   		columnArgNumber++;
   	}
   	// remove last " OR " from string
   	whereClause = whereClause.substring(0, whereClause.length() - 4);
   	
   	// create array of 1's
      String [] whereArgs = new String[columnArgNumber];
      java.util.Arrays.fill(whereArgs,"1");
      
      // execute query
      Cursor cursor=db.query(HIKES_TABLE, null, whereClause, whereArgs, null, null, null);

      hikes = createResultsList(cursor);
      GlobalDataContainer.setQueryResults(hikes);
      
      Log.d("getHikeResults()", hikes.toString());
      
      return hikes;
   }
   
 
   
   // Getting single Hike
   public List<Hike> queryCompleted() {
   	//int columnArgNumber = 0;
   	String whereClause = "";
   	
   	List<Hike> hikes;
   	
   	SQLiteDatabase db=this.getReadableDatabase();
   	
   	// create where clause for sql query
   	whereClause = COMP + "=?";
   	
   	// create array of 1's
      String [] whereArgs = new String[1];
      java.util.Arrays.fill(whereArgs,"1");
      
      // execute query
      Cursor cursor=db.query(HIKES_TABLE, null, whereClause, whereArgs, null, null, null);

      hikes = createResultsList(cursor);
      //GlobalDataContainer.setQueryResults(hikes);
      
      Log.d("getCompletedHikes()", hikes.toString());
      
      return hikes;
   }
   
   // Getting list of completed hikes
   public List<Hike> getCompletedHikes() {
   	String whereClause = "COMP = ?";
   	List<Hike> hikes;
   	
   	SQLiteDatabase db=this.getReadableDatabase();
   	
   	// create array of 1's
      String [] whereArgs = new String[]{"1"};
      
      // execute query
      //Cursor cursor=db.query(HIKES_TABLE, null, whereClause, whereArgs, null, null, null);
      Cursor cursor=db.rawQuery("SELECT * FROM " + HIKES_TABLE + " WHERE " + COMP + " = 1", null);

      hikes = createResultsList(cursor);
      GlobalDataContainer.setCompletedResults(hikes);
      
      Log.d("getHikeResults()", hikes.toString());
      
      return hikes;
   }
 
   // Getting All Hike
   public List<Hike> getAllHikes() {
   	List<Hike> hikes;
      
		// 1. build the query
		String query = "SELECT * FROM " + HIKES_TABLE;
		
		// 2. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		
		// 3. go over each row, build book and add it to list
		hikes = createResultsList(cursor);

      Log.d("getAllHikes()", hikes.toString());

      // return books
      return hikes;
   }
 
   // Getting Hike Count
   public int getHikesCount() {
   	int count = 0;
		String countQuery = "SELECT * FROM " + HIKES_TABLE;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		count = cursor.getCount();
		cursor.close();
		
      Log.d("getHikesCount()", "There are " + count + "hikes in the DB.");
      
		// return count
		return count;
   }
   
   // Updating single Hike
   public int updateHike(Hike newHike) {
   	Log.d("UPDATE_HIKE_DB", newHike.toString());
   	
   	// 1. get reference to writable DB
      SQLiteDatabase db = this.getWritableDatabase();
   
      // 2. create ContentValues to add key "column"/value
      ContentValues values = new ContentValues();
      values.put(ID, newHike.getId());
      values.put(NAME, newHike.getName());
      values.put(DESC, newHike.getDescription());
      values.put(DIST, newHike.getDistance());
      values.put(ELEVCH, newHike.getElevationChange());
      values.put(WTRFL, newHike.getWaterfall());
      values.put(GEO, newHike.getGeological());
      values.put(HIST, newHike.getHistorical());
      values.put(DOG, newHike.getDogFriendly());
      values.put(OCNVW, newHike.getOceanView());
      values.put(LOC, newHike.getLocation());
      values.put(TRAILS, newHike.getTrails());
      
      values.put(COMP, newHike.getCompleted());
      values.put(RATE, newHike.getRating());
      values.put(REVW, newHike.getReview());
      values.put(NOTES, newHike.getNotes());
   
      // 3. updating row
      int i = db.update(HIKES_TABLE, //table
              values, // column/value
              NAME+" = ?", // selections
              new String[] { String.valueOf(newHike.getName()) }); //selection args
   
      // 4. close
      db.close();
   
      return i;
   }
 
   // Deleting single Hike
   public void deleteHike(Hike delHike) {
      SQLiteDatabase db = this.getWritableDatabase();
      db.delete(HIKES_TABLE, ID + " = ?",
              new String[] { String.valueOf(delHike.getId()) });
      db.close();
   }
   
   // delete Hikes table
   public void deleteHikesTable() {
      SQLiteDatabase db = this.getWritableDatabase();
      db.delete(HIKES_TABLE, null, null);
   }
}
