package com.elliott.chenger.robotiumgdgexample.test.system;

import android.widget.Button;
import android.widget.EditText;

import com.elliott.chenger.robotiumgdgexample.MainActivity;
import com.elliott.chenger.robotiumgdgexample.R;
import com.elliott.chenger.robotiumgdgexample.SecondActivity;
import com.elliott.chenger.robotiumgdgexample.customview.CustomEditText;

public class TestCustomViews extends AbstractSystemTestBase<MainActivity>{

	public TestCustomViews() {
		super(MainActivity.class);
	}

	public void testCanEnterTextInCustomEditText(){
		loginToApp();

		//Is there a place to put my name
		CustomEditText resultET = (CustomEditText) solo.getView(R.id.custom_view);
		assertTrue("Couldn't find the name_input EditText",resultET!=null);

		solo.typeText(resultET, "Elliott Chenger");
		assertTrue("Couldn't find the text 'Elliott Chenger' that was typed",solo.searchEditText("Elliott Chenger"));

	}

	private void loginToApp(){
		assertTrue("Main Activity never started",solo.waitForActivity(MainActivity.class,WAIT_FOR_ACTIVITY_TIMEOUT));

		//Is there a place to put my name
		EditText resultET = (EditText) solo.getView(R.id.name_input);
		assertTrue("Couldn't find the name_input EditText",resultET!=null);

		solo.typeText(resultET, "Elliott Chenger");
		assertTrue("Couldn't find the text 'Elliott Chenger' that was typed",solo.searchEditText("Elliott Chenger"));

		//Is there a button to log in
		Button resultBtn = (Button)solo.getView(R.id.login_btn);
		assertTrue("Couldn't find the login button",resultBtn != null);

		//Click on the Log in button
		solo.clickOnButton("Log In");

		assertTrue("Second Activity never started",solo.waitForActivity(SecondActivity.class, WAIT_FOR_ACTIVITY_TIMEOUT));
	}

}
