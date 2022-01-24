package com.example.simpleparadox.listycity;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * Test class for MainActivity. All the UI tests are written here. Robotium test framework is
 used
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest{
    private Solo solo;
    @Rule
    public ActivityTestRule<MainActivity> rule =

            new ActivityTestRule<>(MainActivity.class, true, true);
    /**
     * Runs before all tests and creates solo instance.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }
    /**
     * Gets the Activity
     * @throws Exception
     */
  
       @Test
        public void checkList(){
        //Asserts that the current activity is the MainActivity. Otherwise, show “Wrong Activity”
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button
            //Get view for EditText and enter a city name
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Khulna");
        solo.clickOnButton("CONFIRM"); //Select CONFIRM Button


        ListView ListView=(ListView)solo.getView(R.id.city_list);
        View view=ListView.getChildAt(0);

        solo.clickOnView(ListView);
        solo.assertCurrentActivity("Wrong Activity", showActivity.class);
        solo.clickOnButton("BACK");

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button
        //Get view for EditText and enter a city name
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Rajsahi");
        solo.clickOnButton("CONFIRM"); //Select CONFIRM Button


        solo.clearEditText((EditText) solo.getView(R.id.editText_name)); //Clear the EditText
        assertTrue(solo.waitForText("Rajsahi", 1, 2000));
        solo.clickOnButton("ClEAR ALL"); //Select ClEAR ALL
        

    }
    
   
    /**
     * Close activity after each test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}