package com.example.hp.appname;

/**
 * Created by hp on 13-May-18.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClubFragmentTwo extends Fragment {
    public static ClubFragmentTwo newInstance() {
        ClubFragmentTwo fragment = new ClubFragmentTwo();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.club_fragment_two, container, false);
    }
}