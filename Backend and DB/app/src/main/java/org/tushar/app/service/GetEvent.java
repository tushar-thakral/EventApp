package org.tushar.app.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class GetEvent {
	
	private static long id;
	
	public GetEvent() {
		
	}

	public GetEvent(long id) {
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

			DBCollection collection = db.getCollection("events");

			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("id", getId());
			DBCursor cursor = collection.find(whereQuery);
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
			return jsonobj;
			
		} catch (MongoException e) {
			e.printStackTrace();
		}
		return null;

	}

}
