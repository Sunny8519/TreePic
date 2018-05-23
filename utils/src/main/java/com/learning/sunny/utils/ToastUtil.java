package com.learning.sunny.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * author: Sunny
 * time: 2018/4/7
 * desc: 单例Toast
 */

public enum ToastUtil {
    INSTANCE;

    private Toast mToast = null;

    public void showToast(Context applicationContext, String message) {
        if (this.mToast == null) {
            this.mToast = new Toast(applicationContext);
            this.mToast.setDuration(Toast.LENGTH_LONG);
        }
        this.mToast.setText(message);
        this.mToast.show();
    }

    public void showToast(Context applicationContext, @StringRes int messageId) {
        showToast(applicationContext, applicationContext.getString(messageId));
    }

    public void cancelToast() {
        if (this.mToast != null) {
            this.mToast.cancel();
            this.mToast = null;
        }
    }
}
