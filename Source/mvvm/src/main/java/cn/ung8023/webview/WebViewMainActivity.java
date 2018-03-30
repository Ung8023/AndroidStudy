package cn.ung8023.webview;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.androidstudy.activity.BaseMainActivity;
import cn.ung8023.androidstudy.activity.ActivityEntity;

/**
 * @author feilang-liuyansong
 * @date 2018/3/29 15:42
 * @description
 */

public class WebViewMainActivity extends BaseMainActivity {
    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("LoadImageFromLocalActivity", LoadImageFromLocalActivity.class));
            }
        };
    }
}
