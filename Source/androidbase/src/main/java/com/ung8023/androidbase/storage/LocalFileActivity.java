package com.ung8023.androidbase.storage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ung8023.androidbase.R;

import java.io.File;

public class LocalFileActivity extends AppCompatActivity {

    TextView fileTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_file);
        fileTv = findViewById(R.id.fileTv);
    }

    public void getDir(View view) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        fileTv.setText(externalStorageDirectory.getAbsolutePath());
    }
    public void createDir(View view) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory.getAbsolutePath() + File.separator+ "asd");
        fileTv.setText(file.getAbsolutePath());
        if (!file.exists()) {
            boolean b = file.mkdirs();
            Toast.makeText(this, "" + b, Toast.LENGTH_SHORT).show();
        }

    }
}
