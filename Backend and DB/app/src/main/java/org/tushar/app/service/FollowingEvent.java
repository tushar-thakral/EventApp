package org.tushar.app.service;

import org.tushar.app.model.FollowEvent;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class FollowingEvent {

	private static long profileId;
	private static long eventId;

	public FollowingEvent() {

	}

	public FollowingEvent(FollowEvent followEvent) {
		this.profileId = followEvent.getProfileId();
		this.eventId = followEvent.getEventId();
	}
	
	public static long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public static long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	
	public static boolean main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("profiles");
			
			BasicDBObject listItem = new BasicDBObject("followingEvents", getEventId());
			BasicDBObject updateQuery = new BasicDBObject("$push", listItem);
			
			BasicDBObject searchQuery = new BasicDBObject().append("id", getProfileId());

			collection.update(searchQuery, updateQuery);
			/*BasicDBObject updateDocument = new BasicDBObject();
			updateDocument.append("$set", new BasicDBObject().append("imageUrl", getImageUrl()));*/
			
			return true;
			
		} catch (MongoException e) {
			e.printStackTrace();
		} 
		return false;
	}

}
