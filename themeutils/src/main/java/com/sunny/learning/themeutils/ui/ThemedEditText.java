package com.sunny.learning.themeutils.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.sunny.learning.themeutils.ThemeHelper;
import com.sunny.learning.themeutils.Themed;

public class ThemedEditText extends android.support.v7.widget.AppCompatEditText implements Themed {

    public ThemedEditText(Context context) {
        this(context, null);
    }

    public ThemedEditText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThemedEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //setBackgroundResource(android.R.color.transparent);
    }

    @Override
    public void refreshTheme(ThemeHelper theme) {
        setTextColor(theme.getTextColor());
        setHintTextColor(theme.getSubTextColor());
        setHighlightColor(theme.getPrimaryColor());
        //ThemeHelper.setCursorColor(this, themeViews.getAccentColor());
        //setBackgroundTintList(themeViews.getTintList());
        //setBaseColor(themeViews.getAccentColor());
        //setUnderlineColor(themeViews.getAccentColor());
    }
}
