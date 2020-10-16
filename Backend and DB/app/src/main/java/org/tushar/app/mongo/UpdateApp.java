package org.tushar.app.mongo;

import java.net.UnknownHostException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Java MongoDB update document
 * 
 * @author mkyong
 * 
 */

public class UpdateApp {

	public static void printAllDocuments(DBCollection collection) {
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}

	public static void removeAllDocuments(DBCollection collection) {
		collection.remove(new BasicDBObject());
	}

	public static void insertDummyDocuments(DBCollection collection) {
		BasicDBObject document = new BasicDBObject();
		document.put("hosting", "hostA");
		document.put("type", "vps");
		document.put("clients", 1000);

		BasicDBObject document2 = new BasicDBObject();
		document2.put("hosting", "hostB");
		document2.put("type", "dedicated server");
		document2.put("clients", 100);

		BasicDBObject document3 = new BasicDBObject();
		document3.put("hosting", "hostC");
		document3.put("type", "vps");
		document3.put("clients", 900);

		collection.insert(document);
		collection.insert(document2);
		collection.insert(document3);
	}

	public static void main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("yourdb");

			// get a single collection
			DBCollection collection = db.getCollection("dummyColl");

			System.out.println("Testing 1...no $set");

			insertDummyDocuments(collection);

			// find hosting = hostB, and update the clients to 110
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("clients", 110);

			BasicDBObject searchQuery = new BasicDBObject().append("hosting", "hostB");

			collection.update(searchQuery, newDocument);

			printAllDocuments(collection);
			removeAllDocuments(collection);

			System.out.println("\nTesting 1...with $set");

			insertDummyDocuments(collection);

			BasicDBObject updateDocument = new BasicDBObject();
			updateDocument.append("$set", new BasicDBObject().append("clients", 110));

			BasicDBObject searchQuery2 = new BasicDBObject().append("hosting", "hostB");

			collection.update(searchQuery2, updateDocument);

			printAllDocuments(collection);
			removeAllDocuments(collection);

		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
}