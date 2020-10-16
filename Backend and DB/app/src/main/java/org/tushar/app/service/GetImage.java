package org.tushar.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

public class GetImage {
	
	private static String fileName;
	
	public GetImage() {
		
	}
	
	public GetImage(String fileName) {
		this.fileName = fileName;
	}
	
	public static String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		GetImage.fileName = fileName;
	}

	public static byte[] main(String fileName) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("eventquest");

			//DBCollection collection = db.getCollection("fs.files");

			GridFS fs = new GridFS(db);
			GridFSDBFile imageForOutput = fs.findOne(new BasicDBObject("filename", getFileName()));
			//GridFSDBFile imageForOutput = (GridFSDBFile) collection.findOne(new BasicDBObject("filename", "newImage"));
			InputStream is = imageForOutput.getInputStream();
			return IOUtils.toByteArray(is);

		} catch (MongoException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
