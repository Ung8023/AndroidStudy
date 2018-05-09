package com.androidaddicts.androidtest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.androidaddicts.androidtest.activity.MathUtils;

/**
 * @author feilang-liuyansong
 * @date 2018/5/4 14:56
 * @description
 */

public class CalculateService extends Service {

    int param1;
    int param2;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        parseParams(intent);
        return new CalculateBinder(this);
    }

    private void parseParams(Intent intent) {
        param1 = intent.getIntExtra("param1", 0);
        param2 = intent.getIntExtra("param2", 0);
    }

    public int result() {
        return MathUtils.add(param1, param2);
    }


    static class CalculateBinder extends Binder {

        private CalculateService service;

        CalculateBinder(CalculateService service) {
            this.service = service;
        }

        public CalculateService getService() {
            return service;
        }
    }
}
