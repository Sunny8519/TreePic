package com.sunny.learning.treepic.activities;

import android.os.Bundle;

import com.sunny.learning.treepic.base.BaseActivity;
import com.sunny.learning.treepic.R;
import com.sunny.learning.treepic.viewdelegate.MainActivityViewDelegate;

public class MainActivity extends BaseActivity<MainActivityViewDelegate> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected Class<MainActivityViewDelegate> getDelegateClass() {
        return MainActivityViewDelegate.class;
    }
}
