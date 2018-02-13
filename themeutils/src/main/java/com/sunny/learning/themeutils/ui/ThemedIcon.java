package com.sunny.learning.themeutils.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.view.IconicsImageView;
import com.sunny.learning.themeutils.ThemeHelper;
import com.sunny.learning.themeutils.Themed;

public class ThemedIcon extends IconicsImageView implements Themed {
    public ThemedIcon(Context context) {
        this(context, null);
    }

    public ThemedIcon(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThemedIcon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void refreshTheme(ThemeHelper theme) {
        setColor(theme.getIconColor());
    }

    public void setColor(int color) {
        setIcon(getIcon().color(color));
    }

    public void setIcon(IIcon icon) {
        setIcon(getIcon().icon(icon));
    }
}
