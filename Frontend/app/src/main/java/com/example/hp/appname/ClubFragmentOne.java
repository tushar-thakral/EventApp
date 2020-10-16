package com.example.hp.appname;

/**
 * Created by hp on 13-May-18.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClubFragmentOne extends Fragment {
    public static ClubFragmentOne newInstance(long clubId) {
        ClubFragmentOne fragment = new ClubFragmentOne();
        Bundle b = new Bundle();
        b.putLong("clubId", clubId);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.club_fragment_one, container, false);
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        Bundle b = getArguments();
        long clubId = b.getLong("clubId", 0);
        if (fragment == null) {
            fragment = new ListEventsForClub();
            Bundle bun = new Bundle();
            bun.putLong("clubId", clubId);
            fragment.setArguments(bun);
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }

        return view;
    }
}