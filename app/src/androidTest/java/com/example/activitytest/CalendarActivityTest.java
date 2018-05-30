package com.example.activitytest;
//Created by Jerry on 2018/5/30

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalendarActivityTest{

    @Rule
    public ActivityTestRule<CalendarActivity> mActivityTestRule =
            new ActivityTestRule<>(CalendarActivity.class);

    @Test
    public void testCalendar(){
        //查看标题栏的日期能否正常显示
        onView(allOf(withId(R.id.toolbarTitle), isDisplayed()));
        //测试日历控件的滑屏功能
        onView(allOf(withId(R.id.calendar), isDisplayed())).perform(swipeLeft(),click());
        //测试点击顶部图片回到当前日期的功能
        onView(allOf(withId(R.id.calendar_picture), isDisplayed())).perform(click());
        //测试RecyclerView的折叠滑屏功能
        onView(allOf(withId(R.id.recycler_view))).perform(scrollToPosition(4));
        //测试TimePicker的自定义日期功能
        onView(allOf(withId(R.id.selectDate), isDisplayed())).perform(click());
        onView(allOf(withText("CONFIRM"))).perform(click());

    }

}
