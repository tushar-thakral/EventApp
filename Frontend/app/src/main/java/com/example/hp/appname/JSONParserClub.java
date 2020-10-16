package com.example.hp.appname;

/**
 * Created by hp on 25-Jul-18.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
/**
 * Created by hp on 08-Jun-18.
 */

public class JSONParserClub {

    public static ArrayList<Club> mClubs = new ArrayList<>();

    public static Club parseFeed(JSONObject obj) {

        try {
            Club club = new Club();
            club.setId(obj.getLong("id"));
            club.setCollegeId(obj.getLong("collegeId"));
            club.setName(obj.getString("name"));
            club.setInfo(obj.getString("info"));
            club.setAdmin(obj.getString("admin"));
            return club;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Club> parseArrayFeed(JSONArray arr) {
        JSONObject obj=null;
        Club club = null;
        mClubs.clear();
        try {

            for(int i = 0;i<arr.length();i++) {
                obj = arr.getJSONObject(i);
                club = new Club();
                club.setId(obj.getLong("id"));
                club.setCollegeId(obj.getLong("collegeId"));
                club.setName(obj.getString("name"));
                club.setInfo(obj.getString("info"));
                club.setAdmin(obj.getString("admin"));
                mClubs.add(club);
            }
            return mClubs;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }

    }

}
