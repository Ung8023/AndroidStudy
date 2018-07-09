package com.ung8023.androidbase.view.define;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.ung8023.androidbase.R;

public class GetHeightSampleActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_height);
        textView = findViewById(R.id.tv);

        textView.post(new Runnable() {

            @Override
            public void run() {
                Log.w("tv_width", "" + textView.getWidth());
                Log.w("tv_height", "" + textView.getHeight());
            }
        });

        final ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
                Log.w("tv_width", "" + textView.getWidth());
                Log.w("tv_height", "" + textView.getHeight());
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Log.w("tv_width", "" + textView.getWidth());
            Log.w("tv_height", "" + textView.getHeight());
        }
    }
}
