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

public class UpdateProfile {
	
	private static long id;
	private static String firstName;
	private static String lastName;
	private static String collegeName;
	private static long collegeId;
	private static long phoneNumber;
	private static String email;
	private static ArrayList<String> interests; 
	private static String dateCreated;
	private static String imageUrl;
	
	public UpdateProfile() {
		
	}
	
	public UpdateProfile(Profile profile) {
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

	public static String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public static void removeAllDocuments(DBCollection collection) {
		collection.remove(new BasicDBObject());
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

			BasicDBObject updateDocument = new BasicDBObject();
			updateDocument.append("$set", new BasicDBObject().append("imageUrl", getImageUrl()));
		
			BasicDBObject searchQuery2 = new BasicDBObject().append("id", getId());

			collection.update(searchQuery2, updateDocument);
			
			/*BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("id", getId());
			DBCursor cursor = collection.find(whereQuery);
			BasicDBObject obj = (BasicDBObject) cursor.next();
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("id", obj.getLong("id"));
			jsonobj.put("firstName", obj.getString("firstName"));
			jsonobj.put("lastName", obj.getString("lastName"));
			jsonobj.put("collegeName", obj.getString("collegeName"));
			jsonobj.put("phoneNumber", obj.getLong("phoneNumber"));
			jsonobj.put("email", obj.getString("email"));
			jsonobj.put("dateCreated", obj.getString("dateCreated"));
			jsonobj.put("imageUrl", obj.getString("imageUrl"));*/
			return true;

		} catch (MongoException e) {
			e.printStackTrace();
		} 
		return false;
	}
}