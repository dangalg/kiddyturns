package com.dangal.kiddyturns.notification;

import com.dangal.kiddyturns.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateNotificationActivity extends Activity {
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	  }

	  public void createNotification(View view) {
	    // Prepare intent which is triggered if the
	    // notification is selected
	    Intent intent = new Intent(this, NotificationReceiverActivity.class);
	    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

	    // Build notification
	    // Actions are just fake
	    Notification noti = new Notification.Builder(this)
	        .setContentTitle("New mail from " + "test@gmail.com")
	        .setContentText("Subject").setSmallIcon(R.drawable.notification)
	        .setContentIntent(pIntent)
	        .addAction(R.drawable.notification, "Call", pIntent)
	        .addAction(R.drawable.notification, "More", pIntent)
	        .addAction(R.drawable.notification, "And more", pIntent).build();
	    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	    // Hide the notification after its selected
	    noti.flags |= Notification.FLAG_AUTO_CANCEL;

	    notificationManager.notify(0, noti);

	  }

}
