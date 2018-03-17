package com.learning.sunny.basemvp.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public interface IDelegate {

    void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    View getRootView();

    void initWidget();

    int getOptionsMenuId();

    Toolbar getToolbar();

    void setNavBarColor();

    void setStatusBarColor();
}
