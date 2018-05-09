package com.androidaddicts.androidtest.activity;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @author feilang-liuyansong
 * @date 2018/5/4 13:20
 * @description
 */
@RunWith(AndroidJUnit4.class)
public class MathUtilsTest {

    @Test
    public void testAdd() {
        assertEquals(0, MathUtils.add(0, 0));
        assertEquals(1, MathUtils.add(1, 0));
        assertEquals(2, MathUtils.add(1, 1));
        assertEquals(Integer.MAX_VALUE + 1, MathUtils.add(Integer.MAX_VALUE, 1));
        assertEquals(Integer.MIN_VALUE - 1, MathUtils.add(Integer.MIN_VALUE, -1));

    }

    @Test
    public void testOthers() {

        assertEquals(2, 5);
    }
}
