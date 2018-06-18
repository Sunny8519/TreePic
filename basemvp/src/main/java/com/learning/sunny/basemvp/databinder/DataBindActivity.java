package com.learning.sunny.basemvp.databinder;

import android.os.Bundle;

import com.learning.sunny.basemvp.model.IModel;
import com.learning.sunny.basemvp.presenter.BaseActivityPresenter;
import com.learning.sunny.basemvp.view.IActivityViewDelegate;
import com.learning.sunny.basemvp.view.IDelegate;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public abstract class DataBindActivity<V extends IActivityViewDelegate, M extends IModel> extends BaseActivityPresenter<V> {
    protected IBinder<V, M> mBinder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mBinder = getBinder();
    }

    public abstract IBinder<V, M> getBinder();

    public void notifyModelChanged(M model) {
        if (this.mBinder != null) {
            this.mBinder.modelBindView(model, viewDelegate);
        }
    }
}
