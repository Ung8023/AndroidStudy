package cn.ung8023;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.ActivityEntity;
import cn.ung8023.androidstudy.activity.BaseMainActivity;
import cn.ung8023.mvvm.main.MVVMMainActivity;
import cn.ung8023.webview.WebViewMainActivity;

public class MainActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("MVVM", MVVMMainActivity.class));
                add(new ActivityEntity("WebView", WebViewMainActivity.class));
            }
        };
    }
}
