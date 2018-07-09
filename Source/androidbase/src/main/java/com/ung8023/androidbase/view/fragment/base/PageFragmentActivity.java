package com.ung8023.androidbase.view.fragment.base;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ung8023.androidbase.R;

import java.util.ArrayList;

public class PageFragmentActivity extends AppCompatActivity {

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_fragment);

        mViewPager = findViewById(R.id.vp_fragments);

        setUpViewPager();
    }

    private void setUpViewPager() {
        SampleFragmentPagerAdapter adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager(), new ArrayList<Fragment>(){
            {
            }
        });
    }
}
