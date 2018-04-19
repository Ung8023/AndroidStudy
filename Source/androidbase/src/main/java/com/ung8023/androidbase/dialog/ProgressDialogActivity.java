package com.ung8023.androidbase.dialog;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ung8023.androidbase.R;
import com.ung8023.androidbase.utils.ProgressUtils;

public class ProgressDialogActivity extends AppCompatActivity {

    // ------------------------------------------------------------------
    // Constants
    // ------------------------------------------------------------------

    private static final String TAG = "ProgressDialogActivity";

    // ------------------------------------------------------------------
    // Properties
    // ------------------------------------------------------------------

    ProgressDialog progressDialog;

    // ------------------------------------------------------------------
    // Constructors
    // ------------------------------------------------------------------

    // implement Constructors here

    // ------------------------------------------------------------------
    // Lifecycle methods
    // ------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    // ------------------------------------------------------------------
    // Override methods
    // ------------------------------------------------------------------

    @Override
    public void onBackPressed() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        boolean hideViewProgress = ProgressUtils.hideViewProgress(getWindow());
        if (hideViewProgress) {
            return;
        }
        super.onBackPressed();
    }

    // ------------------------------------------------------------------
    // Interface1 Implements
    // ------------------------------------------------------------------


    // ------------------------------------------------------------------
    // Interface2 Implements
    // ------------------------------------------------------------------


    // ------------------------------------------------------------------
    // public methods
    // ------------------------------------------------------------------

    // implement public methods here

    // ------------------------------------------------------------------
    // protected methods
    // ------------------------------------------------------------------

    // implement protected methods here

    // ------------------------------------------------------------------
    // action methods
    // ------------------------------------------------------------------

    public void showProgressDialog(final View view) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();
    }

    public void showProgressOnDecorView(View view) {
        ProgressUtils.showViewProgress(getWindow());
    }

    public void showProgressAV(View view) {
        ProgressUtils.showAnimationViewProgress(getWindow());
    }

    // ------------------------------------------------------------------
    // getters and setters methods
    // ------------------------------------------------------------------


    // ------------------------------------------------------------------
    // private methods
    // ------------------------------------------------------------------

    // implement private methods here

    // ------------------------------------------------------------------
    // inner classes or interfaces
    // ------------------------------------------------------------------

}
