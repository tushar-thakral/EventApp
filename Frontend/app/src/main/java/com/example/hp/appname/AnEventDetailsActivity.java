package com.example.hp.appname;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.Serializable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class AnEventDetailsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Serializable, View.OnClickListener {

    private static final String TAG ="ParseJSONObject";
    private Event event;
    private TextView nameTextView;
    private TextView organiserTextView;
    private TextView eventDateTextView;
    private TextView eventTimeTextView;
    private TextView venueTextView;
    private TextView eventInfoTextView;
    //private TextView followButtonTextView; implements View.OnClickListener
    private Button followButton;
    private ImageView photoImageView;
    private String photoUrl;
    private long eventId;
    private long count = 0;
    private final String EXTRA_JSON_OBJECT = "eventObject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_event_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Bundle b2 = getIntent().getExtras();
        eventId = b2.getLong("eventId", 0);

        event = (Event) getIntent().getSerializableExtra("eventObject");
        nameTextView =(TextView) findViewById(R.id.edit_text_name);
        organiserTextView =(TextView) findViewById(R.id.edit_text_company_name);
        eventDateTextView =(TextView) findViewById(R.id.edit_text_operating_system);
        eventTimeTextView = (TextView) findViewById(R.id.edit_text_processor);
        venueTextView = (TextView) findViewById(R.id.edit_text_ram);
        eventInfoTextView = (TextView) findViewById(R.id.edit_text_rom);
        photoImageView = (ImageView) findViewById(R.id.image_view_mobile_picture);
        //followButtonTextView = (TextView) findViewById(R.id.my_textview);
        Button followButton = (Button) findViewById(R.id.followButton);
        followButton.setOnClickListener(this);
        //final ProgressDialog pDialog = new ProgressDialog(this);
        nameTextView.setText(" Name : " + event.getName());
        organiserTextView.setText(" Organiser : " + event.getOrganiser());
        eventDateTextView.setText(" Date : " + event.getEventDate());
        eventTimeTextView.setText(" Time : " + event.getEventTime());
        venueTextView.setText(" Venue : "+ event.getVenue());
        eventInfoTextView.setText(" Event Info : "+ event.getEventInfo());
        /*photoUrl = (event.getImageUrl());
        ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(getApplicationContext()),
                new LruBitmapCache());
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
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

    /*public Button getFollowButton() {
        return followButton;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.an_event_details, menu);
        return false;
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

    public void shareFunction(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    /*public void followEvent(View view) {
       followButton.setText("Following");
    }*/

    @Override
    public void onClick(View v) {
        count++;
        if (count == 100)
            count = count - 98;
        Button followButton = (Button) v.findViewById(R.id.followButton);
        if(count % 2 != 0) {
            followButton.setText("Following");
            followButton.setTextColor(Color.parseColor("#FBFCFC"));
            followButton.setBackground(getResources().getDrawable(R.drawable.button_bg_rounded_corners));
            //followButton.setTextColor(Color.parseColor("@colors/white"));
        } else {
            followButton.setText("Follow");
            followButton.setTextColor(Color.parseColor("#29B6F6"));
            followButton.setBackground(getResources().getDrawable(R.drawable.button_bg_rounded_corners2));
            //followButton.setTextColor(Color.parseColor("@colors/anotherBlue3"));
        }
    }
}
