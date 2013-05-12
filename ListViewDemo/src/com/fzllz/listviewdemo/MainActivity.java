package com.fzllz.listviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private ListView listView ;
	private int lastPosition = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView =(ListView) findViewById(R.id.listView);  
		
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>() ;
		for (int i = 0; i < 15; i++){  
			HashMap<String, Object> map = new HashMap<String, Object>();  
			map.put("image", R.drawable.ic_launcher);// Í¼Ïñ×ÊÔ´µÄID  
			map.put("big","Google Chrome");  
			map.put("small","25.32.16.38");
			//map.put("check", "true") ;
			list.add(map); 
		}
		SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.list_item, 
				new String[]{"img","big","small"}, new int[]{R.id.imgView,R.id.tv,R.id.info}) ;
		listView.setAdapter(adapter) ;
		listView.setBackgroundColor(Color.WHITE) ;
		listView.setOnItemClickListener(new OnItemClickListenerImpl()) ;
	}
	private class OnItemClickListenerImpl implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			parent.getChildAt(MainActivity.this.lastPosition).setBackgroundColor(Color.WHITE) ;
			view.setBackgroundColor(Color.GREEN) ;
			MainActivity.this.lastPosition = position ;
		}
		
	}
}