package com.euphonyforever.looking_for_job

import android.view.KeyEvent
import androidx.core.content.ContextCompat.startActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class ButtonTest {
    @get:Rule
    val activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun SendButtonClick() {

        onView(withId(R.id.btnSend))
            .perform(click())

        intended(hasComponent())
        intended(toPackage("com.android.phone"))
    }

    @Test
    fun SendButtonClick2() {
        val activityScenarioRule = activityScenarioRule<InputResumeInfo>()
        // Unresolved reference: activityScenarioRule
        val scenario = activityScenarioRule.scenario
    }

}

