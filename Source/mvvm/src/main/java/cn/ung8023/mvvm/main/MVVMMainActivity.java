package cn.ung8023.mvvm.main;

import java.util.ArrayList;
import java.util.List;

import cn.ung8023.BaseMainActivity;
import cn.ung8023.mvvm.data.observableclass.ObservableClassActivity;
import cn.ung8023.mvvm.data.observablefield.ObservableFieldActivity;

public class MVVMMainActivity extends BaseMainActivity {

    @Override
    protected List<ActivityEntity> getData() {
        return new ArrayList<ActivityEntity>(){
            {
                add(new ActivityEntity("ObservableClass", ObservableClassActivity.class));
                add(new ActivityEntity("ObservableFields", ObservableFieldActivity.class));
            }
        };
    }

}
