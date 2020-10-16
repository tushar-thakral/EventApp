package org.tushar.app.model;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

public class Profile {

	private long id;
	private String firstName;
	private String lastName;
	private String collegeName;
	private long collegeId;
	private long phoneNumber;
	private String email;
	private String imageUrl;
	private ArrayList<String> interests;
	private ArrayList<Long> followingEvents = null;	
	private String dateCreated;
	private boolean isLoggedIn = false;
	private boolean isAdmin = false;
	private long adminOfClub = -1;
	
	public Profile() {
		
	}

	public Profile(long id, String firstName, String lastName, String collegeName, long phoneNumber, String email,
			String dateCreated) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.collegeName = collegeName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateCreated = dateCreated;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public long getAdminOfClub() {
		return adminOfClub;
	}

	public void setAdminOfClub(long adminOfClub) {
		this.adminOfClub = adminOfClub;
	}
	
	public ArrayList<Long> getFollowingEvents() {
		return followingEvents;
	}
	
	public void addFollowingEvent(long followingEventId) {
		followingEvents.add(followingEventId);
	}

	public void setFollowingEvents(ArrayList<Long> followingEvents) {
		this.followingEvents = followingEvents;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<String> getInterests() {
		return interests;
	}

	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreated() {
		return dateCreated;
	}

	public void setCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

}
