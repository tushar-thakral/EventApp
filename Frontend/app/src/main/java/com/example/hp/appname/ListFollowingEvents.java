package com.example.hp.appname;

/**
 * Created by hp on 16-Jan-19.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import java.util.ArrayList;


public class ListFollowingEvents extends ListFragment {

    private final String TAG = "ListFollowingEvents";
    private ArrayList<Event>  mFollowingEventList;
    String url = "http://172.16.129.121:8082/app/webapi/getFollowingEvents";
    private final String EXTRA_JSON_OBJECT = "followingEventsObject";
    public String photoUrl;
    public ImageView photoImageView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        final   ProgressDialog pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonArrayRequest jsonArrayReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Log.d(TAG,response.toString());
                        Log.d(TAG,"Len "+response.length());
                        mFollowingEventList = JSONParserEvent.parseArrayFeed(response);

                        pDialog.hide();
                        ListFollowingEvents.FollowingEventAdapter adapter = new ListFollowingEvents.FollowingEventAdapter(mFollowingEventList);
                        setListAdapter(adapter);
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
        Volley.newRequestQueue(getActivity()).add(jsonArrayReq);
    }

    private class FollowingEventAdapter extends ArrayAdapter<Event> {

        public FollowingEventAdapter(ArrayList<Event> events) {
            super(getActivity(), 0, events);
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // If we weren't given a view, inflate one
            //String photoUrl;

            Log.d(TAG,"pos "+position);
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.category_list_item_2, null);
            }
            final Event e = mFollowingEventList.get(position);
            TextView nameTextView =
                    (TextView) convertView.findViewById(R.id.textview_name2);
            nameTextView.setText(e.getName());
            /*System.out.println(c.getName() + " = is the name of the club!!!!");

            photoUrl = new String(c.getImageUrl());
            System.out.println(photoUrl + " = is there!!!!");
            final ImageView photoImageView = (ImageView) convertView.findViewById(R.id.Image);
            ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(getActivity().getApplicationContext()),
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
                        //pDialog.hide();
                    }
                }
            });
*/
            nameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(getActivity(), AnEventDetailsActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("eventObject", mFollowingEventList.get(position));
                    //i.putExtras(b);
                    //Bundle b2 = new Bundle();
                    b.putLong("eventId", mFollowingEventList.get(position).getId());
                    i.putExtras(b);
                    startActivity(i);
                }
            });

            return convertView;
        }
    }

}
