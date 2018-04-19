package com.ung8023.androidbase.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.ung8023.androidbase.R;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * @author Ung
 * @date 2018/4/18 14:31
 * @description
 */

public class ProgressUtils {

    public static void showViewProgress(@NonNull Window window) {
        addProgressOnWindow(window, R.layout.progress_layout);
    }

    /**
     * 需要添加AVLoadingIndicatorView 支持库
     * @param window
     */
    public static void showAnimationViewProgress(@NonNull Window window) {
        addProgressOnWindow(window, R.layout.progress_animation_layout);
    }

    @SuppressLint("RestrictedApi")
    private static void addProgressOnWindow(@NonNull Window window, @LayoutRes int progressLayoutRes) {
        checkNotNull(window);

        FrameLayout content = getDecorView(window);

        if (content == null) {
            return;
        }

        Context context = content.getContext();

        if (context == null) {
            return;
        }
        View progressView = LayoutInflater.from(context).inflate(progressLayoutRes, content, false);
        content.addView(progressView);
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    @SuppressLint("RestrictedApi")
    public static boolean hideViewProgress(@NonNull Window window) {
        checkNotNull(window);

        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        FrameLayout content = getDecorView(window);

        if (content == null) {
            return false;
        }

        View viewById = content.findViewById(R.id.loadingViewFrame);
        if (viewById != null) {
            content.removeView(content.findViewById(R.id.loadingViewFrame));
            return true;
        }

        return false;
    }

    @SuppressLint("RestrictedApi")
    public static FrameLayout getDecorView(@NonNull Window window) {
        checkNotNull(window);
        View decorView = window.getDecorView();

        if (!(decorView instanceof FrameLayout)) {
            return null;
        }

        return (FrameLayout) decorView;
    }
}
