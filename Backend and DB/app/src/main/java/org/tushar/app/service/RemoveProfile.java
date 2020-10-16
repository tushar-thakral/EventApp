package org.tushar.app.service;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Java MongoDB : Delete document
 * 
 * @author mkyong
 */

public class RemoveProfile {
	
	private static long id;
	
	public RemoveProfile() {
		
	}

	public RemoveProfile(long id) {
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

			DBCollection collection = db.getCollection("profiles");

			BasicDBObject document = new BasicDBObject();
			document.put("id", getId());
			collection.remove(document);

		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}