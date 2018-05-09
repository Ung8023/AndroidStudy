package com.androidaddicts.androidtest.mock;

/**
 * @author feilang-liuyansong
 * @date 2018/5/4 11:30
 * @description
 */

public class MockCallBack {

    public String doWithCallback(Callback callback) {
        return callback.callBack();
    }

    public void doNothing() {

    }

    interface Callback {
        String callBack();
    }
}
