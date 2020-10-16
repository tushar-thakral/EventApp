package org.tushar.app.service;

import org.json.simple.JSONObject;
import org.tushar.app.model.Club;
import org.tushar.app.model.Event;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class UpdateEvent {
	
	private static long id;
	private static long clubId;
	private static String name;
	private static String venue;
	private static String eventDate;
	private static String eventTime;
	private static String organiser;
	private static String eventInfo;
	private static String imageUrl;

	public UpdateEvent() {
		
	}

	public UpdateEvent(Event event) {
		this.id = event.getId();
		this.clubId = event.getClubId();
		this.name = event.getName();
		this.venue = event.getVenue();
		this.eventDate = event.getEventDate();
		this.eventTime = event.getEventTime();
		this.organiser = event.getOrganiser();
		this.eventInfo = event.getEventInfo();
		this.imageUrl = event.getImageUrl();
	}

	public static long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static String getOrganiser() {
		return organiser;
	}

	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}

	public static String getEventInfo() {
		return eventInfo;
	}

	public void setEventInfo(String eventInfo) {
		this.eventInfo = eventInfo;
	}

	public static long getClubId() {
		return clubId;
	}

	public void setClubId(long clubId) {
		this.clubId = clubId;
	}

	public static String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public static String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public static String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	
	public static String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public static JSONObject main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("events");

			BasicDBObject updateDocument = new BasicDBObject();
			updateDocument.append("$set", new BasicDBObject().append("imageUrl", getImageUrl()));
		
			BasicDBObject searchQuery2 = new BasicDBObject().append("id", getId());

			collection.update(searchQuery2, updateDocument);
			
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
