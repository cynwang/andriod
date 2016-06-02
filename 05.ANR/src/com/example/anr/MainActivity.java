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

public class MainActivity extends Activity {

	private TextView txt;
	private Handler handler=new Handler(){             
		public void handleMessage(Message msg){   //该方法在sendMessage之后执行，形参就是发送过来的Message对象
			
			txt.setText(msg.obj+"");      //主线程更新界面
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt = (TextView) findViewById(R.id.txt);
	}
	
	public void go(View v){
		new Thread() {
			public void run() {
				for(int i=1; ;i++){
					System.out.println(i);
//					txt.setText(i+"");         //只有主线程才可以修改TextView
					
//					Message msg = new Message();   //创建消息对象
					Message msg=handler.obtainMessage();    //从消息池中获取一个Message
					msg.obj=i; 					   //把数据放在消息对象中
					handler.sendMessage(msg);      //在新线程中发送消息对象，主线程会自动执行handleMessage（）方法
					SystemClock.sleep(1000);
				}
			}	
		}.start();
		
		
	}
		


}
