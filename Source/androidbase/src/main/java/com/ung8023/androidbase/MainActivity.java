package com.ung8023.androidbase;

import com.ung8023.androidbase.activity.ListAboutActivity;
import com.ung8023.androidbase.dialog.DialogActivity;
import com.ung8023.androidbase.locale.LocaleMainActivity;
import com.ung8023.androidbase.process.ProcessMainActivity;
import com.ung8023.androidbase.storage.LocalFileActivity;
import com.ung8023.androidbase.sys.MainSysActivity;
import com.ung8023.androidbase.view.ViewActivity;
import com.ung8023.androidbase.view.fragment.FragmentMainActivity;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;

public class MainActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("Activity相关", ListAboutActivity.class));
                add(new ActivityEntity("本地文件存储", LocalFileActivity.class));
                add(new ActivityEntity("Progress", DialogActivity.class));
                add(new ActivityEntity("Process", ProcessMainActivity.class));
                add(new ActivityEntity("View", ViewActivity.class));
                add(new ActivityEntity("Fragment", FragmentMainActivity.class));
                add(new ActivityEntity("系统信息", MainSysActivity.class));
                add(new ActivityEntity("Locale", LocaleMainActivity.class));
            }
        };
    }
}