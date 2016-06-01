package com.example.sharedpreference;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private SharedPreferences shPreferences;
	private CheckBox cBox;
	private EditText edtname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cBox = (CheckBox) findViewById(R.id.cb);
		edtname = (EditText) findViewById(R.id.edt_txt);
		//得到SharedPreference对象
		shPreferences = getSharedPreferences("settingFile", MODE_PRIVATE);
		
		if(shPreferences!=null){
			cBox.setChecked(shPreferences.getBoolean("wifi", false));
			edtname.setText(shPreferences.getString("name", ""));
		}else {
			Toast.makeText(getApplicationContext(), "no xml", 3000).show();
		}
		
		findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//编辑
				SharedPreferences.Editor editor=shPreferences.edit();
				boolean wifi=cBox.isChecked();
				editor.putBoolean("wifi", wifi);
				String name=edtname.getText().toString();
				editor.putString("name", name);
				editor.commit();
				Toast.makeText(getApplicationContext(), "保存成功", 3000).show();
			}
		});
	}

}
