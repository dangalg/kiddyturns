package com.dangal.kiddyturns.timer;

import com.dangal.kiddyturns.notification.BroadcastNotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;



public class Timer {

	private Handler mHandler = new Handler();
	private long savedTime;
	private long elapsedTime;
	private long downTime;
	public int speedMultiplier;
	private String hours, minutes, seconds, milliseconds;
	private long secs, mins, hrs, msecs;
	private boolean productiveStopped = true;
	private boolean unproductiveStopped = true;
	private boolean onResumed = false;
	private boolean notify = true;
	private boolean homeKeyPressed = false;
	Context context;
	AlarmManager am;
	
	public Timer (Context tcontext)
	{
		context = tcontext;
		am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
	}
	
	public void CancelAlarms() {
		Intent intent = new Intent(context, BroadcastNotification.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,
				intent, PendingIntent.FLAG_ONE_SHOT);

		// Cancel alarms
		try {
			am.cancel(pendingIntent);
		} catch (Exception e) {
			Log.e("AlarmNotCanceled", "AlarmManager update was not canceled. "
					+ e.toString());
		}
	}

	public void SetAlarm() {
		Intent intent = new Intent(context, BroadcastNotification.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,
				intent, PendingIntent.FLAG_ONE_SHOT);
		am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
				+ elapsedTime, pendingIntent);
	}
	
	public String updateTimer(long time) {
		if (time != 0) {
			secs = (long) (time / 1000);
			mins = (long) ((time / 1000) / 60);
			hrs = (long) (((time / 1000) / 60) / 60);

			// Convert the seconds to String
			// * and format to ensure it has
			// * a leading zero when required

			secs = secs % 60;
			seconds = String.valueOf(secs);
			if (secs == 0) {
				seconds = "00";
			}
			if (secs < 10 && secs > 0) {
				seconds = "0" + seconds;
			}

			// Convert the minutes to String and format the String

			mins = mins % 60;
			minutes = String.valueOf(mins);
			if (mins == 0) {
				minutes = "00";
			}
			if (mins < 10 && mins > 0) {
				minutes = "0" + minutes;
			}

			// Convert the hours to String and format the String
			hrs = hrs % 60;
			hours = String.valueOf(hrs);
			if (hrs == 0) {
				hours = "00";
			}
			if (hrs < 10 && hrs > 0) {
				hours = "0" + hours;
			}

			// Although we are not using milliseconds on the timer in this
			// example
			// * I included the code in the event that you wanted to include it
			// on your own

			milliseconds = String.valueOf((long) time);
			if (milliseconds.length() == 2) {
				milliseconds = "0" + milliseconds;
			}
			if (milliseconds.length() <= 1) {
				milliseconds = "00";
			}
			milliseconds = milliseconds.substring(milliseconds.length() - 3,
					milliseconds.length() - 2);

			// Setting the timer text to the elapsed time
			return (hours + ":" + minutes + ":" + seconds);
			// ((TextView) findViewById(R.id.timerMs)).setText("." +
			// milliseconds);
		} else {
			return ("00:00:00");
			// ((TextView) findViewById(R.id.timerMs)).setText(".00");
		}
	}

}
