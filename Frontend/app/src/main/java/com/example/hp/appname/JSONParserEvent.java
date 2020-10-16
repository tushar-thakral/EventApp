package com.example.hp.appname;

/**
 * Created by hp on 26-Jul-18.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
/**
 * Created by hp on 08-Jun-18.
 */

public class JSONParserEvent {

    public static ArrayList<Event> mEvents = new ArrayList<>();

    public static Event parseFeed(JSONObject obj) {

        try {
            Event event = new Event();
            event.setId(obj.getLong("id"));
            event.setClubId(obj.getLong("clubId"));
            event.setName(obj.getString("name"));
            event.setVenue(obj.getString("venue"));
            event.setEventDate(obj.getString("eventDate"));
            event.setEventTime(obj.getString("eventTime"));
            event.setOrganiser(obj.getString("organiser"));
            event.setEventInfo(obj.getString("eventInfo"));
            return event;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Event> parseArrayFeed(JSONArray arr) {
        JSONObject obj=null;
        Event event = null;
        mEvents.clear();
        try {

            for(int i = 0;i<arr.length();i++) {
                obj = arr.getJSONObject(i);
                event = new Event();
                event.setId(obj.getLong("id"));
                event.setClubId(obj.getLong("clubId"));
                event.setName(obj.getString("name"));
                event.setVenue(obj.getString("venue"));
                event.setEventDate(obj.getString("eventDate"));
                event.setEventTime(obj.getString("eventTime"));
                event.setOrganiser(obj.getString("organiser"));
                event.setEventInfo(obj.getString("eventInfo"));
                mEvents.add(event);
            }
            return mEvents;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }

    }

}
