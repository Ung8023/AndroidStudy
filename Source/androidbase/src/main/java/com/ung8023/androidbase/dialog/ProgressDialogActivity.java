package com.ung8023.androidbase.dialog;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.ung8023.androidbase.R;

public class ProgressDialogActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
    }


    public void showProgressDialog(View view) {
         ProgressDialog progressDialog = new ProgressDialog(this);
         progressDialog.show();
    }

    public void showProgressOnDocerView(View view) {
        progressDialog.show();
    }

    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
        super.onBackPressed();

    }
}
