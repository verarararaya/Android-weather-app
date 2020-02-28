package com.example.weather;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Contacts.Intents.UI;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//The part about find file of this class is reference,I also change a bit so that can show something I want like the name of File,I
//also make it can be clicked and show another activity
public class DressActivity extends Activity {

	
	protected static final String ACTIVITY_TAG = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dress); 
		String PATH = Environment.getExternalStorageDirectory() + "/weatherlai";
		File specItemDir = new File(PATH); 
		
		//取出文件列表：  
		final File[] files = specItemDir.listFiles();
		if (specItemDir.listFiles().length > 0){
		List<HashMap<String, Object>> specs = new ArrayList<HashMap<String,Object>>();  
		int seq = 0;  
		for(File spec : files){     
		    seq++;  
		    HashMap<String, Object> hashMap = new HashMap<String, Object>();  
		    String s = null;
		    if(spec.getName().equals("qunzi")){
		    	s = this.getString(R.string.qunzi);
		    }else if(spec.getName().equals("dayi")){
		    	s=this.getString(R.string.dayi);
		    }
		    else if(spec.getName().equals("mianyi")){
		    	s=this.getString(R.string.mianyi);
		    }else if(spec.getName().equals("dadishan")){
		    	s=this.getString(R.string.dadishan);
		    }else if(spec.getName().equals("kuzi")){
		    	s=this.getString(R.string.kuzi);
		    }else if(spec.getName().equals("waitao")){
		    	s=this.getString(R.string.waitao);
		    }
		    hashMap.put("seq", seq);  
		    hashMap.put("name", s);    
		    specs.add(hashMap);    
		}     
		ListView lv = (ListView)findViewById(R.id.lv1);                  
		SimpleAdapter adapter =  
		    new SimpleAdapter(  
		    	this,  
		        specs,  
		        R.layout.item_list,  
		        new String[]{"seq","name"},  
		        new int[]{R.id.item_seq, R.id.item_name}  
		    );    
		                  
		lv.setAdapter(adapter);  
         
		lv.setOnItemClickListener(new OnItemClickListener() {  
		    @Override  
		    public void onItemClick(AdapterView<?> arg0, View arg1,int position, long aid) {  
		        String filePath = files[position].getAbsolutePath(); 
		        Log.i(DressActivity.ACTIVITY_TAG, filePath);
		        Intent intent =new Intent(DressActivity.this,FullActivity.class);
		        intent.putExtra("path", filePath);
		        startActivity(intent);  
		    }  
		});
		}
		
	}
	public void onCreateView(){
		
	}
	protected void onSaveInstanceState(Bundle outState) {  
        super.onSaveInstanceState(outState);  
    }  
	protected void onRestoreInstanceState(Bundle savedInstanceState) {  
        super.onRestoreInstanceState(savedInstanceState);  
    }  			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dress, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
