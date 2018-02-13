package com.sunny.learning.themeutils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

public class ThemedAlertDialogBuilder extends AlertDialog.Builder {

    private ThemeHelper themeHelper;

    public ThemedAlertDialogBuilder(Context context, ThemeHelper themeHelper) {
        super(context, themeHelper.getDialogStyle());
        this.themeHelper = themeHelper;
    }

    @Override
    public AlertDialog.Builder setView(View view) {
        for (View v : ViewUtil.getAllChildren(view))
            if (v instanceof Themed) ((Themed) v).refreshTheme(themeHelper);
        return super.setView(view);
    }
}
