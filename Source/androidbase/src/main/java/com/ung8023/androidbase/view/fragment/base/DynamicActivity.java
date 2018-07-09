package com.ung8023.androidbase.view.fragment.base;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ung8023.androidbase.R;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("Activity", "onCreate");
        setContentView(R.layout.activity_dynamic);
        initFragment();
    }

    private void initFragment() {
        SampleFragment sampleFragment = new SampleFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_container, sampleFragment, "SampleFragment");
        fragmentTransaction.show(sampleFragment);
        fragmentTransaction.commit();
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
