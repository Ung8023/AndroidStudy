package com.androidaddicts.androidtest.sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 通过套件，将一些测试类一起运行
 *
 * @date 2018/5/4 10:23
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdderTest.class,
        JavaTestDemoTest.class
})
public class TestSuite {
}
