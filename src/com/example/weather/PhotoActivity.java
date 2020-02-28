package com.example.weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
// This class is mainly about sending intents so that it can use camera and save photos.So it also references a lot,I change it some parts to make 
//it possible to save photo in different files so that user can save the photo in different tags
public class PhotoActivity extends Activity {
	private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private String dis = "/weatherlai/qunzi";
    private String dis1 ="/weatherlai/dadishan";
    private String dis2="/weatherlai/waitao";
    private String dis3="/weatherlai/dayi";
    private String dis4="/weatherlai/mianyi";
    private String dis5="/weatherlai/kuzi";
    String PATH = Environment.getExternalStorageDirectory()+dis;
    String PATH1 = Environment.getExternalStorageDirectory()+dis1;
    String PATH2 = Environment.getExternalStorageDirectory()+dis2;
    String PATH3 = Environment.getExternalStorageDirectory()+dis3;
    String PATH4 = Environment.getExternalStorageDirectory()+dis4;
    String PATH5 = Environment.getExternalStorageDirectory()+dis5; 
    File sdcardTempFile = new File (Environment.getExternalStorageDirectory()+"/weatherlai", "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg"); 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo);
		btn1=(Button)findViewById(R.id.b1);
	    btn2=(Button)findViewById(R.id.b2);
	    btn3=(Button)findViewById(R.id.b3);
	    btn4=(Button)findViewById(R.id.b4);
	    btn5=(Button)findViewById(R.id.b5);
	    btn6=(Button)findViewById(R.id.b6);
	    
	    btn1.setOnClickListener(new OnClickListener() {
	        
	        @Override
	        public void onClick(View v) {
	            // 给bnt1添加点击响应事件
	        	File sdcardTempFile = new File(PATH, "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg"); 
	        	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	        	Uri u=Uri.fromFile(sdcardTempFile);   
	            intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);   
	            intent.putExtra(MediaStore.EXTRA_OUTPUT, u);   
	            intent.putExtra("return-data", true); 
	        	startActivityForResult(intent, 3);
	        }
	    });
	    btn2.setOnClickListener(new OnClickListener() {
	        
	        @Override
	        public void onClick(View v) {
	            // 给bnt1添加点击响应事件
	        	File sdcardTempFile = new File(PATH1, "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg"); 
	        	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	        	Uri u=Uri.fromFile(sdcardTempFile);   
	            intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);   
	            intent.putExtra(MediaStore.EXTRA_OUTPUT, u);   
	            intent.putExtra("return-data", true); 
	        	startActivityForResult(intent, 3);
	        }
	    });
	    btn3.setOnClickListener(new OnClickListener() {
	        
	        @Override
	        public void onClick(View v) {
	            // 给bnt1添加点击响应事件
	        	 File sdcardTempFile = new File(PATH2, "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg"); 
	        	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  
	        	Uri u=Uri.fromFile(sdcardTempFile);   
	            intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);   
	            intent.putExtra(MediaStore.EXTRA_OUTPUT, u);   
	            intent.putExtra("return-data", true); 
	        	startActivityForResult(intent, 3);
	        }
	    });
	    btn4.setOnClickListener(new OnClickListener() {
	        
	        @Override
	        public void onClick(View v) {
	            // 给bnt1添加点击响应事件
	        	 File sdcardTempFile = new File(PATH3, "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg"); 
	        	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	        	Uri u=Uri.fromFile(sdcardTempFile);   
	            intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);   
	            intent.putExtra(MediaStore.EXTRA_OUTPUT, u);   
	            intent.putExtra("return-data", true); 
	        	startActivityForResult(intent, 3);
	        }
	    });
	    btn5.setOnClickListener(new OnClickListener() {
	        
	        @Override
	        public void onClick(View v) {
	            // 给bnt1添加点击响应事件
	        	 File sdcardTempFile = new File(PATH4, "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg"); 
	        	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); 
	        	Uri u=Uri.fromFile(sdcardTempFile);   
	            intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);   
	            intent.putExtra(MediaStore.EXTRA_OUTPUT, u);   
	            intent.putExtra("return-data", true); 
	        	startActivityForResult(intent, 3);
	        }
	    });
	    btn6.setOnClickListener(new OnClickListener() {
	        
	        @Override
	        public void onClick(View v) {
	            // 给bnt1添加点击响应事件
	        	 File sdcardTempFile = new File(PATH5, "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg"); 
	        	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); 
	        	Uri u=Uri.fromFile(sdcardTempFile);   
	            intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);   
	            intent.putExtra(MediaStore.EXTRA_OUTPUT, u);   
	            intent.putExtra("return-data", true); 
	        	startActivityForResult(intent, 3);
	        }
	    });
	}
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        // TODO Auto-generated method stub  
		 super.onActivityResult(requestCode, resultCode, data);   
	        if (resultCode == RESULT_OK) {  
	            System.out.println("requestCode"+requestCode);  
	              
	            Bitmap bmp;
				switch (requestCode){  
	              
	            case 2:  
	                 Uri tuku_uri = data.getData();  
	                 
	                 System.out.println(tuku_uri.getPath());  
	                   ContentResolver tuku_cr = this.getContentResolver();  
	                   try {  
	                    bmp = BitmapFactory.decodeStream(tuku_cr.openInputStream(tuku_uri));  
	                        
	                } catch (FileNotFoundException e) {  
	                    // TODO Auto-generated catch block  
	                    e.printStackTrace();  
	                }  
	                break;  
	            case 3:  
	                   try {  
	                       Uri xiangji_uri = Uri.parse(android.provider.MediaStore.Images.Media.insertImage(getContentResolver(), sdcardTempFile.getAbsolutePath(), null, null));   
	                       System.out.println(xiangji_uri.getPath());  
	                       ContentResolver xiangji_cr = this.getContentResolver();  
	                         
	                       bmp = BitmapFactory.decodeStream(xiangji_cr.openInputStream(xiangji_uri));  
	                       
	                } catch (FileNotFoundException e) {  
	                    // TODO Auto-generated catch block  
	                    e.printStackTrace();  
	                }  }}
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
		getMenuInflater().inflate(R.menu.photo, menu);
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
