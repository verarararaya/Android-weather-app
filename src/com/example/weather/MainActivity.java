package com.example.weather;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;

import com.example.weather.StreamTool;
 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
 

 
 
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
 
 //this class is ask for weather forecast,and I used an example from the Internet,It is asked for a JSON data.So the main context of
//this class is reference but I change it a bit so that can  fit my app,show the message that I want,and the rest function of this class 
//is written by myself
@SuppressLint("HandlerLeak")
public class MainActivity extends Activity implements View.OnClickListener {
 
	private ImageView clothe;
    private ImageButton btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private EditText ed_city;
    private TextView date;
    private TextView maximum;
    private TextView minimum;
    private TextView winds;
    private TextView windd;
    private TextView full;
    private TextView dress;
    Intent intent =new Intent();
    int x = 0;
    int a;
  public static final String action = "com.example.weather.action";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    intent = new Intent(this, serverce.class); 
    startService(intent); 
    FolderCreate folder = new FolderCreate() ;  
    	folder.createfolder();
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    	StrictMode.setThreadPolicy(policy); 
    	
    setContentView(R.layout.activity_main);
    btn=(ImageButton)findViewById(R.id.btn);
    btn1=(Button)findViewById(R.id.btn2);
    btn2=(Button)findViewById(R.id.btn1);
    btn3=(Button)findViewById(R.id.b3);
    btn1.setOnClickListener(new OnClickListener() {
    	            
    	             @Override
    	             public void onClick(View v) {
    	                 // 给bnt1添加点击响应事件
    	            	 switch(x){
    	            	 case 0:
    	            		 btn1.setText(R.string.tomorrow);
    	            		 a=1;
    	            		 x=1;
    	            		 break;
    	            	 case 1:
    	            		 a=0;
    	            		 x=0;
    	            		 btn1.setText(R.string.today);
    	            	 }
    	            	
    	            	     	             }
    	         });
   
