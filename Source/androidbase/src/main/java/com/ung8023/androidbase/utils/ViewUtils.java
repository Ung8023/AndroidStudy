package com.ung8023.androidbase.utils;

import android.annotation.SuppressLint;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * @author Ung
 * @date 2018/4/18 15:16
 * @description
 */

public class ViewUtils {
    /**
     * 将view从原来的View中移除
     * @param view
     */
    @SuppressLint("RestrictedApi")
    public static void removeSelf(@NonNull View view) {
        checkNotNull(view);

        ViewParent parent = view.getParent();

        if (parent == null || !(parent instanceof ViewGroup)) {
            return;
        }

        ViewGroup viewGroup = (ViewGroup) parent;

        viewGroup.removeView(view);
    }

    @SuppressLint("RestrictedApi")
    public static void removeSelf(@NonNull ViewGroup viewGroup, @IdRes int viewId) {
        checkNotNull(viewGroup);
        View findView = viewGroup.findViewById(viewId);

        if (findView == null) {
            return;
        }
        removeSelf(findView);
    }
}
