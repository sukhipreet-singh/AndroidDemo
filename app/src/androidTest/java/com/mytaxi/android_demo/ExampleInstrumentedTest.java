package com.mytaxi.android_demo;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.mytaxi.android_demo.activities.MainActivity;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.InstrumentationRegistry.getContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 15)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void setUp() {
        //Before Test case execution
    }

    @Test
    public void login() throws InterruptedException {
        UserInfo details = new UserInfo(getContext());
        String loginData[] = details.getLoginDetails();
        Thread.sleep(5000);
        onView(withId(R.id.edt_username)).perform(typeText(loginData[0]), closeSoftKeyboard());
        onView(withId(R.id.edt_password)).perform(typeText(loginData[1]), closeSoftKeyboard());
        /* onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        onView(withId(R.id.edt_password)).perform(typeText("venture"));*/
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.textSearch)).perform(typeText("sa"));




        //Thread.sleep(5000);
        //onView(withText("Sarah Scott")).perform(click());
        onView(withText("Sarah Scott")).inRoot(RootMatchers.isPlatformPopup()).perform(click());

        //Thread.sleep(5000);
        onView(withId(R.id.fab)).perform(click());
        //Thread.sleep(5000);

    }

    @After
    public void tearDown() {
        //After Test case Execution
    }
}
