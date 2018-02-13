package com.sunny.learning.themeutils.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.sunny.learning.themeutils.R;
import com.sunny.learning.themeutils.ThemeHelper;
import com.sunny.learning.themeutils.Themed;

public class ThemedTextView extends AppCompatTextView implements Themed {

    int color;

    public ThemedTextView(Context context) {
        this(context, null);
    }

    public ThemedTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThemedTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ThemedTextView,
                0, 0);
        color = a.getInt(R.styleable.ThemedTextView_type, 3);
        a.recycle();
    }

    @Override
    public void refreshTheme(ThemeHelper theme) {
        switch (color) {
            case 1:
                setTextColor(theme.getAccentColor());
                break;
            case 2:
                setTextColor(theme.getPrimaryColor());
                break;
            case 3:
            default:
                setTextColor(theme.getTextColor());
                break;
            case 4:
                setTextColor(theme.getSubTextColor());
                break;
        }
    }
}
