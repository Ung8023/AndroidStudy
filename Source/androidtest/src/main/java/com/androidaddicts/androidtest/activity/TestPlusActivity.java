package com.androidaddicts.androidtest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidaddicts.androidtest.R;

public class TestPlusActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userNameET;
    EditText passwordEt;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_plus);

        initViews();
    }

    private void initViews() {
        userNameET = findViewById(R.id.et_user_name);
        passwordEt = findViewById(R.id.et_pass_word);
        loginBtn = findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            default:
                break;
        }
    }

    private void login() {
        Toast.makeText(this, "Login", Toast.LENGTH_LONG).show();
    }
}
