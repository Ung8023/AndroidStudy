package com.ung8023.androidbase.activity.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ung8023.androidbase.R;

public class BaseLaunchModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_launch_mode);
    }

    public void startStandard(View view) {
        startAc(StandardActivity.class);
    }

    public void startSingleTop(View view) {
        startAc(SingleTopActivity.class);
    }

    public void startSingleTask(View view) {
        startAc(SingleTaskActivity.class);
    }

    public void startSingleInstance(View view) {
        startAc(SingleInstanceActivity.class);
    }

    public void startSingleInstance2(View view) {
        startAc(SingleInstance2Activity.class);
    }

    public void startStandardClearTop(View view) {
        startClearTop(StandardActivity.class);
    }

    public void startSingleTopClearTop(View view) {
        startClearTop(SingleTopActivity.class);
    }

    public void startSingleTaskClearTop(View view) {
        startClearTop(SingleTaskActivity.class);
    }

    public void newTaskClearTask(View view) {
        Intent intent = new Intent(this, StandardTwoActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void startSingleInstanceClearTop(View view) {
        startClearTop(SingleInstanceActivity.class);
    }

    public void startSingleInstanceClearTop2(View view) {
        startClearTop(SingleInstance2Activity.class);
    }

    private void startAc(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void startClearTop(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }



}
