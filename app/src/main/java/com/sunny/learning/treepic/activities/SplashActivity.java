package com.sunny.learning.treepic.activities;

import android.os.Bundle;

import com.learning.sunny.basemvp.databinder.IBinder;
import com.learning.sunny.basemvp.model.IModel;
import com.sunny.learning.treepic.viewdelegate.SplashActivityViewDelegate;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public class SplashActivity extends SharedMediaActivity<SplashActivityViewDelegate, IModel> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected Class<SplashActivityViewDelegate> getDelegateClass() {
        return SplashActivityViewDelegate.class;
    }

    @Override
    public IBinder<SplashActivityViewDelegate, IModel> getBinder() {
        return null;
    }
}
