package com.example.hp.appname;

/**
 * Created by hp on 25-Jul-18.
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

public class ListClubs extends ListFragment {

    private final String TAG = "ListClubs";
    private ArrayList<Club>  mClubList;
    String url = "http://172.16.129.121:8082/app/webapi/clubs";
    private final String EXTRA_JSON_OBJECT = "clubObject";
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
                        mClubList = JSONParserClub.parseArrayFeed(response);

                        pDialog.hide();
                        ClubAdapter adapter = new ClubAdapter(mClubList);
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

    private class ClubAdapter extends ArrayAdapter<Club> {

        public ClubAdapter(ArrayList<Club> clubs) {
            super(getActivity(), 0, clubs);
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // If we weren't given a view, inflate one
            //String photoUrl;

            Log.d(TAG,"pos "+position);
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.category_list_item_1, null);
            }
            final Club c = mClubList.get(position);
            TextView nameTextView =
                    (TextView) convertView.findViewById(R.id.textview_name);
            nameTextView.setText(c.getName());
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

                    Intent i = new Intent(getActivity(), EventsInTheClubActivity.class);
                    Bundle b = new Bundle();
                    b.putLong("clubId", c.getId());
                    i.putExtras(b);
                    //args.putSerializable(EXTRA_JSON__OBJECT, mMobileList.get(position));
                    //i.putExtra(EXTRA_JSON_OBJECT, mClubList.get(position));
                    startActivity(i);
                }
            });

            return convertView;
        }
    }

}

