package com.euphonyforever.looking_for_job

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InputInfoBehaviorTest {

    @get:Rule
    var activityRule: ActivityTestRule<InputResumeInfo> = ActivityTestRule(InputResumeInfo::class.java)

    val name = "홍길동"
    val birth = "20000101"
    val tel = "01012345678"
    val address = "서울시"
    val career = "신입"

    @Test
    fun testInputInfoAccuracy() {
        // name
        onView(withId(R.id.inputName))
                .perform(replaceText(name), closeSoftKeyboard())
                .check(matches(withText(name)))

        // birth
        onView(withId(R.id.inputBirth))
                .perform(replaceText(birth), closeSoftKeyboard())
                .check(matches(withText(birth)))

        // tel
        onView(withId(R.id.inputNumber))
                .perform(replaceText(tel), closeSoftKeyboard())
                .check(matches(withText(tel)))

        // address
        onView(withId(R.id.inputAddress))
                .perform(replaceText(address), closeSoftKeyboard())
                .check(matches(withText(address)))

        // career
        onView(withId(R.id.inputCareer))
                .perform(replaceText(career), closeSoftKeyboard())
                .check(matches(withText(career)))

    }

}