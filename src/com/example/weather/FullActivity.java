package com.example.weather;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
//This class is about to show all the image in different tags,so scanning the files in file is reference,and then I put it into 
//Gridview layout. The delete function is reference.But the way——click and a dialog come out， then delete is by my hand
public class FullActivity extends Activity {
	  private List<String> imagePath=new ArrayList<String>();
	    private static String[] imageFormatSet=new String[]{"jpg","png","gif"};
	    protected static final int CHANGE_UI = 1;
	    
	    private static boolean isImageFile(String path){  
	        for(String format:imageFormatSet){
	            if(path.contains(format)){  
	                return true;  
	            }  
	        }  
	        return false;  
	    }   
	   
	    private void getFiles(String url){  
	        File files=new File(url);  
	        File[] file=files.listFiles();  
	        try {  
	            for(File f:file){ 
	                if(f.isDirectory()){  
	                    getFiles(f.getAbsolutePath());
	                }else{  
	                    if(isImageFile(f.getPath())){ 
	                        imagePath.add(f.getPath());  
	                    }  
	                }  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();
	        }  
	    }  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full);
		Intent intent= getIntent();
		String path= intent.getStringExtra("path");
		getFiles(path);

		 if(imagePath.size()<1){  
	            return;  
	        }
	        
	        final GridView gridview=(GridView)findViewById(R.id.gridView1);
	        final BaseAdapter adapter=new BaseAdapter(){  
	  
	  
	            @Override  
	            public View getView(int position, View convertView, ViewGroup parent) {  
	                ImageView iv;
	                if(convertView==null){  
	                    iv=new ImageView(FullActivity.this); 
	                    iv.setAdjustViewBounds(true);  
	                    iv.setMaxWidth(300);  
	                    iv.setMaxHeight(405);  
	                    iv.setPadding(1, 1, 1, 1);
	                }else{  
	                    iv=(ImageView)convertView;  
	                }  
	                
	                Bitmap bm=BitmapFactory.decodeFile(imagePath.get(position));  
	                iv.setImageBitmap(bm);  
	                return iv;  
	            }  
	            
	              
	          
	            @Override  
	            public int getCount() {  
	                return imagePath.size();  
	            }  
	  
	  
	            
	            @Override  
	            public Object getItem(int position) {  
	                return position;  
	            }  
	  
	  
	             
	            @Override  
	            public long getItemId(int position) {  
	                return position;  
	            }

				
	        };  
	       
	      
	        gridview.setAdapter(adapter);
	        gridview.setOnItemClickListener(new OnItemClickListener(){  
	        	  
	            @Override  
	            public void onItemClick(AdapterView<?> arg0, View arg1, final int pos,  
	                    long arg3) {  
	            	 Dialog alertDialog = new AlertDialog.Builder(FullActivity.this).
	            			    setTitle("确定删除？").
	            			    setMessage("您确定删除该条信息吗？").
	            			    setIcon(R.drawable.ic_launcher).
	            			    setPositiveButton("确定", new DialogInterface.OnClickListener() {
	            			     
	            			     

								@Override
	            			     public void onClick(DialogInterface dialog, int which) {
	            			    	 String filePath = imagePath.get(pos); 
	            			    	 File file = new File(filePath);
	            			    	  if (file.isFile() && file.exists()) {
	            			    	        file.delete();
	            			    	        imagePath.remove(pos);
	            			    	        gridview.setAdapter(adapter);
	            			    	        adapter.notifyDataSetChanged();
	            			    	        
	            			    	        }else{
	            			    	        	return;
	            			    	        }
	            			     }
	            			    }).
	            			    setNegativeButton("取消", new DialogInterface.OnClickListener() {
	            			     
	            			     @Override
	            			     public void onClick(DialogInterface dialog, int which) {
	            			    	 dialog.dismiss();
	            			     }
	            			    }).
	                // TODO Auto-generated method stub  
	            			    create();
	            	  alertDialog.show();
	            	  
	            	  
	            }
			
	              
	        }) ;  
	      
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
		getMenuInflater().inflate(R.menu.full, menu);
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
