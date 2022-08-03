package com.gkb.virtusatest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ScheduleEcpListTest {
    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(ScheduledEcplistActivity::class.java)
    @Before
    fun init(){

    }
    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(ScheduledEcplistActivity::class.java)
    }
    @Test
    fun testRecyclerViewItem(){
        onData(instanceOf(String::class.java))
            .inAdapterView(withId(R.id.failed))
            .atPosition(5)
            .onChildView(withId(R.id.paylinkf))
            .perform(click());
    }

}
