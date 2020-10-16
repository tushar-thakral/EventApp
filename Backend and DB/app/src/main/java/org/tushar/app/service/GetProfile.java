package org.tushar.app.service;

import org.json.simple.JSONObject;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class GetProfile {

	private static long id;

	public GetProfile() {

	}

	public GetProfile(long id) {
		this.id = id;
	}

	public static long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static JSONObject main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("profiles");

			BasicDBObject whereQuery = new BasicDBObject();
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
			jsonobj.put("adminOfClub", obj.getLong("adminOfClub"));
			//jsonobj.put("followingEvents", obj.get("followingEvents"));
			return jsonobj;
			
		} catch (MongoException e) {
			e.printStackTrace();
		} 
		return null;

	}

}
