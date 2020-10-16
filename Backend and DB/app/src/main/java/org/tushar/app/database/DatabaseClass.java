package org.tushar.app.database;

import java.util.HashMap;
import java.util.Map;

import org.tushar.app.model.Club;
import org.tushar.app.model.Event;
import org.tushar.app.model.Profile;

public class DatabaseClass {

	private static Map<Long, Profile> profiles = new HashMap<>();
	private static Map<Long, Club> clubs = new HashMap<>();
	private static Map<Long, Event> events = new HashMap<>();

	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}	
	
	public static Map<Long, Club> getClubs() {
		return clubs;
	}		
	
	public static Map<Long, Event> getEvents() {
		return events;
	}
	
}
