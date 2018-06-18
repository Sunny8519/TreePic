package com.learning.sunny.basemvp.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.learning.sunny.basemvp.view.BaseActivityViewDelegate;
import com.learning.sunny.basemvp.view.IActivityViewDelegate;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public abstract class BaseActivityPresenter<V extends IActivityViewDelegate> extends AppCompatActivity {

    protected V viewDelegate;

    public BaseActivityPresenter() {
        initViewDelegate();
    }

    private void initViewDelegate() {
        try {
            viewDelegate = getDelegateClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("create IDelegate error");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDelegate.create(getLayoutInflater(), null, savedInstanceState);
        setContentView(viewDelegate.getRootView());
        initToolbar();
        viewDelegate.initWidget();
        bindEventListener();
    }

    protected void bindEventListener() {
    }

    protected void initToolbar() {
        Toolbar toolbar = viewDelegate.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (viewDelegate == null) {
            initViewDelegate();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (viewDelegate.getOptionsMenuId() != 0) {
            getMenuInflater().inflate(viewDelegate.getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewDelegate = null;
    }

    protected abstract Class<V> getDelegateClass();
}
