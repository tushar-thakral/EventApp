package org.tushar.app.service;

import org.json.simple.JSONObject;
import org.tushar.app.model.Authentication;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class AuthenticateUser {

	private static String email;
	private static String password;

	public AuthenticateUser() {

	}

	public AuthenticateUser(Authentication authentication) {
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

			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("email", getEmail());
			DBCursor cursor = collection.find(whereQuery);
			BasicDBObject obj = (BasicDBObject) cursor.next();
			if(cursor != null) {
				if( obj.getString("password").equals(getPassword()) ) {
					return true;
				}
			}
			
			return false;
			
		} catch (MongoException e) {
			e.printStackTrace();
		} 
		return false;
	}

}
