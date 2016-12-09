package com.skiwithuge.diarioefficace.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skiwithuge.diarioefficace.R;
import com.skiwithuge.diarioefficace.model.Day;

import java.util.List;

/**
 * Created by skiwithuge on 12/4/16.
 */

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayHolder> {

    private List<Day> mDays;
    private Context mContext;


    public DayAdapter(List<Day> days){
        mDays = days;
    }

    public DayAdapter(Context context, List<Day> days){
        mDays = days;
        mContext = context;
    }

    @Override
    public DayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.list_item_day, parent, false);
        return new DayHolder(view);
    }

    @Override
    public void onBindViewHolder(DayHolder holder, int position) {
        Day day = mDays.get(position);
        holder.bindDay(day);
    }

    @Override
    public int getItemCount() {
        return mDays.size();
    }

    public void setDays(List<Day> days) {
        mDays = days;
    }

    public class DayHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mDate;

        private Day mDay;

        public DayHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            //TODO continue for the click
            mDate = (TextView) itemView.findViewById(R.id.card_date);
        }

        public void bindDay(Day day) {
            mDay = day;
            mDate.setText(day.getDate().toString());
        }

        @Override
        public void onClick(View view) {

        }
    }
}
