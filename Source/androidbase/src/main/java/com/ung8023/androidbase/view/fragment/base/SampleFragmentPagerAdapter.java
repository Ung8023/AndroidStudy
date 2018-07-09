package com.ung8023.androidbase.view.fragment.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> mList;

    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public SampleFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.mList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }
}
