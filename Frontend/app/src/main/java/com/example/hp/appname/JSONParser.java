package com.example.hp.appname;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
/**
 * Created by hp on 08-Jun-18.
 */

public class JSONParser {

    public static ArrayList<Mobile> mMobiles = new ArrayList<>();

    public static Mobile parseFeed(JSONObject obj) {

        try {
            Mobile mobile = new Mobile();
            mobile.setName(obj.getString("name"));
            mobile.setCompanyName(obj.getString("companyName"));
            mobile.setOperatingSystem(obj.getString("operatingSystem"));
            mobile.setProcessor(obj.getString("processor"));
            mobile.setBackCamera(obj.getString("backCamera"));
            mobile.setFrontCamera(obj.getString("frontCamera"));
            mobile.setRam(obj.getString("ram"));
            mobile.setRom(obj.getString("rom"));
            mobile.setScreenSize(obj.getString("screenSize"));
            mobile.setUrl(obj.getString("url"));
            mobile.setBattery(obj.getString("battery"));
            return mobile;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }

    }

    public static ArrayList<Mobile> parseArrayFeed(JSONArray arr) {
        JSONObject obj=null;
        Mobile mobile = null;
        mMobiles.clear();
        try {

            for(int i = 0;i<arr.length();i++) {
                obj = arr.getJSONObject(i);
                mobile= new Mobile();
                mobile.setName(obj.getString("name"));
                mobile.setCompanyName(obj.getString("companyName"));
                mobile.setOperatingSystem(obj.getString("operatingSystem"));
                mobile.setProcessor(obj.getString("processor"));
                mobile.setBackCamera(obj.getString("backCamera"));
                mobile.setFrontCamera(obj.getString("frontCamera"));
                mobile.setRam(obj.getString("ram"));
                mobile.setRom(obj.getString("rom"));
                mobile.setScreenSize(obj.getString("screenSize"));
                mobile.setUrl(obj.getString("url"));
                mobile.setBattery(obj.getString("battery"));
                mMobiles.add(mobile);
            }
            return mMobiles;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }

    }

}
