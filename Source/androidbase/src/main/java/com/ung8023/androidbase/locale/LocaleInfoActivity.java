package com.ung8023.androidbase.locale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ung8023.androidbase.R;

import java.util.Locale;

public class LocaleInfoActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locle_info);
        tv = findViewById(R.id.tv);
    }

    public void getLocale(View view) {
        Locale locale = Locale.getDefault();
        String loStr = locale.getLanguage();

        tv.setText(loStr);
    }
}
