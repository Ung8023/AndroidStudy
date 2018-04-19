package com.ung8023.androidbase.dialog;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

/**
 * @author Ung
 * @date 2018/4/13 22:07
 * @description
 */

public class DialogActivity extends BaseMainActivity {
    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>() {
            {
                add(new ActivityEntity("ProgressDialog", ProgressDialogActivity.class));
            }
        };
    }
}
