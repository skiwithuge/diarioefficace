package com.skiwithuge.diarioefficace.activity;

import android.support.v4.app.Fragment;

import com.skiwithuge.diarioefficace.R;
import com.skiwithuge.diarioefficace.fragment.DayFragment;
import com.skiwithuge.diarioefficace.fragment.DiaryListFragment;
import com.skiwithuge.diarioefficace.model.Day;

/**
 * Created by skiwithuge on 11/19/16.
 */

public class DiaryListActivity extends SingleFragmentActivity implements DiaryListFragment.OnDiaryClickListener{
    @Override
    protected Fragment createFragment() {
        return new DiaryListFragment();
    }

    @Override
    public void onDaySelected(Day day) {
        Fragment dayFragment = DayFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, dayFragment)
                .addToBackStack(null)
                .commit();
    }
}
