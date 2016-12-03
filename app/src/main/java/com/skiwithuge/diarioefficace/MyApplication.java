package com.skiwithuge.diarioefficace;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by skiwithuge on 11/20/16.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
