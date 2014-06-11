package com.example.hikefinder;

import java.util.List;

public class GlobalDataContainer
{
	private static Hike selectedHike;
	private static List<Hike> queryResults;
	private static List<Hike> completedResults;
	
	//static DatabaseHandler db;
	
	GlobalDataContainer(){
		selectedHike = null;
		queryResults = null;
		completedResults = null;
	}
	
	public static void setSelectedHike(Hike newSelectedHike){
		selectedHike = newSelectedHike;
	}
	
	public static void setQueryResults(List<Hike> newQueryResults){
		queryResults = newQueryResults;
	}
	
	public static void setCompletedResults(List<Hike> newCompletedResults){
		completedResults = newCompletedResults;
	}
	
/*	public static void setDBHandler(DatabaseHandler newDB){
		db = newDB;
	}*/
	
	public static Hike getSelectedHike(){
		if(selectedHike != null)
			return selectedHike;
		return null;
	}
	
	public static List<Hike> getQueryResults(){
		if(queryResults != null)
			return queryResults;
		return null;
	}
	
	public static List<Hike> getCompletedResults(){
		if(completedResults != null)
			return completedResults;
		return null;
	}

}
