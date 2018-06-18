package com.sunny.learning.treepic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.learning.sunny.basemvp.presenter.BaseActivityPresenter;
import com.learning.sunny.basemvp.view.IActivityViewDelegate;

public abstract class BaseActivity<V extends IActivityViewDelegate> extends BaseActivityPresenter<V> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
