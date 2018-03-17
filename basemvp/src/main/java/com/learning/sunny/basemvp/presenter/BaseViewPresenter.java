package com.learning.sunny.basemvp.presenter;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.learning.sunny.basemvp.view.IDelegate;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public abstract class BaseViewPresenter<T extends IDelegate> extends FrameLayout {
    protected T viewDelegate;

    public BaseViewPresenter(@NonNull Context context) {
        this(context, null);
    }

    public BaseViewPresenter(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseViewPresenter(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initViewDelegate();
    }

    private void initViewDelegate() {
        try {
            this.viewDelegate = getDelegateClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.viewDelegate.create(LayoutInflater.from(getContext()), null, null);
        addView(this.viewDelegate.getRootView());
        initEventListener();
    }

    protected void initEventListener() {
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
    }

    protected abstract Class<T> getDelegateClass();
}
