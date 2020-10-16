package org.tushar.app.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.tushar.app.model.Club;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class AddClub {

	private static long id;
	private static long collegeId;
	private static String name;
	private static String info;
	private static String admin;
	private static String imageUrl;
	
	public AddClub() {
		
	}

	public AddClub(Club club) {
		this.id = club.getId();
		this.collegeId = club.getCollegeId();
		this.name = club.getName();
		this.info = club.getInfo();
		this.admin = club.getAdmin();
		this.imageUrl = club.getImageUrl();
	}

	public static long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}
	
	public static String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public static String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public static String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	public static JSONObject main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			DBCollection collection = db.getCollection("clubs");

			BasicDBObject document = new BasicDBObject();
			document.put("id", getId());
			document.put("collegeId", getCollegeId());
			document.put("name", getName());
			document.put("info", getInfo());
			document.put("admin", getAdmin());
			document.put("imageUrl", getImageUrl());
			
			collection.insert(document);

			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("id", getId());
			DBCursor cursor = collection.find(whereQuery);
			BasicDBObject obj = (BasicDBObject) cursor.next();
			JSONObject jsonobj = new JSONObject();
			//BasicDBList name = (BasicDBList) obj.get("Name");
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
