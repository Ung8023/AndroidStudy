package com.ung8023.androidbase.activity.config;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ung8023.androidbase.R;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_config);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("ConfigActivity:", "config changed");
        super.onConfigurationChanged(newConfig);
    }

    public void openNew(View view) {
        startActivity(new Intent(this, Config1Activity.class));
    }
}
