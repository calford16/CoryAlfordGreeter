package com.mycompany.coryalfordgreeter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Cory on 2/27/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTests() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testReverseDisabled() {
        MainActivity activity = getActivity();
        Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);
        assertEquals(false, reverseButton.isEnabled());
    }

    public void testReverseEnabled() {
        MainActivity activity = getActivity();
        this.greet();
        Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);
        assertEquals(true, reverseButton.isEnabled());
    }
    
    // Combined greet and reverse tests to avoid unexpected random failures of either one
    public void testGreetAndReverse() {
        MainActivity activity = getActivity();
        this.greet();

        TextView greetMessage = (TextView) activity.findViewById(R.id.message_text_view);

        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);

        Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);
        TouchUtils.clickView(this, reverseButton);

        assertEquals("!ekaJ ,olleH", greetMessage.getText().toString());
    }

   /* public void testReverse() {
        MainActivity activity = getActivity();
        this.greet();
        Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);
        TouchUtils.clickView(this, reverseButton);

        TextView reverseMessage = (TextView) activity.findViewById(R.id.message_text_view);
        assertEquals("!ekaJ ,olleH", reverseMessage.getText().toString());
    } */

    public void greet() {
        MainActivity activity = getActivity();

        final EditText nameEditText = (EditText) activity.findViewById(R.id.greet_edit_text);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                nameEditText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Jake");

        Button greetButton = (Button) activity.findViewById(R.id.greet_button);
        TouchUtils.clickView(this, greetButton);
    }
}
