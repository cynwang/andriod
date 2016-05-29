package com.example.activity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MyTag", "onCreat()");
        setContentView(R.layout.activity_main);
        //找到控件，设置监听器
        findViewById(R.id.btn_go).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
/*				Intent intent=new Intent(MainActivity.this,MyActivity.class);      //创建intent
				intent.putExtra("name", "iutrgh");					//
				
				startActivityForResult(intent, 123);		//返回值
				
				Intent intent=new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:18252586499"));
				startActivity(intent);*/
				
				Intent intent =new Intent(MainActivity.this,MyActivity.class);
				startActivity(intent);
			
			}
		});
    }   
    
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	
    	super.onActivityResult(requestCode, resultCode, intent);
    	if(requestCode==123){
    		Bundle bundle=intent.getExtras();
    		String str=bundle.getString("name");
    		Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    	}
    }*/
    
    @Override
    protected void onStart() {
    	
    	super.onStart();
    	Log.i("MyTag", "onStart()");
    }
    
    @Override
    protected void onResume() {
    	
    	super.onResume();
    	Log.i("MyTag", "onResume()");
    }
    
    @Override
    protected void onPause() {
    	
    	super.onPause();
    	Log.i("MyTag", "onPause()");
    }
    @Override
    protected void onRestart() {
    	
    	super.onRestart();
    	Log.i("MyTag", "onRestart()");
    }
    @Override
    protected void onStop() {
    	
    	super.onStop();
    	Log.i("MyTag", "onStop()");
    }
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Log.i("MyTag", "onDestory()");
    }
}
