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

import java.util.HashMap;
import java.util.Map;

public class SignInScreen extends AppCompatActivity {

    private static final String TAG = "SignInJSONObject";
    private String strEmail;
    private String strPassword;
    String url = "http://172.16.129.121:8082/app/webapi/authenticate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        /*EditText email = (EditText) findViewById(R.id.input_email);
        EditText password = (EditText) findViewById(R.id.input_password);
        String strEmail = email.getText().toString();
        String strPassword = password.getText().toString();*/
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

    public void signInButton(View view) throws JSONException {
        //final boolean result = false;
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("email", getEmail());
        jsonobj.put("password", getPassword());

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.POST, url, jsonobj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        if(response.toString().equals("true")) {
                            Intent intent = new Intent(getBaseContext(), ClubNamesActivity.class);
                            startActivity(intent);
                        }

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
