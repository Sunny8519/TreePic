package com.sunny.learning.themeutils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class ThemedViewHolder extends RecyclerView.ViewHolder implements Themed {

    public ThemedViewHolder(View view) {
        super(view);
    }

}