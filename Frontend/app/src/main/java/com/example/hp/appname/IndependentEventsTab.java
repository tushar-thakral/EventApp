package com.example.hp.appname;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 27-Mar-18.
 */

public class IndependentEventsTab extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.tab_independent_events, container, false);
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer2);
        //Bundle b = getArguments();
        long clubId = 0;
        /*if (fragment == null) {
            fragment = new ListEventsForClub();
            Bundle bun = new Bundle();
            bun.putLong("clubId", clubId);
            fragment.setArguments(bun);
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }*/
        fragment = new ListEventsForClub();
        Bundle bun = new Bundle();
        bun.putLong("clubId", clubId);
        fragment.setArguments(bun);
        fm.beginTransaction()
                .add(R.id.fragmentContainer2, fragment)
                .commit();

        return view;
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.tab_club_names);
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.mRecyclerView);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }// define an adapter
        mAdapter = new ClubNamesAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }*/

}