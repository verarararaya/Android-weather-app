package com.example.weather;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

public class serverce extends Service{
//mainly reference
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	 public int onStartCommand(Intent intent, int flags, int startId) {
		 AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE); 
		  Intent i = new Intent(this, notification.class); 
		  PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0); 
		  manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,  
	                 System.currentTimeMillis(), 86400*1000, pi); 
		  return super.onStartCommand(intent, flags, startId); 
        
	 }

}
