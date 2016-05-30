package com.example.service;

import com.example.service.MyBindService.MyBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*findViewById(R.id.btn_intentservice).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				intent = new Intent(MainActivity.this, MyIntentService.class);
				startService(intent);
			}
		});
*/
		findViewById(R.id.btn_bindservice).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				intent = new Intent(MainActivity.this, MyBindService.class);
				bindService(intent, conn, Service.BIND_AUTO_CREATE);
			}
		});

		findViewById(R.id.btn_unbindservice).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				unbindService(conn);
			}
		});
	}

	//建立连接
	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i("MyTag", "connected");
			MyBinder myBinder = (MyBinder) service;
			//			String myname = myBinder.getName("xiaoxin");
			myBinder.getService().bind();
			//			Toast.makeText(MainActivity.this, myname, 3000).show();
		}
	};

	public void start(View v) {
		intent = new Intent(MainActivity.this, MyService.class);
		startService(intent);
	}

	public void stop(View v) {
		stopService(intent);
	}

}
