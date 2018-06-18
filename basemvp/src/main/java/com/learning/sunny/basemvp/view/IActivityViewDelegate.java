package com.learning.sunny.basemvp.view;

import android.support.v7.widget.Toolbar;

public interface IActivityViewDelegate extends IDelegate {

    int getOptionsMenuId();

    Toolbar getToolbar();
}
