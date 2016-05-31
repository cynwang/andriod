package com.example.textview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class GalleryActivity extends Activity implements OnItemClickListener, ViewFactory{
	private int[] images=new int[] {R.drawable.a,
			R.drawable.b,
			R.drawable.c};
	private int index=0;
	private ImageSwitcher imageSwitcher;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_gallery);
		
		Gallery gallery = (Gallery) findViewById(R.id.gallery);
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
		imageSwitcher.setFactory(this);
		imageSwitcher.setImageResource(index);
		gallery.setAdapter(new MyAdapter());
		gallery.setOnItemClickListener(this);
	}

	public class MyAdapter extends BaseAdapter{
		
		@Override
		public int getCount() {
			
			return images.length;
		}
		
		@Override
		public Object getItem(int position) {
			
			return null;
		}
		
		@Override
		public long getItemId(int position) {
			
			return 0;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView=new ImageView(GalleryActivity.this);
			imageView.setImageResource(images[position]);
			return imageView;
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Toast.makeText(getApplicationContext(), ""+arg2, 3000).show();
		imageSwitcher.setImageResource(images[arg2]);
	}

	@Override
	public View makeView() {
		
		return new ImageView(this);
	}
}
