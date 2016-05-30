package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {

	//IBinder接口对象
	IBinder ibinder = new MyBinder();

	//定义了IBinder接口实现
	public class MyBinder extends Binder {
		public MyBindService getService() {
			return MyBindService.this;
		}
		public String getName(String name){
			return "name is :"+name;
		}
	}

	public void bind() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.i("MyTag", "bindservice" + i);
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		//暴露IBinder接口
		Log.i("MyTag", "BindService onbind()");
		return ibinder;
	}

	@Override
	public void onCreate() {
		Log.i("MyTag", "BindService onCreate()");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Log.i("MyTag", "BindService onDestroy()");
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("MyTag", "onstartCommand()");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.i("MyTag", "BindService onUnbind()");
		return super.onUnbind(intent);
	}
	
	

}
