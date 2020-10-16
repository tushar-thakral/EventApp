package com.example.hp.appname;

/**
 * Created by hp on 08-Jun-18.
 */
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ParseJSONObject extends AppCompatActivity {

    private static final String TAG ="ParseJSONObject";
    private final String EXTRA_JSON_OBJECT_INDEX = "com.androidtutorialpoint.jsonparser";

    private Mobile mMobile;
    private TextView nameTextView;
    private TextView companyNameTextView;
    private TextView operatingSystemTextView;
    private TextView processorTextView;
    private TextView ramTextView;
    private TextView romTextView;
    private TextView frontCameraTextView;
    private TextView backCameraTextView;
    private TextView screenSizeTextView;
    private TextView batteryTextView;
    private ImageView photoImageView;
    private String photoUrl;

    String url = "https://androidtutorialpoint.com/api/MobileJSONObject.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsejsonobject);

        nameTextView =(TextView)findViewById(R.id.edit_text_name);
        companyNameTextView =(TextView)findViewById(R.id.edit_text_company_name);
        operatingSystemTextView =(TextView)findViewById(R.id.edit_text_operating_system);
        processorTextView = (TextView)findViewById(R.id.edit_text_processor);
        ramTextView = (TextView)findViewById(R.id.edit_text_ram);
        romTextView = (TextView)findViewById(R.id.edit_text_rom);
        frontCameraTextView = (TextView)findViewById(R.id.edit_text_front_camera);
        backCameraTextView = (TextView)findViewById(R.id.edit_text_back_camera);
        screenSizeTextView = (TextView)findViewById(R.id.edit_text_screen_size);
        batteryTextView = (TextView)findViewById(R.id.edit_text_battery);
        photoImageView = (ImageView)findViewById(R.id.image_view_mobile_picture);



        final   ProgressDialog pDialog = new ProgressDialog(ParseJSONObject.this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,url, null,new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                mMobile = JSONParser.parseFeed(response);


                nameTextView.setText("Name :" + mMobile.getName());
                companyNameTextView.setText("Company :" + mMobile.getCompanyName());
                operatingSystemTextView.setText(" OS :" + mMobile.getOperatingSystem());
                processorTextView.setText("Processor :" + mMobile.getProcessor());
                ramTextView.setText("RAM :"+mMobile.getRam());
                romTextView.setText("Memory :"+mMobile.getRom());
                frontCameraTextView.setText("Front Camera :"+mMobile.getFrontCamera());
                backCameraTextView.setText("Rear Camera :"+mMobile.getBackCamera());
                screenSizeTextView.setText("Screen Size :"+mMobile.getScreenSize());
                batteryTextView.setText("Battery :"+mMobile.getBattery());
                photoUrl = (mMobile.getUrl());

                ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(getApplicationContext()),
                        new LruBitmapCache());

                // If you are using normal ImageView
                imageLoader.get(photoUrl, new ImageLoader.ImageListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Image Load Error: " + error.getMessage());
                    }

                    @Override
                    public void onResponse(ImageLoader.ImageContainer response, boolean arg1) {
                        if (response.getBitmap() != null) {
                            // load image into imageview
                            photoImageView.setImageBitmap(response.getBitmap());
                            pDialog.hide();

                        }
                    }
                });


                Log.d(TAG, response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
            }
        });

        // Adding request to request queue
        Volley.newRequestQueue(getApplicationContext()).add(jsonObjReq);
    }

}
