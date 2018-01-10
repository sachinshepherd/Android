package com.example.kbc_game;

import java.text.BreakIterator;
import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import com.example.KBC_Player.R;

public class score extends Activity {
	Button home,quit,check,add;
	TextView tv1;
	EditText et1,et2;
	ListView lv;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
       /* home=(Button)findViewById(R.id.button1);
        quit=(Button)findViewById(R.id.button3);
        
      
    
		
       */
        home=(Button)findViewById(R.id.button3);
        quit=(Button)findViewById(R.id.button4);
        quit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});	
 home.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			Intent p=new Intent(getApplicationContext(), MainActivity.class);
			startActivity(p);
			finish();
			
			}
		});
 quit.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            finish();

			}
		});
      
        tv1=(TextView)findViewById(R.id.textView2);
        Intent j= getIntent();
	final String str= j.getStringExtra("scr");
        
		tv1.setText(str);
      

		final bd1 helper=new bd1(getBaseContext(), null, null, 0);

		et1=(EditText)findViewById(R.id.editText1);
		add=(Button)findViewById(R.id.button1);
		check=(Button)findViewById(R.id.button2);
		lv=(ListView)findViewById(R.id.listView1);
		if(str.equals("7 Crore")){
			MediaPlayer m=MediaPlayer.create(getApplicationContext(), R.raw.crorepati);
		        m.start();				
		       
		}
		final ArrayList<String> al = new ArrayList<String>();
		
		add.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				add.setEnabled(false);
				al.clear();
				Toast.makeText(getApplicationContext(),"Score submited",Toast.LENGTH_LONG).show();
				  
				add.setBackgroundResource(R.drawable.playbuttongreen);
				helper.inRecords(et1.getText().toString(), str);
		        Cursor cur=helper.getAllTitles();
		        if(cur.moveToFirst())
		        {
			do{
				//Toast.makeText(getBaseContext(), ""+cur.getString(0)+"-"+cur.getString(1),Toast.LENGTH_LONG).show();
				al.add(cur.getString(0) + "-" + cur.getString(1));
			}while(cur.moveToNext());
		        }
		
		        lv.setAdapter(new ArrayAdapter<String>(score.this, android.R.layout.simple_list_item_1,al));
			}
		});
		
		check.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//add.setEnabled(false);
				/*Cursor cur=helper.selRecs(et1.getText().toString(), str);
		        if(cur.getCount()!=0)
		        {
			Toast.makeText(getApplicationContext(),"welcome",Toast.LENGTH_LONG).show();
		        }*/
				Cursor cur=helper.getAllTitles();
				cur.moveToLast();
				Toast.makeText(getApplicationContext(),cur.getString(0),Toast.LENGTH_LONG).show();
				 
			}
		});

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private boolean doubleBackToExitPressedOnce = false;
    
    public void onBackPressed() {
    	
        if (doubleBackToExitPressedOnce) {
        	finish();
        	return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            public void run() {
                doubleBackToExitPressedOnce=false;                
                
            }
        }, 2000);
    } 
    
    
}
