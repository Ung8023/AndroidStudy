package com.androidaddicts.androidtest.sample;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author Ung
 * @date 2018/4/17 13:31
 * @description
 */
public class JavaTestDemoTest {

    JavaTestDemo demo;

    @Before
    public void setUp() {
        demo = new JavaTestDemo();
        System.out.println("init");
    }

    @After
    public void release() {
        demo = null;
        System.out.println("release");
    }

    @Test
    public void add() throws Exception {
        int sum = demo.add(12, 12);
        Assert.assertEquals(24, sum);
    }

    @Ignore
    @Test
    public void ignoreThis() {
        System.out.println("ignoreThis");
    }

    @Test(timeout = 1000)
    public void timeOk() {
        System.out.println("time ok");
    }

    @Test(timeout = 1000)
    public void timeFalse() {
        System.out.println("time false");
        while (true);
    }

    @Test(expected = ArithmeticException.class)
    public void testException() {
        int a = 1 /0;
    }
}