    btn2.setOnClickListener(new OnClickListener() {
        
        @Override
        public void onClick(View v) {
            // 给bnt1添加点击响应事件
           Intent intent =new Intent(MainActivity.this,DressActivity.class);
            
            startActivity(intent);
        }
    });
 btn3.setOnClickListener(new OnClickListener() {
        
        @Override
        public void onClick(View v) {
            // 给bnt1添加点击响应事件
        	Intent intent =new Intent(MainActivity.this,PhotoActivity.class);
            
            startActivity(intent);
        }
    });
    btn.setOnClickListener(this);
    	
    	
    ed_city=(EditText) findViewById(R.id.ed_city);
    date=(TextView) findViewById(R.id.date);
    maximum=(TextView) findViewById(R.id.maximum);
    minimum=(TextView) findViewById(R.id.minimum);
    winds=(TextView) findViewById(R.id.winds);
    windd=(TextView) findViewById(R.id.windd);
    full=(TextView) findViewById(R.id.full);
    dress=(TextView) findViewById(R.id.zhinan);
    clothe= (ImageView) findViewById(R.id.clothes);
  }
 
 
 
 
  
 
 
  private final static String PATH="http://www.sojson.com/open/api/weather/json.shtml?city=";
    protected static final int SUCCESS = 0;
    protected static final int INVALID_CITY = 1;
    protected static final int ERROR = 2;
     
  private String city;
  String ul;
  
   public void setHandler(Handler handler) {  
		  this.mhandler = handler;  
		  }  
	  public Handler getHandler() {  
		  return mhandler;  
		  }  
  private Handler mhandler=new Handler(){
	 
    public void handleMessage(android.os.Message msg) {
        dialog.dismiss();
        switch (msg.what) {
            case SUCCESS:
                 
                    JSONArray data=(JSONArray) msg.obj;
                try {
                    String day01= data.getJSONObject(a).getString("date");
                    String day02= data.getJSONObject(a).getString("high");
                    String day03= data.getJSONObject(a).getString("low");
                    String day04= data.getJSONObject(a).getString("fx");
                    String day05= data.getJSONObject(a).getString("fl");
                    String day06= data.getJSONObject(a).getString("type");
                    date.setText(day01);
                    maximum.setText(day02);
                    minimum.setText(day03);
                    windd.setText(day04);
                    winds.setText(day05);
                    full.setText(day06);
                    day02=day02.trim();
                    day03=day03.trim();
                    String str1="";
                    String str2="";
                    if(day02 != null && !"".equals(day02)){
                    for(int i=0;i<day02.length();i++){
                    if((day02.charAt(i)>=48 && day02.charAt(i)<=57)||day02.charAt(i)==46||day02.charAt(i)==45){
                    str2+=day02.charAt(i);
                    }
                    }}
                    if(day03 != null && !"".equals(day03)){
                        for(int i=0;i<day03.length();i++){
                        if((day03.charAt(i)>=48 && day03.charAt(i)<=57)||day03.charAt(i)==46||day03.charAt(i)==45){
                        str1+=day03.charAt(i);
                        }
                        }}
                    float a = Float.parseFloat(str1);
                    float b = Float.parseFloat(str2);
                    float c = (a+b);
                    float d;
                    if(c!=0){
                    	d=c/2;
                    }else{
                    	d=0;
                    }
                    if(d>=25){
                    	dress.setText(R.string.sum);
                    	clothe.setImageResource(R.drawable.sum);
                    }
                    else if(d>=18&&d<25){
                    	dress.setText(R.string.shushi);
                    	clothe.setImageResource(R.drawable.shushi);
                    }
                    else if(d>=13&&d<18){
                    	dress.setText(R.string.jiaol);
                    	clothe.setImageResource(R.drawable.jiaol);
                    }
                    else if(d>=5&&d<13){
                    	dress.setText(R.string.leng);
                    	clothe.setImageResource(R.drawable.leng);
                    }
                    else if(d<=13){
                    	dress.setText(R.string.chaol);
                    	clothe.setImageResource(R.drawable.chaol);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                    break;
         
                     
                 
            case INVALID_CITY:
                Toast.makeText(MainActivity.this, "城市无效", 0).show();
                break;
            case ERROR:
                Toast.makeText(MainActivity.this, "网络无效", 0).show();
                break;
            default:
                break;
            }
    };
  };
	protected void onSaveInstanceState(Bundle outState) {  
        super.onSaveInstanceState(outState);  
    }  
	protected void onRestoreInstanceState(Bundle savedInstanceState) {  
        super.onRestoreInstanceState(savedInstanceState);  
    }  			
  ProgressDialog dialog=null;
  
    public void onClick(View v) {
        // TODO Auto-generated method stub
        city=ed_city.getText().toString().trim();
        if(TextUtils.isEmpty(city)){
            Toast.makeText(this, "路径错误", 0).show();
            return ;
        }
        dialog=new ProgressDialog(this);
        dialog.setMessage("正在玩命加载中");
        dialog.show();
        //发起请求给那个网站
        new Thread(){
            public void run() {
                try {
                  ul=PATH+URLEncoder.encode(city,"UTF-8");
                     
                    URL url=new URL(ul);
                     
                
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setRequestMethod("GET");
                     
                    //判断响应码
                    int code = conn.getResponseCode();
                    if(code==200){
                        //连接网络成功
                        InputStream in = conn.getInputStream();
                        String data = StreamTool.decodeStream(in);
                         
                         
                      
                        JSONObject jsonObj=new JSONObject(data);
          

                            JSONObject dataObj = jsonObj.getJSONObject("data");
                             
                            JSONArray jsonArray = dataObj.getJSONArray("forecast");
                            
                            Message msg = Message.obtain();
                            msg.obj=jsonArray;
                            msg.what=SUCCESS;
                            mhandler.sendMessage(msg);
                        }else{
                            
                            Message msg=Message.obtain();
                            msg.what=INVALID_CITY;
                            mhandler.sendMessage(msg);
                           
                        
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Message msg = Message.obtain();
                    msg.what=ERROR;
                    mhandler.sendMessage(msg);
              }
            };
        }.start();
    }
  
}