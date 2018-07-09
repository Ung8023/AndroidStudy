package com.ung8023.androidbase.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.ung8023.androidbase.R;

public class IncludeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_include);

        View viewById = findViewById(R.id.include_lay);
        System.out.println(viewById);

        findViewById(R.id.include_lay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("include_click", "点击了");
            }
        });

    }
}
