package com.example.hp.appname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class StartScreen extends AppCompatActivity {

    private ImageView photoImageView;
    private String photoUrl;
    private static final String TAG ="ParseJSONObject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        photoImageView = (ImageView) findViewById(R.id.startScreenImage);
        photoUrl = "http://192.168.42.124:8082/app/webapi/start_screen_image";
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
                    //pDialog.hide();
                }
            }
        });

    }

    public void signInFunc(View view) {
        Intent intent = new Intent(this, SignInScreen.class);
        startActivity(intent);
    }

    public void signUpFunc(View view) {
        Intent intent = new Intent(this, SignUpScreen.class);
        startActivity(intent);
    }
}
