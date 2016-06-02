package com.example.anr;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PostActivity extends Activity {

	private TextView txt;
	private int i;
	private Handler handler=new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt = (TextView) findViewById(R.id.txt);
	}
	
	public void go(View v){
		new Thread() {
			public void run() {
				for(i = 1; ;i+=2){
					handler.post(new Runnable() {     //�����߳���ʹ��handler���������߳��з���һ�δ��룬���߳��Զ�ִ��run()����
						public void run() {
							txt.setText(i+"");
						}
					});
					System.out.println(i);					
					SystemClock.sleep(1000);
				}
			}	
		}.start();
		
		
	}
		


}
