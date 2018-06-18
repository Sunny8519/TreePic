package com.sunny.learning.treepic.activities;

import com.learning.sunny.basemvp.databinder.DataBindActivity;
import com.learning.sunny.basemvp.model.IModel;
import com.learning.sunny.basemvp.presenter.BaseActivityPresenter;
import com.learning.sunny.basemvp.view.IActivityViewDelegate;
import com.learning.sunny.basemvp.view.IDelegate;
import com.sunny.learning.themeutils.ThemedActivity;

/**
 * author : Sunny
 * time : 2018/2/13
 * desc :
 */

public abstract class SharedMediaActivity<V extends IActivityViewDelegate, M extends IModel> extends DataBindActivity<V, M> {

    public void requestSdCardPermissions() {

    }
}
