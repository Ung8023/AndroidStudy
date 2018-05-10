package com.androidaddicts.opengl.foundation.openglbase.transform;

import com.androidaddicts.opengl.foundation.openglbase.transform.translate.TranslateActivity;
import com.androidaddicts.opengl.foundation.openglbase.triangle.OpenglTriangleActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class TransformMainActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>() {
            {
                add(new ActivityEntity("平移变换", TranslateActivity.class));
            }
        };
    }
}
