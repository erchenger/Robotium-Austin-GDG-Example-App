package com.elliott.chenger.robotiumgdgexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button loginBtn;
	private EditText loginEt;
	private AlertDialog.Builder builder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		loginBtn = (Button)findViewById(R.id.login_btn);
		loginBtn.setOnClickListener(clickListener);
		
		loginEt = (EditText)findViewById(R.id.name_input);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			int viewId = v.getId();

			switch(viewId){
				case R.id.login_btn:
					login();
					break;
				default:
					break;
			}

		}
	};
	
	private void showDialogBtn(String title, String message){
		builder = new AlertDialog.Builder(this);
		builder.setTitle(title);
		builder.setCancelable(false);
		builder.setMessage(message);
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		builder.create().show();
	}
	
	private void login(){
		String userName = loginEt.getText().toString();
		if(userName.length()>0){
			Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
			startActivity(intent);
		}
		else{
			showDialogBtn("Error", "No user name");
		}
	}
}
