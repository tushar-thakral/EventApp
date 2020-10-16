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

public class GetAllEvents {
	
	public GetAllEvents() {
		
	}
	
	public static JSONArray main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("events");

			DBCursor cursor = collection.find();
			JSONArray jsonarray = new JSONArray();
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				JSONObject jsonobj = new JSONObject();
				jsonobj.put("id", obj.getLong("id"));
				jsonobj.put("clubId", obj.getLong("clubId"));
				jsonobj.put("name", obj.getString("name"));
				jsonobj.put("venue", obj.getString("venue"));
				jsonobj.put("eventDate", obj.getString("eventDate"));
				jsonobj.put("eventTime", obj.getString("eventTime"));
				jsonobj.put("organiser", obj.getString("organiser"));
				jsonobj.put("eventInfo", obj.getString("eventInfo"));
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
