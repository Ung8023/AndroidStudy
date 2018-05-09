package com.androidaddicts.androidtest.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * 需要Context的测试，AndroidTestCase已经过时，
 *
 */
@RunWith(AndroidJUnit4.class)
public class ContextTestCase {

    @Rule
    public ActivityTestRule<TestPlusActivity> mActivityRule = new ActivityTestRule<>(TestPlusActivity.class);

    @Test
    public void testContext() {
        // mActivityRule.getActivity();
    }
}
