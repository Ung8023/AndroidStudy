package com.ung8023.androidbase.view.define;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

public class MViewGroup extends ViewGroup {
    public MViewGroup(Context context) {
        super(context);
    }

    public MViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.w("ViewGroup on Measure", (String)getTag());
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
