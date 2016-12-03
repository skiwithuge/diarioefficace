package com.skiwithuge.diarioefficace.activity;

import android.support.v4.app.Fragment;

import com.skiwithuge.diarioefficace.fragment.DiaryListFragment;

/**
 * Created by skiwithuge on 11/19/16.
 */

public class DiaryListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new DiaryListFragment();
    }
}
