package com.sunny.learning.treepic.viewdelegate;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.learning.sunny.basemvp.view.BaseActivityViewDelegate;
import com.sunny.learning.themeutils.ColorPalette;
import com.sunny.learning.treepic.App;
import com.sunny.learning.treepic.R;
import com.sunny.learning.treepic.databinding.ActivitySplashScreenBinding;

/**
 * author: Sunny
 * time: 2018/3/17
 * desc:
 */

public class SplashActivityViewDelegate extends BaseActivityViewDelegate<ActivitySplashScreenBinding> {
    @Override
    public int getRootLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public void initWidget() {
        /*
        * http://www.360doc.com/content/15/0204/18/20385871_446270224.shtml
        * https://www.cnblogs.com/8dull/p/5383135.html
        *
        * View.SYSTEM_UI_FLAG_FULLSCREEN:表示Activity全屏显示,且状态栏被隐藏覆盖
        * View.SYSTEM_UI_FLAG_HIDE_NAVIGATION:隐藏虚拟按键(导航栏)*/
        getActivity().getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        setNavBarColor();
        setStatusBarColor();
    }

//    private void

    /*设置导航栏颜色*/
    private void setNavBarColor() {
        /*如果系统版本大于等于5.0*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().getWindow().setNavigationBarColor(ColorPalette.getTransparentColor(
                    ContextCompat.getColor(App.getInstance(), R.color.md_black_1000), 70));
        }
    }

    /*设置状态栏颜色*/
    private void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().getWindow().setStatusBarColor(ColorPalette.getTransparentColor(
                    ContextCompat.getColor(App.getInstance(), R.color.accent_orange), 70));
        }
    }
}
