package org.tushar.app.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.tushar.app.model.Profile;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class AddProfile {
	
	private static long id;
	private static String firstName;
	private static String lastName;
	private static String collegeName;
	private static long collegeId;
	private static long phoneNumber;
	private static String email;
	private static ArrayList<String> interests; 
	private static ArrayList<Long> followingEvents;
	private static String dateCreated;
	private static String imageUrl;
	private static boolean isLoggedIn;
	private static boolean isAdmin;
	private static long adminOfClub;
	
	public AddProfile() {
		
	}
	
	public AddProfile(Profile profile) {
		this.id = profile.getId();
		this.firstName = profile.getFirstName();
		this.lastName = profile.getLastName();
		this.collegeName = profile.getCollegeName();
		this.phoneNumber = profile.getPhoneNumber();
		this.email = profile.getEmail();
		this.dateCreated = profile.getCreated();
		this.imageUrl = profile.getImageUrl();
	}

	public static long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public static long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public static long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static ArrayList<String> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}
	
	public static ArrayList<Long> getFollowingEvents() {
		return followingEvents;
	}

	public void setFollowingEvents(ArrayList<Long> followingEvents) {
		this.followingEvents = followingEvents;
	}

	public static String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public static String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public static boolean main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("profiles");

			BasicDBObject document = new BasicDBObject();
			document.put("id", getId());
			document.put("firstName", getFirstName());
			document.put("lastName", getLastName());
			document.put("collegeName", getCollegeName());
			document.put("phoneNumber", getPhoneNumber());
			document.put("email", getEmail());
			//document.put("dateCreated", getDateCreated());
			document.put("imageUrl", getImageUrl());
			document.put("isLoggedIn", true);
			document.put("isAdmin", false);
			document.put("adminOfClub", -1);
			document.put("followingEvents", getFollowingEvents());

			collection.insert(document);

			/*BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("id", getId());
			DBCursor cursor = collection.find(whereQuery);
			BasicDBObject obj = (BasicDBObject) cursor.next();
			JSONObject jsonobj = new JSONObject();
			//BasicDBList name = (BasicDBList) obj.get("Name");
			jsonobj.put("id", obj.getLong("id"));
			jsonobj.put("firstName", obj.getString("firstName"));
			jsonobj.put("lastName", obj.getString("lastName"));
			jsonobj.put("collegeName", obj.getString("collegeName"));
			jsonobj.put("phoneNumber", obj.getLong("phoneNumber"));
			jsonobj.put("email", obj.getString("email"));
			//jsonobj.put("dateCreated", obj.getString("dateCreated"));
			jsonobj.put("imageUrl", obj.getString("imageUrl"));
			jsonobj.put("isLoggedIn", obj.getBoolean("isLoggedIn"));
			jsonobj.put("isAdmin", obj.getBoolean("isAdmin"));
			jsonobj.put("adminOfClub", obj.getLong("adminOfClub"));*/
			//jsonobj.put("followingEvents", obj.get("followingEvents"));
			return true;

			//collection.drop();			
			//return receivedProfile.get(0);
			//collection.remove(new BasicDBObject());
			
		} catch (MongoException e) {
			e.printStackTrace();
		} 
		return false;
	}

}
