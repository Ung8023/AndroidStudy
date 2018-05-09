package com.androidaddicts.androidtest.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.androidaddicts.androidtest.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

/**
 * @author feilang-liuyansong
 * @date 2018/5/4 14:31
 * @description
 */

@RunWith(AndroidJUnit4.class)
public class TestPlusActivityTest {

    @Rule
    public ActivityTestRule<TestPlusActivity> mActivityRule = new ActivityTestRule<>(TestPlusActivity.class);

    TestPlusActivity activity;

    @Before
    public void setUp () {
        activity = mActivityRule.getActivity();
    }

    @Test
    public void doSomeThing() {
        assertNotNull(activity.userNameET);
        assertNotNull(activity.passwordEt);
        assertNotNull(activity.loginBtn);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.userNameET.setText("username");
                activity.passwordEt.setText("password");
                activity.loginBtn.performClick();
            }
        });

    }

    @Test
    public void login() {
        onView(withId(R.id.et_user_name)).check(matches(isDisplayed()));
        onView(withId(R.id.et_user_name)).perform(typeText("username"));
        onView(withId(R.id.et_pass_word)).perform(typeText("password"));
        onView(withId(R.id.btn_login)).perform(click());
    }
}
