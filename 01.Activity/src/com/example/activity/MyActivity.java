package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MyActivity extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i("MyTag", "Myactivity onCreat()");
		setContentView(R.layout.myactivity_main);
		//获得intent
		/*Intent intent=getIntent();
		//获取数据
		Bundle bundle=intent.getExtras();
		String str=bundle.getString("name");
		//设置数据
		TextView txtView=(TextView) findViewById(R.id.txt_content);
		txtView.setText(str);*/
		findViewById(R.id.btn_back).setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		Intent intent=new Intent(MyActivity.this,MainActivity.class);
		startActivity(intent);
		
	}
	 @Override
	    protected void onStart() {
	    	
	    	super.onStart();
	    	Log.i("MyTag", "Myactivity onStart()");
	    }
	    
	    @Override
	    protected void onResume() {
	    	
	    	super.onResume();
	    	Log.i("MyTag", "Myactivity onResume()");
	    }
	    
	    @Override
	    protected void onPause() {
	    	
	    	super.onPause();
	    	Log.i("MyTag", "Myactivity onPause()");
	    }
	    @Override
	    protected void onRestart() {
	    	
	    	super.onRestart();
	    	Log.i("MyTag", "Myactivity onRestart()");
	    }
	    @Override
	    protected void onStop() {
	    	
	    	super.onStop();
	    	Log.i("MyTag", "Myactivity onStop()");
	    }
	    @Override
	    protected void onDestroy() {
	    	super.onDestroy();
	    	Log.i("MyTag", "Myactivity onDestory()");
	    }
}
