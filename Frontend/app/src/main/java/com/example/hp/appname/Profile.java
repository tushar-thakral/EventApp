package com.example.hp.appname;

import java.util.ArrayList;

/**
 * Created by hp on 19-Jun-18.
 */

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
    private String dateCreated;
    private boolean isLoggedIn;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }


}
