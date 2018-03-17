package com.learning.sunny.basemvp.databinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.learning.sunny.basemvp.model.IModel;
import com.learning.sunny.basemvp.presenter.BaseViewPresenter;
import com.learning.sunny.basemvp.view.IDelegate;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public abstract class DataBindView<V extends IDelegate, M extends IModel> extends BaseViewPresenter<V> {
    protected IBinder<V, M> mBinder = null;

    public DataBindView(@NonNull Context context) {
        super(context);
    }

    public DataBindView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DataBindView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mBinder = getBinder();
    }

    public abstract IBinder<V, M> getBinder();

    public void notifyModelChanged(M model) {
        if (this.mBinder != null) {
            this.mBinder.modelBindView(model, viewDelegate);
        }
    }
}
