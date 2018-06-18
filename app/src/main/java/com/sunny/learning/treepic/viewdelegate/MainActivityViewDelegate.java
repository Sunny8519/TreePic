package com.sunny.learning.treepic.viewdelegate;

import com.learning.sunny.basemvp.view.BaseActivityViewDelegate;
import com.sunny.learning.treepic.R;
import com.sunny.learning.treepic.databinding.ActivityMainBinding;

public class MainActivityViewDelegate extends BaseActivityViewDelegate<ActivityMainBinding> {

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {

    }
}
