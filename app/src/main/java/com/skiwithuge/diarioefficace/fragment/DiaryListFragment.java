package com.skiwithuge.diarioefficace.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skiwithuge.diarioefficace.Constants;
import com.skiwithuge.diarioefficace.R;
import com.skiwithuge.diarioefficace.model.Day;
import com.skiwithuge.diarioefficace.model.DayList;

import java.util.List;

/**
 * Created by skiwithuge on 11/19/16.
 */

public class DiaryListFragment extends Fragment {

    private RecyclerView mDayRecyclerView;
    private DiaryAdapter mAdapter;
    private OnDiaryClickListener mOnDiaryClickListener;

    public interface OnDiaryClickListener{
        void onDaySelected(Day day);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mOnDiaryClickListener = (OnDiaryClickListener) context;
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
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //TODO complete
    }

    //TODO onSaveInstanceState

    @Override
    public void onDetach(){
        super.onDetach();
        mOnDiaryClickListener = null;
    }

    //TODO onCreateOptionMenu

    //TODO onOptionsItemSelected

    private void updateUI() {
        DayList dl = DayList.get(getActivity());
        List<Day> days = dl.getDays();

        if (mAdapter == null) {
            mAdapter = new DiaryAdapter(getActivity(), days);
            mDayRecyclerView.setAdapter(mAdapter);
        } else {
            mDayRecyclerView.setAdapter(mAdapter);
            mAdapter.setDays(days);
            mAdapter.notifyDataSetChanged();
        }

    }

    public class DayHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mDate;
        private TextView mA1;
        private TextView mA2;
        private TextView mA3;
        private TextView mA4;
        private TextView mA5;

        private Day mDay;

        public DayHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mDate = (TextView) itemView.findViewById(R.id.card_date);
            mA1 = (TextView) itemView.findViewById(R.id.answer1);
            mA2 = (TextView) itemView.findViewById(R.id.answer2);
            mA3 = (TextView) itemView.findViewById(R.id.answer3);
            mA4 = (TextView) itemView.findViewById(R.id.answer4);
            mA5 = (TextView) itemView.findViewById(R.id.answer5);
        }

        public void bindDay(Day day) {
            mDay = day;
            mDate.setText(Constants.sdf.format(day.getDate()));
            int phase = day.getPhase();
            switch (phase){
                case 0:
                    mA1.setTextSize(20);
                    mA1.setBackgroundColor(Color.LTGRAY);

                    mA2.setTextSize(20);
                    mA2.setBackgroundColor(Color.LTGRAY);

                    mA3.setTextSize(20);
                    mA3.setBackgroundColor(Color.LTGRAY);

                    mA4.setTextSize(20);
                    mA4.setBackgroundColor(Color.LTGRAY);

                    mA5.setTextSize(20);
                    mA5.setBackgroundColor(Color.LTGRAY);
                    break;
                case 1:
                    mA1.setTextSize(20);
                    mA1.setBackgroundColor(Color.GREEN);

                    mA2.setTextSize(20);
                    mA2.setBackgroundColor(Color.GREEN);

                    mA3.setTextSize(20);
                    mA3.setBackgroundColor(Color.GREEN);

                    mA4.setTextSize(20);
                    mA4.setBackgroundColor(Color.LTGRAY);

                    mA5.setTextSize(20);
                    mA5.setBackgroundColor(Color.LTGRAY);
                    break;
                case 2:
                    mA1.setTextSize(20);
                    mA1.setBackgroundColor(Color.GREEN);

                    mA2.setTextSize(20);
                    mA2.setBackgroundColor(Color.GREEN);

                    mA3.setTextSize(20);
                    mA3.setBackgroundColor(Color.GREEN);

                    mA4.setTextSize(20);
                    mA4.setBackgroundColor(Color.GREEN);

                    mA5.setTextSize(20);
                    mA5.setBackgroundColor(Color.GREEN);
                    break;
                default:
                    break;
            }

        }

        @Override
        public void onClick(View view) {
            mOnDiaryClickListener.onDaySelected(mDay);
        }
    }

    private class DiaryAdapter extends RecyclerView.Adapter<DayHolder>{
        private List<Day> mDays;
        private Context mContext;

        public DiaryAdapter(List<Day> days){
            mDays = days;
        }

        public DiaryAdapter(Context context, List<Day> days){
            mDays = days;
            mContext = context;
        }

        @Override
        public DayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            View view = layoutInflater.inflate(R.layout.list_item_diary, parent, false);
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
    }
}