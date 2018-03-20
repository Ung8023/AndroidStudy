package cn.ung8023.mvvm.data.observablefield;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.ung8023.mvvm.R;
import cn.ung8023.mvvm.databinding.ActivityObservableFieldBinding;

public class ObservableFieldActivity extends AppCompatActivity {

    ActivityObservableFieldBinding observableFieldBinding;
    UserInfo userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        observableFieldBinding = DataBindingUtil.setContentView(this, R.layout.activity_observable_field);

        initData();

    }

    private void initData() {
        userInfo = new UserInfo();
        userInfo.firstName.set("三");
        userInfo.lastName.set("张");
        userInfo.isSuperMan.set(false);
        userInfo.bookNum.set((byte)3);
        userInfo.bookFans.set((short)10);
        userInfo.age.set(20);
        userInfo.money.set(1000000L);
        userInfo.sex.set('X');
        userInfo.bankMoney.set(10000);
        userInfo.dkMoney.set(1233.234123D);
        userInfo.children.add("大傻子");
        observableFieldBinding.setUserInfo(userInfo);
    }

    public void last(View view) {
        userInfo.firstName.set("大力");
        userInfo.lastName.set("张");
        userInfo.isSuperMan.set(true);
        userInfo.bookNum.set((byte)10);
        userInfo.bookFans.set((short)10);
        userInfo.age.set(30);
        userInfo.money.set(1000000000000L);
        userInfo.sex.set('Y');
        userInfo.bankMoney.set(1000000);
        userInfo.dkMoney.set(123123.234123D);
    }

    public void before(View view) {
        userInfo.firstName.set("三");
        userInfo.lastName.set("张");
        userInfo.isSuperMan.set(false);
        userInfo.bookNum.set((byte)3);
        userInfo.bookFans.set((short)10);
        userInfo.age.set(20);
        userInfo.money.set(1000000L);
        userInfo.sex.set('X');
        userInfo.bankMoney.set(10000);
        userInfo.dkMoney.set(1233.234123D);
    }
}
