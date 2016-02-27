package com.mycompany.coryalfordgreeter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Cory on 2/27/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
}
