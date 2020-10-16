package com.example.hp.appname;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddEventActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "AddEventObject";
    private String strName;
    private String strVenue;
    private String strOrganizer;
    private String strEventInfo;
    private String strImageUrl;
    private String mdate;
    private String mtime;
    private long mclubId = -1;
    String url = "http://172.16.129.121:8082/app/webapi/events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*EditText name = (EditText) findViewById(R.id.input_name);
        EditText venue = (EditText) findViewById(R.id.input_venue);
        EditText organizer = (EditText) findViewById(R.id.input_organizer);
        EditText eventInfo = (EditText) findViewById(R.id.input_event_info);
        EditText imageUrl = (EditText) findViewById(R.id.input_image_url);
        EditText date = (EditText) findViewById(R.id.input_date);
        EditText time = (EditText) findViewById(R.id.input_time);
        EditText clubId = (EditText) findViewById(R.id.input_clubId);
        this.strName = name.getText().toString();
        this.strVenue = venue.getText().toString();
        this.strOrganizer = organizer.getText().toString();
        this.strEventInfo = eventInfo.getText().toString();
        this.strImageUrl = imageUrl.getText().toString();
        this.mdate = date.getText().toString();
        this.mtime = time.getText().toString();
        this.mclubId = Long.valueOf(clubId.getText().toString());*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_search) {

        }*/ if (id == R.id.nav_my_college) {
            Intent intent = new Intent(this, ClubNamesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_nearby_colleges) {
            Intent intent = new Intent(this, EventsInNearbyClgsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_sign_out) {
            Intent intent = new Intent(this, StartScreen.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*private long clubId;
        private String name;
        private String venue;
        private String eventDate;
        private String eventTime;
        private String organiser;
        private String eventInfo;
        private String imageUrl;
        */

    public void addEventButton(View view) throws JSONException {
        EditText name = (EditText) findViewById(R.id.input_name);
        EditText venue = (EditText) findViewById(R.id.input_venue);
        EditText organizer = (EditText) findViewById(R.id.input_organizer);
        EditText eventInfo = (EditText) findViewById(R.id.input_event_info);
        EditText imageUrl = (EditText) findViewById(R.id.input_image_url);
        EditText date = (EditText) findViewById(R.id.input_date);
        EditText time = (EditText) findViewById(R.id.input_time);
        EditText clubId = (EditText) findViewById(R.id.input_clubId);
        this.strName = name.getText().toString();
        this.strVenue = venue.getText().toString();
        this.strOrganizer = organizer.getText().toString();
        this.strEventInfo = eventInfo.getText().toString();
        this.strImageUrl = imageUrl.getText().toString();
        this.mdate = date.getText().toString();
        this.mtime = time.getText().toString();
        this.mclubId = Long.valueOf(clubId.getText().toString());

        JSONObject jsonobj = new JSONObject();
        jsonobj.put("id", -1);
        jsonobj.put("clubId", this.mclubId);
        jsonobj.put("name", this.strName);
        jsonobj.put("venue", this.strVenue);
        jsonobj.put("eventDate", this.mdate);
        jsonobj.put("eventTime", this.mtime);
        jsonobj.put("organiser", this.strOrganizer);
        jsonobj.put("eventInfo", this.strEventInfo);
        jsonobj.put("imageUrl", this.strImageUrl);

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

        Toast.makeText(getApplicationContext(),"Event Added!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), ClubNamesActivity.class);
        startActivity(intent);

    }
}
