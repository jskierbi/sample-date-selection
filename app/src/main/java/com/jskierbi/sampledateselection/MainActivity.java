package com.jskierbi.sampledateselection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends Activity {

	private EditText editT1;
	private Button btn1;

	private int mYear;
	private int mMonth;
	private int mDay;

	static final int CALENDAR_VIEW_ID = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		// editText1
		editT1 = (EditText) findViewById(R.id.editText1);

		// button1
		btn1 = (Button) findViewById(R.id.button1);

		// add a click listener to the button
		btn1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CalendarViewActivity.class);
				startActivityForResult(intent, CALENDAR_VIEW_ID);
			}
		});

		// get the current date
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		// display the current date
		updateCurrentDate();

	}

	// updates the date we display in the TextView
	private void updateCurrentDate() {
		editT1.setText(
				new StringBuilder()
						// Month is 0 based so add 1
						.append(mMonth + 1).append("-")
						.append(mDay).append("-")
						.append(mYear).append(" "));
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case CALENDAR_VIEW_ID:
			if (resultCode == RESULT_OK) {

				Bundle bundle = data.getExtras();
				editT1.setText(bundle.getString("dateSelected"));
				break;
			}
		}

	}
}
