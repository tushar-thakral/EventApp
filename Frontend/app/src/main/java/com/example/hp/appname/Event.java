package com.example.hp.appname;

import java.io.Serializable;

/**
 * Created by hp on 19-Jun-18.
 */

public class Event implements Serializable {

    private long id;
    private long clubId;
    private String name;
    private String venue;
    private String eventDate;
    private String eventTime;
    private String organiser;
    private String eventInfo;
    private String imageUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public long getClubId() {
        return clubId;
    }

    public void setClubId(long clubId) {
        this.clubId = clubId;
    }

    public Event() {

    }

    public Event(long id, long clubId, String name, String venue, String eventDate, String eventTime) {
        //super();
        this.id = id;
        this.clubId = clubId;
        this.name = name;
        this.venue = venue;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

}
