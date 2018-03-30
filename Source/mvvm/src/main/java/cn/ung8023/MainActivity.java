package cn.ung8023;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.base.ListActivity;
import cn.ung8023.androidstudy.base.ListItemViewHolder;
import cn.ung8023.mvvm.data.observableclass.ObservableClassActivity;
import cn.ung8023.mvvm.data.observablefield.ObservableFieldActivity;
import cn.ung8023.mvvm.main.ActivityEntity;
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
