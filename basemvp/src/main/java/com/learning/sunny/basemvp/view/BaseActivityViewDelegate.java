package com.learning.sunny.basemvp.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author : Sunny
 * time : 2018/6/18
 * desc :
 */

public abstract class BaseActivityViewDelegate<B extends ViewDataBinding> implements IActivityViewDelegate {
    protected B mViewDataBinding;

    @Override
    public void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutId = getRootLayoutId();
        this.mViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);
    }

    @Override
    public View getRootView() {
        return this.mViewDataBinding.getRoot();
    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }

    @Override
    public Toolbar getToolbar() {
        return null;
    }

    @SuppressWarnings("unchecked")
    protected <A extends Activity> A getActivity() {
        return (A) getRootView().getContext();
    }
}
