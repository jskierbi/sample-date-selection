package com.jskierbi.sampledateselection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

/**
 * Created by jakub on 04/26/2015.
 */
public class CalendarViewActivity extends Activity {

	private int mYear;
	private int mMonth;
	private int mDay;

	private long mInitialDate;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CalendarView calendar = new CalendarView(this);
		calendar.setOnDateChangeListener(mDateSetListener);
		mInitialDate = calendar.getDate();
		setContentView(calendar);
	}

	private CalendarView.OnDateChangeListener mDateSetListener = new CalendarView.OnDateChangeListener() {
		@Override public void onSelectedDayChange(CalendarView view, int year, int monthOfYear, int dayOfMonth) {

			if (view.getDate() == mInitialDate) {
				return;
			}

			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			String selectedDate = new StringBuilder().append(mMonth + 1).append("-").append(mDay).append("-")
					.append(mYear).append(" ").toString();

			Bundle b = new Bundle();
			b.putString("dateSelected", selectedDate);

			//Add the set of extended data to the intent and start it
			Intent intent = new Intent();
			intent.putExtras(b);
			setResult(RESULT_OK,intent);
			finish();
		}
	};
}
