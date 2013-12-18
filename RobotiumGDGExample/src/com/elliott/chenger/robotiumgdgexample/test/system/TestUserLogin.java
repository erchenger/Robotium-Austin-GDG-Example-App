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
		assertTrue(resultET!=null);
		
		solo.typeText(resultET, "Elliott Chenger");
		assertTrue(solo.searchEditText("Elliott Chenger"));

		//Is there a button to log in
		Button resultBtn = (Button)solo.getView(R.id.login_btn);
		assertTrue(resultBtn != null);

		//Click on the Log in button
		solo.clickOnButton("Log In");

		assertTrue("Second Activity never started",solo.waitForActivity(SecondActivity.class, WAIT_FOR_ACTIVITY_TIMEOUT));
	}

	public void testUserCanLoginSadPath(){
		assertTrue("Main Activity never started",solo.waitForActivity(MainActivity.class,WAIT_FOR_ACTIVITY_TIMEOUT));

		//Is there a place to put my name
		EditText resultET = (EditText) solo.getView(R.id.name_input);
		assertTrue(resultET!=null);

		//Is there a button to log in
		Button resultBtn = (Button)solo.getView(R.id.login_btn);
		assertTrue(resultBtn != null);

		//Click on the Log in button
		solo.clickOnButton("Log In");

		assertTrue("Log in error dialog never opened!",solo.waitForDialogToOpen(WAIT_FOR_DIALOG_TIMEOUT));
		
		assertTrue(solo.waitForText("Error"));
		assertTrue(solo.waitForText("No user name"));
	}
	
	public void testUserClicksDialog(){
		assertTrue("Main Activity never started",solo.waitForActivity(MainActivity.class,WAIT_FOR_ACTIVITY_TIMEOUT));

		Button resultBtn = (Button)solo.getView(R.id.dialog_btn);
		assertTrue(resultBtn!=null);
		
		solo.clickOnButton("Dialog");
		
		assertTrue("This is an example of a dialog",solo.waitForDialogToOpen(WAIT_FOR_DIALOG_TIMEOUT));
		assertTrue(solo.waitForText("Dialog"));

	}
}
