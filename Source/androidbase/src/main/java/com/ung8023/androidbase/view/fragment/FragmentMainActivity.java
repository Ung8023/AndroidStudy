package com.ung8023.androidbase.view.fragment;

import com.ung8023.androidbase.view.fragment.base.DynamicActivity;
import com.ung8023.androidbase.view.fragment.base.StaticFragmentActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class FragmentMainActivity extends BaseMainActivity {
    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>() {
            {
                add(new ActivityEntity("静态使用Fragment", StaticFragmentActivity.class));
                add(new ActivityEntity("动态使用Fragment", DynamicActivity.class));
            }
        };
    }
}
