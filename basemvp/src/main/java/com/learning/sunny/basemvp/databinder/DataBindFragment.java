package com.learning.sunny.basemvp.databinder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.learning.sunny.basemvp.model.IModel;
import com.learning.sunny.basemvp.presenter.BaseFragmentPresenter;
import com.learning.sunny.basemvp.view.IDelegate;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public abstract class DataBindFragment<V extends IDelegate,M extends IModel> extends BaseFragmentPresenter<V> {
    protected IBinder<V, M> mBinder = null;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mBinder = getBinder();
    }

    public abstract IBinder<V, M> getBinder();

    public void notifyModelChanged(M model) {
        if (this.mBinder != null) {
            this.mBinder.modelBindView(model, viewDelegate);
        }
    }
}
