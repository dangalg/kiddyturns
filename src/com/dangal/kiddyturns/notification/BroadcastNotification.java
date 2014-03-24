package com.dangal.kiddyturns.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dangal.kiddyturns.R;
import com.dangal.kiddyturns.activities.MainActivity;

public class BroadcastNotification extends BroadcastReceiver {

	
	private static final int HELLO_ID = 1;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = 
				(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

	    
	    int icon = R.drawable.notification;        
	    CharSequence tickerText = "bProductive"; // ticker-text
	    long when = System.currentTimeMillis();             
	    CharSequence contentTitle = "bProductive";  
	    CharSequence contentText = "It's time to get productive again";      
	    Intent notificationIntent = new Intent(context, MainActivity.class);
	    notificationIntent.setAction("android.intent.action.MAIN");
	    notificationIntent.addCategory("android.intent.category.LAUNCHER"); 
	    
	    PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
	    Notification notification = new Notification(icon, tickerText, when);
	    notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
	    notification.defaults = Notification.DEFAULT_ALL;
	    notification.flags |= Notification.FLAG_ONLY_ALERT_ONCE;
	    notification.flags |= Notification.FLAG_AUTO_CANCEL;

	    // and this
	    
	    mNotificationManager.notify(HELLO_ID, notification);
	}

}
