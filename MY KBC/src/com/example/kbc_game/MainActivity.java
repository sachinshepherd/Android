package com.example.kbc_game;

import java.util.Timer;
import java.util.TimerTask;

import android.R.integer;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import com.example.KBC_Player.R;

public class MainActivity extends Activity {
	MediaPlayer m;
	Button rule,play,exit,wiki,ex;
	TextView tv;
	Animation animation1,animation2;
	 int count=0,TimeCounter;
	 String st;
     Timer T;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView1);
        rule=(Button)findViewById(R.id.button3);
        ex=(Button)findViewById(R.id.button5);
        play=(Button)findViewById(R.id.button1);
        exit=(Button)findViewById(R.id.button4);
        wiki=(Button)findViewById(R.id.button2);
        m=MediaPlayer.create(getApplicationContext(), R.raw.kbc_tone);
        m.start();
        

        animation1 = AnimationUtils.loadAnimation(this, R.anim.rot );
        animation2 = AnimationUtils.loadAnimation(this, R.anim.down ); 
        play.startAnimation(animation1);
        exit.startAnimation(animation1);
        wiki.startAnimation(animation2);
        rule.startAnimation(animation2);
       
     
      
     	
		Timer tm = new Timer();
	    tm.scheduleAtFixedRate(new TimerTask() {

	        @Override
	        public void run() {
	            // TODO Auto-generated method stub
	            runOnUiThread(new Runnable() {
	                public void run() {
	                     TimeCounter++;
	                }
	            });

	        }
	    }, 1000, 100);// 1000 means start from 1 sec, and the second 1000 is do the loop each 1 sec.


        
        play.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TimeCounter=TimeCounter%10;

				st=String.valueOf(TimeCounter);
				Intent p = new Intent(getApplicationContext(), Firstfile.class);
				p.putExtra("get1", st);
				startActivity(p);
				
				 // you can set it to a textView to show it to the user to see the time passing while he is writing.
	              

				finish();
				m.stop();
				
				
			}
		});
        wiki.setOnClickListener(new View.OnClickListener() {
			
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				Intent w = new Intent(getApplicationContext(), wikifile.class);
    				startActivity(w);
    				finish();
    				m.stop();
    			}
    		});
        rule.setOnClickListener(new View.OnClickListener() {
			
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				Intent r = new Intent(getApplicationContext(), Rulesfile.class);
    				startActivity(r);
    				finish();
    				m.stop();
    			}
    		});
        exit.setOnClickListener(new View.OnClickListener() {
			
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    					android.os.Process.killProcess(android.os.Process.myPid());
    					                    System.exit(1);
    					                    finish();
    				
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
        	return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press Quit Button", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            public void run() {
                doubleBackToExitPressedOnce=false;                
                
            }
        }, 2000);	
    } 
   
    
}
