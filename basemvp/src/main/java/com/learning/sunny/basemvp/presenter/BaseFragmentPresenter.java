package com.learning.sunny.basemvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learning.sunny.basemvp.view.IDelegate;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public abstract class BaseFragmentPresenter<T extends IDelegate> extends Fragment {
    protected T viewDelegate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewDelegate();
    }

    private void initViewDelegate() {
        try {
            viewDelegate = getDelegateClass().newInstance();
        } catch (java.lang.InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewDelegate.create(inflater, container, savedInstanceState);
        return viewDelegate.getRootView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDelegate.initWidget();
        bindEventListener();
    }

    protected void bindEventListener() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (viewDelegate.getOptionsMenuId() != 0) {
            inflater.inflate(viewDelegate.getOptionsMenuId(), menu);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (viewDelegate == null) {
            initViewDelegate();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewDelegate = null;
    }

    protected abstract Class<T> getDelegateClass();

}
