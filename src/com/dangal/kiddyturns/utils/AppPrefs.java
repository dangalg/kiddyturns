package com.dangal.kiddyturns.utils;

import android.content.Context;
import android.content.SharedPreferences;



public class AppPrefs {
	
	public Context context;
	SharedPreferences mySharedPreferences;
	SharedPreferences.Editor editor;

	public AppPrefs(Context pcontext) {
		context = pcontext;
		mySharedPreferences = context.getApplicationContext()
				.getSharedPreferences(Constants.PREFERENCES, 0);
		editor = mySharedPreferences.edit();
	}
	
	public void SavePassword(String password) {
		editor.putString(Constants.PASSWORD, password);
		editor.commit();
	}
	
	public String GetPassword() {
		return mySharedPreferences.getString(Constants.PASSWORD, "");
	}
	
	public void SaveTimeMoving(boolean timeMoving) {
		editor.putBoolean(Constants.TIMERMOVING, timeMoving);
		editor.commit();
	}
	
	public boolean GetTimeMoving() {
		return mySharedPreferences.getBoolean(Constants.TIMERMOVING,
				false);
	}
	
	public int GetSpeed() {
		return mySharedPreferences.getInt(Constants.SPEED, 1);
	}

	public void SaveElapsedTime(long elapsedTime) {
		long savedTime = System.currentTimeMillis();
		editor.putLong(Constants.SAVED_TIME, savedTime);
		editor.putLong(Constants.ELAPSED_TIME, elapsedTime);
		editor.commit();
	}
	
	public long GetElapsedTime() {
		return mySharedPreferences.getLong(Constants.ELAPSED_TIME, 0);
	}
}
