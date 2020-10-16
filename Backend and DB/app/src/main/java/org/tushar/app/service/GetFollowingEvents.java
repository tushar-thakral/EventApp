package org.tushar.app.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class GetFollowingEvents {
	
	private static long id;

	public GetFollowingEvents() {

	}

	public GetFollowingEvents(long id) {
		this.id = id;
	}

	public static long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static JSONArray main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("profiles");
			DBCollection collection2 = db.getCollection("events");

			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("id", getId());
			DBCursor cursor = collection.find(whereQuery);
			BasicDBObject obj = (BasicDBObject) cursor.next();
			ArrayList<Long> list = (ArrayList<Long>) obj.get("followingEvents");
			JSONArray jsonarray = new JSONArray();
			for ( int i = 0; i < list.size(); i++ ) {
				BasicDBObject whereQuery2 = new BasicDBObject();
				whereQuery2.put("id", list.get(i));
				DBCursor cursor2 = collection2.find(whereQuery2);
				BasicDBObject obj2 = (BasicDBObject) cursor2.next();
				JSONObject jsonobj = new JSONObject();	
				jsonobj.put("id", obj2.getLong("id"));
				jsonobj.put("clubId", obj2.getLong("clubId"));
				jsonobj.put("name", obj2.getString("name"));
				jsonobj.put("venue", obj2.getString("venue"));
				jsonobj.put("eventDate", obj2.getString("eventDate"));
				jsonobj.put("eventTime", obj2.getString("eventTime"));
				jsonobj.put("organiser", obj2.getString("organiser"));
				jsonobj.put("eventInfo", obj2.getString("eventInfo"));
				jsonobj.put("imageUrl", obj2.getString("imageUrl"));
				jsonarray.add(jsonobj);
			}
			
			return jsonarray;
			
		} catch (MongoException e) {
			e.printStackTrace();
		} 
		return null;

	}

}
