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

}
