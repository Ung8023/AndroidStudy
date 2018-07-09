package com.ung8023.androidbase.view;

import com.ung8023.androidbase.view.define.GetHeightActivity;
import com.ung8023.androidbase.view.define.GetHeightSampleActivity;
import com.ung8023.androidbase.view.define.LayoutActivity;
import com.ung8023.androidbase.view.define.MeasureActivity;
import com.ung8023.androidbase.view.define.ViewDrawActivity;
import com.ung8023.androidbase.view.scroll.ScrollMainActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class ViewActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("移除View", RemoveViewActivity.class));
                add(new ActivityEntity("TextView显示", TextViewActivity.class));
                add(new ActivityEntity("Ripple显示", RippleActivity.class));
                add(new ActivityEntity("SearchView显示", SearchViewActivity.class));
                add(new ActivityEntity("include显示", IncludeActivity.class));
                add(new ActivityEntity("View滚动相关", ScrollMainActivity.class));
                add(new ActivityEntity("ViewMeasure过程", MeasureActivity.class));
                add(new ActivityEntity("View的宽高", GetHeightActivity.class));
                add(new ActivityEntity("View的准确宽高", GetHeightSampleActivity.class));
                add(new ActivityEntity("View的Layout过程", LayoutActivity.class));
                add(new ActivityEntity("View的Draw过程", ViewDrawActivity.class));
                add(new ActivityEntity("XML定义Shape", ShapeXmlActivity.class));
            }
        };
    }
}