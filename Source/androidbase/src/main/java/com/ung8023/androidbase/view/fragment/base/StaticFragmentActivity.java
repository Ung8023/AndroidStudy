package com.ung8023.androidbase.view.fragment.base;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;

import com.ung8023.androidbase.R;

public class StaticFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("Activity", "onCreate");
        setContentView(R.layout.activity_static_fragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("Activity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Activity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Activity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("Activity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("Activity", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("Activity", "onRestart");
    }
}
