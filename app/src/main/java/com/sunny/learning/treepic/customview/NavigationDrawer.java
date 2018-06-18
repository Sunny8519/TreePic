package com.sunny.learning.treepic.customview;

import android.content.Context;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * author: Sunny
 * time: 2018/5/22
 * desc: 自定义抽屉View
 */

public class NavigationDrawer extends ScrollView {

    public static final int NAVIGATION_ITEM_ALL_ALBUMS = 1;
    public static final int NAVIGATION_ITEM_ALL_MEDIA = NAVIGATION_ITEM_ALL_ALBUMS << 1;
    public static final int NAVIGATION_ITEM_HIDDEN_DIR = NAVIGATION_ITEM_ALL_ALBUMS << 2;
    public static final int NAVIGATION_ITEM_WALLPAPER = NAVIGATION_ITEM_ALL_ALBUMS << 3;
    public static final int NAVIGATION_ITEM_SETTING = NAVIGATION_ITEM_ALL_ALBUMS << 4;
    public static final int NAVIGATION_ITEM_ABOUT = NAVIGATION_ITEM_ALL_ALBUMS << 5;

    @IntDef({NAVIGATION_ITEM_ALL_ALBUMS, NAVIGATION_ITEM_ALL_MEDIA,
            NAVIGATION_ITEM_HIDDEN_DIR, NAVIGATION_ITEM_WALLPAPER,
            NAVIGATION_ITEM_SETTING, NAVIGATION_ITEM_ABOUT})
    public @interface NavigationItem {
    }

    public NavigationDrawer(Context context) {
        this(context, null);
    }

    public NavigationDrawer(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {

    }
}
