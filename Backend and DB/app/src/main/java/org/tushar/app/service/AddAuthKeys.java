package org.tushar.app.service;

import org.json.simple.JSONObject;
import org.tushar.app.model.Authentication;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class AddAuthKeys {
	
	private static String email;
	private static String password;

	public AddAuthKeys() {

	}

	public AddAuthKeys(Authentication authentication) {
		this.email = authentication.getEmail();
		this.password = authentication.getPassword();
	}
	
	public static String getEmail() {
		return email;
	}

	public static String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static boolean main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("authentication");

			BasicDBObject document = new BasicDBObject();
			document.put("email", getEmail());
			document.put("password", getPassword());
			
			collection.insert(document);
			
			return true;
			
		} catch (MongoException e) {
			e.printStackTrace();
		} 
		return false;
	}

}
