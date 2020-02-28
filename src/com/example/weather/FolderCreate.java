package com.example.weather;

import java.io.File;

import android.os.Environment;
//This one is reference and then I change it some parts so that it can do something I want:create tags files.
public class FolderCreate {
	 public static void createfolder() {  
	        // TODO Auto-generated method stub  
		 File PATH = Environment.getExternalStorageDirectory();
		 		File dirFirstFolder = new File(PATH+"/weatherlai");
	               
	              if(!dirFirstFolder.exists())  
	              { //如果该文件夹不存在，则进行创建  
	                dirFirstFolder.mkdirs();//创建文件夹  
	       
	            }    
	              File dirFirstFolder1 = new File(PATH+"/weatherlai/dayi");
	               
	              if(!dirFirstFolder1.exists())  
	              { //如果该文件夹不存在，则进行创建  
	                dirFirstFolder1.mkdirs();//创建文件夹  
	       
	            }    
	              File dirFirstFolder2 = new File(PATH+"/weatherlai/kuzi");
	               
	              if(!dirFirstFolder2.exists())  
	              { //如果该文件夹不存在，则进行创建  
	                dirFirstFolder2.mkdirs();//创建文件夹  
	       
	            }    
	              File dirFirstFolder3 = new File(PATH+"/weatherlai/dadishan");
	               
	              if(!dirFirstFolder3.exists())  
	              { //如果该文件夹不存在，则进行创建  
	                dirFirstFolder3.mkdirs();//创建文件夹  
	       
	            }    
	              File dirFirstFolder4 = new File(PATH+"/weatherlai/qunzi");
	               
	              if(!dirFirstFolder4.exists())  
	              { //如果该文件夹不存在，则进行创建  
	                dirFirstFolder4.mkdirs();//创建文件夹  
	       
	            }    
	              File dirFirstFolder5 = new File(PATH+"/weatherlai/waitao");
	               
	              if(!dirFirstFolder5.exists())  
	              { //如果该文件夹不存在，则进行创建  
	                dirFirstFolder5.mkdirs();//创建文件夹  
	       
	            }    
	              File dirFirstFolder6 = new File(PATH+"/weatherlai/mianyi");
	               
	              if(!dirFirstFolder6.exists())  
	              { //如果该文件夹不存在，则进行创建  
	                dirFirstFolder6.mkdirs();//创建文件夹  
	       
	            }    
	        }        
}
