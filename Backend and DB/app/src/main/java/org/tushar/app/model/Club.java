package org.tushar.app.model;

import javax.xml.bind.annotation.XmlRootElement;

public class Club {

	private long id;
	private long collegeId;
	private String name;
	private String info;
	private String admin;
	private String imageUrl;
	
	public Club() {
		
	}

	public Club(long id, long collegeId, String name, String info, String admin) {
		this.id = id;
		this.collegeId = collegeId;
		this.name = name;
		this.info = info;
		this.admin = admin;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

}
