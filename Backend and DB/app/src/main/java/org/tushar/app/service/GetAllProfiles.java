package org.tushar.app.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class GetAllProfiles {

	public GetAllProfiles() {

	}

	public static JSONArray main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("profiles");

			DBCursor cursor = collection.find();
			JSONArray jsonarray = new JSONArray();
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				JSONObject jsonobj = new JSONObject();
				jsonobj.put("id", obj.getLong("id"));
				jsonobj.put("firstName", obj.getString("firstName"));
				jsonobj.put("lastName", obj.getString("lastName"));
				jsonobj.put("collegeName", obj.getString("collegeName"));
				jsonobj.put("phoneNumber", obj.getLong("phoneNumber"));
				jsonobj.put("email", obj.getString("email"));
				jsonobj.put("dateCreated", obj.getString("dateCreated"));
				jsonobj.put("imageUrl", obj.getString("imageUrl"));
				jsonobj.put("isLoggedIn", obj.getBoolean("isLoggedIn"));
				jsonobj.put("isAdmin", obj.getBoolean("isAdmin"));
				jsonobj.put("adminOfClub", obj.getLong("adminOfClub"));
				jsonobj.put("followingEvents", obj.get("followingEvents"));
				jsonarray.add(jsonobj);
			}
			
			return jsonarray;

		} catch (MongoException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
