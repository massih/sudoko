package com.androidapp.sudoku;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class SingleGamePageActivity extends Activity {

	private static final String TAG = "SingleGamePageActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_game_page);
		// Show the Up button in the action bar.
		setupActionBar();
		setOnLongClickListener();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.single_game_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void keypadSetNote(View view) {
		Button clickedButton = (Button) view;
		TextView tv = (TextView) findViewById(R.id.testTextView);
		String buttonText = clickedButton.getText().toString();
		tv.append("\n Short clicked button --> " + buttonText);
		Log.v(TAG, "button pressed --> " + buttonText);
	}

	private void setOnLongClickListener() {
		View.OnLongClickListener listener = new View.OnLongClickListener() {
			public boolean onLongClick(View v) {
				Button clickedButton = (Button) v;
				TextView tv = (TextView) findViewById(R.id.testTextView);
				String buttonText = clickedButton.getText().toString();
				tv.append("\n Long clicked button --> " + buttonText);
				Log.v(TAG, "button long pressed --> " + buttonText);
				return true;
			}
		};
		int[] ids = { R.id.keypad_button_1, R.id.keypad_button_2,
				R.id.keypad_button_3, R.id.keypad_button_4,
				R.id.keypad_button_5, R.id.keypad_button_6,
				R.id.keypad_button_7, R.id.keypad_button_8,
				R.id.keypad_button_9 };

		for (int i = 0; i < ids.length; i++) {
			findViewById(ids[i]).setOnLongClickListener(listener);
		}
	}

}
