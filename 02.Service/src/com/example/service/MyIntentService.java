package com.example.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyIntentService extends IntentService {

	public MyIntentService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public MyIntentService(){
		super("hello");
	}
	@Override
	protected void onHandleIntent(Intent arg0) {
		Log.i("MyTag", "onHandleIntent()");
		for(int i=0;i<30;i++){
			Log.i("MyTag","IntentService"+i);
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		
		return super.onBind(intent);
	}

	@Override
	public void onCreate() {
		Log.i("MyTag", "onCreate()");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.i("MyTag", "onDestroy()");
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("MyTag", "onstartCommand()");
		return super.onStartCommand(intent, flags, startId);
	}
	

}
