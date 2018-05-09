package com.androidaddicts.androidtest.service;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static android.support.test.InstrumentationRegistry.*;
import static org.junit.Assert.*;

/**
 * @author feilang-liuyansong
 * @date 2018/5/4 14:58
 * @description
 */

@RunWith(AndroidJUnit4.class)
public class CalculateServiceTest {

    @Rule
    public final ServiceTestRule serviceTestRule = new ServiceTestRule();

    @Test
    public void testWithStartService() {
        try {
            Intent intent = new Intent(getTargetContext(), CalculateService.class);
            intent.putExtra("param1", 10);
            intent.putExtra("param2", 20);
            IBinder iBinder = serviceTestRule.bindService(intent);
            CalculateService calculateService = ((CalculateService.CalculateBinder)iBinder).getService();
            int result = calculateService.result();
            assertEquals(30, result);

        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @After
    public void release() {
        serviceTestRule.unbindService();
    }

}