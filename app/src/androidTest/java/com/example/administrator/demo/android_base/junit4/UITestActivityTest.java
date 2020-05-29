package com.example.administrator.demo.android_base.junit4;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.administrator.demo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2020/5/29.
 */
@RunWith(AndroidJUnit4.class)
public class UITestActivityTest {
    @Rule
    public ActivityTestRule<UITestActivity> rule =
            new ActivityTestRule<>(UITestActivity.class);
    @Test
    public void onCreate() throws Exception {

    }

    @Test
    public void clickTest() {
        //检验：一开始，textView不显示
//        onView(withId(R.id.tv_1))
//                .check(matches(not(isDisplayed())));
        onView(withId(R.id.tv_1))
                .check(matches(withText("下一个")));
    }
}
