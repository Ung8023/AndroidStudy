package com.androidaddicts.androidtest.activity;

/**
 * @author feilang-liuyansong
 * @date 2018/5/4 13:19
 * @description
 */

public final class MathUtils {

    private MathUtils() {
        throw new IllegalArgumentException("This class can't create a instance");
    }

    public static int add(int a, int b) {
        return a + b;
    }

}
