package com.ung8023.androidbase.view.define;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CustomFloatingView extends View {
    public CustomFloatingView(Context context) {
        super(context);
    }

    public CustomFloatingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomFloatingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        setLeft(layoutParams.leftMargin);
        setTop(400);
        setRight(width + layoutParams.leftMargin);
        setBottom(400 + layoutParams.topMargin + height);
    }

}
