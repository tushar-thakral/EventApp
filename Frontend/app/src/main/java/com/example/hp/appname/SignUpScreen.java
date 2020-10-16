package com.example.hp.appname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SignUpScreen extends AppCompatActivity {

    private static final String TAG = "SignUpJSONObject";
    private String strFirstName;
    private String strLastName;
    private String strEmail;
    private String strPassword;
    private long longContactNumber;
    String url = "http://172.16.129.121:8082/app/webapi/profiles";
    String url2 = "http://172.16.129.121:8082/app/webapi/authenticate/addAuthKeys";
    private String collegeName1 = "IIIT-Bangalore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        EditText firstName = (EditText) findViewById(R.id.input_firstname);
        EditText lastName = (EditText) findViewById(R.id.input_lastname);
        EditText email = (EditText) findViewById(R.id.input_email_id);
        EditText password = (EditText) findViewById(R.id.input_password2);
        EditText contactNumber = (EditText) findViewById(R.id.input_contact_number);
        String strFirstName = firstName.getText().toString();
        String strLastName = lastName.getText().toString();
        String strEmail = email.getText().toString();
        String strPassword = password.getText().toString();
        String strContactNumber = contactNumber.getText().toString();
        if(!strContactNumber.equals("")) {
            long longContactNumber = Long.valueOf(strContactNumber);
        }
    }

    /*public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }*/

    public long getPhoneNumber() {
        return longContactNumber;
    }

    public void setPhoneNumber(long longContactNumber) {
        this.longContactNumber = longContactNumber;
    }

    public String getEmail() {
        return strEmail;
    }

    public void setEmail(String strEmailmail) {
        this.strEmail = strEmail;
    }

    public String getPassword() {
        return strPassword;
    }

    public void setPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    /*public ArrayList<String> getInterests() {
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
    }*/

    public String getFirstName() {
        return strFirstName;
    }

    public void setFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

    public String getLastName() {
        return strLastName;
    }

    public void setLastName(String strLastName) {
        this.strLastName = strLastName;
    }

    /*public String getCreated() {
        return dateCreated;
    }

    public void setCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }*/

    public String getCollegeName1() {
        return collegeName1;
    }

    /*public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }*/

    public void signUpButton(View view) throws JSONException {
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("id", -1);
        jsonobj.put("firstName", getFirstName());
        jsonobj.put("lastName", getLastName());
        jsonobj.put("collegeName", getCollegeName1());
        jsonobj.put("phoneNumber", getPhoneNumber());
        jsonobj.put("email", getEmail());
        //jsonobj.put("dateCreated", "");
        jsonobj.put("imageUrl", "-1");

        final JSONObject jsonobj2 = new JSONObject();
        jsonobj2.put("email", getEmail());
        jsonobj2.put("password", getPassword());

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, jsonobj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        System.out.println("Request 1 done.");

                        //msgResponse.setText(response.toString());
                        //hideProgressDialog();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                //hideProgressDialog();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };


        JsonObjectRequest jsonObjReq2 = new JsonObjectRequest(
                Request.Method.POST, url2, jsonobj2,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        System.out.println("Request 2 done.");

                        //msgResponse.setText(response.toString());
                        //hideProgressDialog();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                //hideProgressDialog();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        Intent intent = new Intent(getApplicationContext(), ClubNamesActivity.class);
        startActivity(intent);

    }
}
