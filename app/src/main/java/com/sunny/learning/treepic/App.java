package com.sunny.learning.treepic;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public class App extends Application {
    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        initialiseStorage();
    }

    private void initialiseStorage() {
        Hawk.init(this).build();
    }

    public static App getInstance() {
        return sInstance;
    }
}
