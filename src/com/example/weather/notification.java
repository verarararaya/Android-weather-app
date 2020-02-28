package com.example.weather;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
//the intent part is learn from the internet.
public class notification extends BroadcastReceiver{


	private static final int NOTIFICATION_FLAG = 1;

	@Override
	public void onReceive(Context context, Intent intent) {    
		 Intent intent1 = new Intent(context, serverce.class);
	        context.startService(intent1);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);  

            Notification notify = new Notification.Builder(context)  
                    .setSmallIcon(R.drawable.ic_launcher) 
                    .setTicker("又是当小仙女的一天啦~")  
                    .setContentText("快来看看今天穿什么衣服吧！")
                    .setContentIntent(pendingIntent).setNumber(1).build(); 
            notify.flags |= Notification.FLAG_AUTO_CANCEL;  
            NotificationManager manager = (NotificationManager) context  
                    .getSystemService(Context.NOTIFICATION_SERVICE);  
            manager.notify(NOTIFICATION_FLAG, notify);
        
    }  
	}


