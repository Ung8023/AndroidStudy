package com.androidaddicts.androidtest.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @date 2018/5/4 10:04
 * @description
 */

public class AdderTest{

    Adder mAdder;
    AssertSample assertSample;

    @Test
    public void testAdd() {
        assertEquals(0, mAdder.add(0, 0));
        assertEquals(1, mAdder.add(1, 0));
        assertEquals(0, mAdder.add(-1, 1));
        assertEquals(Integer.MAX_VALUE + 1, mAdder.add(Integer.MAX_VALUE, 1));
        assertEquals(Integer.MIN_VALUE - 1, mAdder.add(Integer.MIN_VALUE, -1));
    }

    @Test
    public void asserts() {
        assertEquals(1, assertSample.getEqualsInt(1));
        assertNotEquals(1, assertSample.getNotEqualsInt(1));

        assertTrue(assertSample.getTrue());
        assertFalse(assertSample.getFalse());

        assertNotNull(assertSample.getNotNull());
        assertNull(assertSample.getNull());

        Object o = new Object();
        assertSame(o, assertSample.getSameObject(o));
        assertNotSame(o, assertSample.getDifferentObject(o));

    }

    @Before
    public void setUp() {
        mAdder = new AdderImpl();
        assertSample = new AssertSample();
    }

    @After
    public void release() {
        mAdder = null;
    }

}
