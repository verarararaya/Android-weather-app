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
	              { //������ļ��в����ڣ�����д���  
	                dirFirstFolder.mkdirs();//�����ļ���  
	       
	            }    
	              File dirFirstFolder1 = new File(PATH+"/weatherlai/dayi");
	               
	              if(!dirFirstFolder1.exists())  
	              { //������ļ��в����ڣ�����д���  
	                dirFirstFolder1.mkdirs();//�����ļ���  
	       
	            }    
	              File dirFirstFolder2 = new File(PATH+"/weatherlai/kuzi");
	               
	              if(!dirFirstFolder2.exists())  
	              { //������ļ��в����ڣ�����д���  
	                dirFirstFolder2.mkdirs();//�����ļ���  
	       
	            }    
	              File dirFirstFolder3 = new File(PATH+"/weatherlai/dadishan");
	               
	              if(!dirFirstFolder3.exists())  
	              { //������ļ��в����ڣ�����д���  
	                dirFirstFolder3.mkdirs();//�����ļ���  
	       
	            }    
	              File dirFirstFolder4 = new File(PATH+"/weatherlai/qunzi");
	               
	              if(!dirFirstFolder4.exists())  
	              { //������ļ��в����ڣ�����д���  
	                dirFirstFolder4.mkdirs();//�����ļ���  
	       
	            }    
	              File dirFirstFolder5 = new File(PATH+"/weatherlai/waitao");
	               
	              if(!dirFirstFolder5.exists())  
	              { //������ļ��в����ڣ�����д���  
	                dirFirstFolder5.mkdirs();//�����ļ���  
	       
	            }    
	              File dirFirstFolder6 = new File(PATH+"/weatherlai/mianyi");
	               
	              if(!dirFirstFolder6.exists())  
	              { //������ļ��в����ڣ�����д���  
	                dirFirstFolder6.mkdirs();//�����ļ���  
	       
	            }    
	        }        
}
