package com.ung8023.androidbase.sys;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ung8023.androidbase.R;

public class SimActivity extends AppCompatActivity {



    public void getPhoneInfo(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int i = checkSelfPermission(Manifest.permission.READ_PHONE_STATE);
            if (i != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
            }else {
                readData();
            }
        }else {
            readData();
        }
    }

    private void readData() {
        PhoneUtils phoneUtils = new PhoneUtils(this);
        String nativePhoneNumber = phoneUtils.getNativePhoneNumber();
        String phoneInfo = phoneUtils.getPhoneInfo();
        TextView textView = findViewById(R.id.tv_phone_info);
        textView.setText(nativePhoneNumber + "\n" + phoneInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);
    }
}
