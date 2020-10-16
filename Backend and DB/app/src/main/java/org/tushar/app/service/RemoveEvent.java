package org.tushar.app.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class RemoveEvent {
	
	private static long id;
	
	public RemoveEvent() {
		
	}

	public RemoveEvent(long id) {
		this.id = id;
	}

	public static long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public static void main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("events");

			BasicDBObject document = new BasicDBObject();
			document.put("id", getId());
			collection.remove(document);

		} catch (MongoException e) {
			e.printStackTrace();
		}

	}

}
