package com.sunny.learning.treepic.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.sunny.learning.themeutils.ui.ThemedIcon;
import com.sunny.learning.treepic.R;

/**
 * author: Sunny
 * time: 2018/5/24
 * desc: NavigationDrawer中Item View
 */
public class NavigationEntry extends LinearLayout {
    private ThemedIcon mIvIcon;
    private TextView mTvText;

    public NavigationEntry(Context context) {
        this(context, null);
    }

    public NavigationEntry(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public NavigationEntry(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    /**
     * 设置item文本颜色
     * @param textColor 文本颜色
     */
    public void setTextColor(@ColorInt int textColor) {
        this.mTvText.setTextColor(textColor);
    }

    /**
     * 设置图标颜色
     * @param iconColor 图标颜色
     */
    public void setIconColor(@ColorInt int iconColor) {
        this.mIvIcon.setColor(iconColor);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        setupView();

        View childView = LayoutInflater.from(getContext()).inflate(R.layout.view_navigation_entry, this);
        this.mIvIcon = childView.findViewById(R.id.iv_icon);
        this.mTvText = childView.findViewById(R.id.tv_text);

        if (attrs == null) return;
        setupData(context, attrs);
    }

    private void setupData(Context context, @NonNull AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NavigationEntry);
        String itemIcon = ta.getString(R.styleable.NavigationEntry_itemIcon);
        String itemText = ta.getString(R.styleable.NavigationEntry_itemText);
        ta.recycle();

        setText(itemText);

        if (itemIcon != null)
            setIcon(itemIcon);

    }

    /**
     * 设置LinearLayout的布局展开方向，子View的位置以及LinearLayout的padding
     */
    private void setupView() {
        //设置LinearLayout布局方向
        setOrientation(LinearLayout.HORIZONTAL);
        //设置LinearLayout背景
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_ripple));
        //设置子View摆放位置
        setGravity(Gravity.CENTER_VERTICAL);

        /*
         * NOTE:
         * getDimension()/getDimensionPixelOffset()/getDimensionPixelSize()方法的区别：
         * 这三个方法都是把dimen.xml文件中的dp或者sp数值乘以屏幕的scale值来换算成px单位，scale或者
         * dp,sp的值都有可能是小数，那么换算成px后，数值的小数位怎么处理呢？就依靠这三个方法了，这也是
         * 三个方法的主要区别
         * - getDimension()：返回float型的px值，精确
         * - getDimensionPixelOffset()：返回int型px值，直接忽略小数点后面的数
         * - getDimensionPixelSize()：返回int型px值，四舍五入
         * */
        final int horizontalSpacing = getResources().getDimensionPixelOffset(R.dimen.nav_entry_horizontal_spacing);
        final int verticalSpacing = getResources().getDimensionPixelOffset(R.dimen.nav_entry_vertical_spacing);
        setPadding(horizontalSpacing, verticalSpacing, horizontalSpacing, verticalSpacing);
    }

    private void setText(@Nullable String text) {
        //TextView.setText(CharSequence)方法中的CharSequence类型的参数是可以为空的，
        //方法内部对空值进行了判断：text == null ? "":text
        this.mTvText.setText(text);
    }

    private void setIcon(@NonNull String iconText) {
        this.mIvIcon.setIcon(new IconicsDrawable(getContext(), iconText));
    }
}
