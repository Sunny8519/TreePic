package com.sunny.learning.treepic.activities.base;

import android.os.Bundle;

import com.learning.sunny.basemvp.databinder.IBinder;
import com.learning.sunny.basemvp.model.IModel;
import com.sunny.learning.treepic.activities.base.viewdelegate.SplashViewDelegate;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public class SplashActivity extends SharedMediaActivity<SplashViewDelegate, IModel> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected Class<SplashViewDelegate> getDelegateClass() {
        return SplashViewDelegate.class;
    }

    @Override
    public IBinder<SplashViewDelegate, IModel> getBinder() {
        return null;
    }
}
