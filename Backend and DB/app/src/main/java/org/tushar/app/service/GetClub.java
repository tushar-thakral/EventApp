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

public class GetClub {

	private static long id;
	
	public GetClub() {
		
	}

	public GetClub(long id) {
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

			DBCollection collection = db.getCollection("clubs");

			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("id", getId());
			DBCursor cursor = collection.find(whereQuery);
			BasicDBObject obj = (BasicDBObject) cursor.next();
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("id", obj.getLong("id"));
			jsonobj.put("collegeId", obj.getLong("collegeId"));
			jsonobj.put("name", obj.getString("name"));
			jsonobj.put("info", obj.getString("info"));
			jsonobj.put("admin", obj.getString("admin"));
			jsonobj.put("imageUrl", obj.getString("imageUrl"));
			return jsonobj;
			
		} catch (MongoException e) {
			e.printStackTrace();
		}
		return null;

	}

}
