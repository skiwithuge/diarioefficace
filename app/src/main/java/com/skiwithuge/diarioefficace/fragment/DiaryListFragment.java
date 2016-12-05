package com.skiwithuge.diarioefficace.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skiwithuge.diarioefficace.R;
import com.skiwithuge.diarioefficace.adapter.DayAdapter;
import com.skiwithuge.diarioefficace.model.Day;
import com.skiwithuge.diarioefficace.model.DayList;

import java.util.List;
import java.util.UUID;

/**
 * Created by skiwithuge on 11/19/16.
 */

public class DiaryListFragment extends Fragment {

    private RecyclerView mDayRecyclerView;
    private DayAdapter mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary_list, container, false);;

        mDayRecyclerView = (RecyclerView) view
                .findViewById(R.id.day_recycler_view);
        mDayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void updateUI() {
        //UUID id = UUID.randomUUID();
        //Day day = new Day(id);
        //DayList.get(getActivity()).addDay(day);


        DayList dl = DayList.get(getActivity());
        List<Day> days = dl.getDays();

        if (mAdapter == null) {
            mAdapter = new DayAdapter(getActivity(), days);
            mDayRecyclerView.setAdapter(mAdapter);

        } else {
            mAdapter.setDays(days);
            mAdapter.notifyDataSetChanged();
        }

    }

}