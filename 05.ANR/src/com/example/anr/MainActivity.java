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
		public void handleMessage(Message msg){   //�÷�����sendMessage֮��ִ�У��βξ��Ƿ��͹�����Message����
			
			txt.setText(msg.obj+"");      //���̸߳��½���
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
//					txt.setText(i+"");         //ֻ�����̲߳ſ����޸�TextView
					
//					Message msg = new Message();   //������Ϣ����
					Message msg=handler.obtainMessage();    //����Ϣ���л�ȡһ��Message
					msg.obj=i; 					   //�����ݷ�����Ϣ������
					handler.sendMessage(msg);      //�����߳��з�����Ϣ�������̻߳��Զ�ִ��handleMessage��������
					SystemClock.sleep(1000);
				}
			}	
		}.start();
		
		
	}
		


}
