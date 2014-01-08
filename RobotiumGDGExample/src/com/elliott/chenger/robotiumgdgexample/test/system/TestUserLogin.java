package com.elliott.chenger.robotiumgdgexample.test.system;

import android.widget.Button;
import android.widget.EditText;

import com.elliott.chenger.robotiumgdgexample.MainActivity;
import com.elliott.chenger.robotiumgdgexample.R;
import com.elliott.chenger.robotiumgdgexample.SecondActivity;

public class TestUserLogin extends AbstractSystemTestBase<MainActivity>{

	public TestUserLogin(){
		super(MainActivity.class);
	}

	public void testUserCanLoginHappyPath(){
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

	public void testUserCanLoginSadPath(){
		assertTrue("Main Activity never started",solo.waitForActivity(MainActivity.class,WAIT_FOR_ACTIVITY_TIMEOUT));

		//Is there a place to put my name
		EditText resultET = (EditText) solo.getView(R.id.name_input);
		assertTrue("Couldn't find the name_input EditText",resultET!=null);

		//Is there a button to log in
		Button resultBtn = (Button)solo.getView(R.id.login_btn);
		assertTrue("Couldn't find the login button",resultBtn != null);

		//Click on the Log in button
		solo.clickOnButton("Log In");

		assertTrue("Log in error dialog never opened!",solo.waitForDialogToOpen(WAIT_FOR_DIALOG_TIMEOUT));
		
		assertTrue("Couldn't find the Title for the Dialog 'Error'",solo.waitForText("Error"));
		assertTrue("Couldn't find the message for the Dialog 'No user name'",solo.waitForText("No user name"));
	}
	
}
