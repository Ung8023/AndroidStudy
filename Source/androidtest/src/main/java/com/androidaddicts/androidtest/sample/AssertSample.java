package com.androidaddicts.androidtest.sample;

/**
 * @date 2018/5/4 10:13
 * @description
 */

public class AssertSample {
    public int getEqualsInt(int value) {
        return value;
    }

    public int getNotEqualsInt(int value) {
        return ~value;
    }

    public boolean getTrue() {
        return true;
    }

    public boolean getFalse() {
        return false;
    }

    public Object getNull() {
        return null;
    }

    public Object getNotNull() {
        return new Object();
    }

    public Object getSameObject(Object object) {
        return object;
    }

    public Object getDifferentObject(Object object) {
        return new Object();
    }
}
