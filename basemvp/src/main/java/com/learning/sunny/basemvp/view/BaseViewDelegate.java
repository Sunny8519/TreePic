package com.learning.sunny.basemvp.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public abstract class BaseViewDelegate<T extends ViewDataBinding> implements IDelegate {
    protected T mViewBinding;

    @Override
    public void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int layoutId = getRootLayoutId();
        this.mViewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);
    }

    public void setOnClickListener(View.OnClickListener listener, int... ids) {
        if (this.mViewBinding == null) return;
        for (int id : ids) {
            this.mViewBinding.getRoot().findViewById(id).setOnClickListener(listener);
        }
    }

    @Override
    public View getRootView() {
        return this.mViewBinding.getRoot();
    }

    @SuppressWarnings("unchecked")
    protected <D extends Activity> D getActivity() {
        return (D) getRootView().getContext();
    }
}
