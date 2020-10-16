package org.tushar.app.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class GetAllClubs {
	
	public GetAllClubs() {
		
	}
	
	public static JSONArray main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("clubs");

			DBCursor cursor = collection.find();
			JSONArray jsonarray = new JSONArray();
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				JSONObject jsonobj = new JSONObject();
				jsonobj.put("id", obj.getLong("id"));
				jsonobj.put("collegeId", obj.getLong("collegeId"));
				jsonobj.put("name", obj.getString("name"));
				jsonobj.put("info", obj.getString("info"));
				jsonobj.put("admin", obj.getString("admin"));
				jsonobj.put("imageUrl", obj.getString("imageUrl"));
				jsonarray.add(jsonobj);
			}
			
			return jsonarray;

		} catch (MongoException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
