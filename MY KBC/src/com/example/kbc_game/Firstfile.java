package com.example.kbc_game;



import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Gallery;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import com.example.KBC_Player.R;

@SuppressLint({ "ParserError", "ParserError", "ParserError" })
public class Firstfile extends Activity {
	Button quit,pop,fify,call, swap;
	Button opt1,opt2,opt3,opt4;
	Animation animation2,animation1;
	Chronometer cr;
	Gallery img;
	TextView tv,tv1;
	Cursor cur;
	Timer T,timer;
	int TimeCounter;
String a,b,c,d;
	
	TextView qus;
	MediaPlayer m1,m2,m3,m4;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nigd);
        qus=(TextView)findViewById(R.id.textView3);
        quit=(Button)findViewById(R.id.button1);
        pop=(Button)findViewById(R.id.button3);
        fify=(Button)findViewById(R.id.button2);
        call=(Button)findViewById(R.id.button4);
         swap=(Button)findViewById(R.id.button9);
        opt1=(Button)findViewById(R.id.button5);
        opt2=(Button)findViewById(R.id.button6);
        opt3=(Button)findViewById(R.id.button7);
        opt4=(Button)findViewById(R.id.button8);
       
        img=(Gallery)findViewById(R.id.gallery1);
        img.setBackgroundResource(R.drawable.onedigit);
        cr=(Chronometer)findViewById(R.id.chronometer1);
        m1=MediaPlayer.create(getApplicationContext(), R.raw.tiktok);
        m2=MediaPlayer.create(getApplicationContext(), R.raw.question);
        m3=MediaPlayer.create(getApplicationContext(), R.raw.rightanswer);
        m4=MediaPlayer.create(getApplicationContext(), R.raw.fail_buzzer);
        
        final db4 helper=new db4(getApplicationContext(), null,null, 0);
      	
        
        helper.inRecords("0", "0", "0", "0");
 		 cur= helper.getAllTitles();
 		cur.moveToLast();
 		a=cur.getString(0);
 		b=cur.getString(1);
 		c=cur.getString(2);
 		d=cur.getString(3);
        //    m1.start();
        m2.start();
        cr.setBase(SystemClock.elapsedRealtime());
        cr.start();
        
        m1=MediaPlayer.create(getApplicationContext(), R.raw.tiktok);
        
        
        final Timer T=new Timer();
         T.scheduleAtFixedRate(new TimerTask() {         
                @Override
                public void run() {
                m1.start();              

                }
            }, 5, 1000);

          final Intent q = new Intent(getApplicationContext(), score.class);
         q.putExtra("scr", "0000");
         
         final Timer timer = new Timer();
         timer.schedule((TimerTask)(new TimerTask(){
             

             public void run() {
                m1.stop();
               
               
                m2.stop();
                m3.stop();
                m4.stop();
                startActivity(q);
                finish();
    	    	T.cancel();

                }
         }), 60000);
         Timer tm = new Timer();
 	    tm.scheduleAtFixedRate(new TimerTask() {

 	        @Override
 	        public void run() {
 	            // TODO Auto-generated method stub
 	            runOnUiThread(new Runnable() {
 	                public void run() {
 	                	//opt1.setText(String.valueOf(TimeCounter));
 	                     TimeCounter++;
 	                }
 	            });

 	        }
 	    }, 1000, 100);
        
        final OnClickListener right = new OnClickListener() {
        	    public void onClick(View v) {
        	    	m3.start();
        			m1.stop();
        			m2.stop();
        	        m3.stop();
        	        m4.stop();
        	    	T.cancel();
        			timer.cancel();
        			TextView tv,tv1;
        			tv=(TextView)findViewById(R.id.textView1);
        		    tv1=(TextView)findViewById(R.id.textView2);
        			tv.setBackgroundResource(R.drawable.green);
        			tv1.setText(" Right answer ");
        			

     				TimeCounter=TimeCounter%10;
     				String stp=String.valueOf(TimeCounter);
        			 Intent z =new Intent(getApplicationContext(), two.class);
        			 z.putExtra("get2", stp);
        			 startActivity(z);
        			 finish();
        	    }
        	  };
        	 
        	  final OnClickListener wrong1 = new OnClickListener() {
            	    public void onClick(View v) {
            	    	m4.start();m1.stop();m2.stop();m3.start();
            			 startActivity(q);
            			 opt1.setBackgroundResource(R.drawable.playbuttonred);
            			 T.cancel();finish();System.exit(0);}};
           final OnClickListener wrong2 = new OnClickListener() {
            	    public void onClick(View v) {
            	    	m4.start();m1.stop();m2.stop();m3.start();
            			 startActivity(q);
            			 opt2.setBackgroundResource(R.drawable.playbuttonred);
            			 T.cancel();finish();System.exit(0);}};
            final OnClickListener wrong3 = new OnClickListener() {
            	    public void onClick(View v) {
            	    	m4.start();m1.stop();m2.stop();m3.start();
            			 startActivity(q);
            			 opt3.setBackgroundResource(R.drawable.playbuttonred);
            			 T.cancel();finish();System.exit(0);}};
        	  final OnClickListener wrong4 = new OnClickListener() {
          	    public void onClick(View v) {
          	    	m4.start();m1.stop();m2.stop();m3.start();
          			 startActivity(q);
          			 opt4.setBackgroundResource(R.drawable.playbuttonred);
          			 T.cancel();finish();System.exit(0);}};


              Intent ans=getIntent();
              final String st=ans.getStringExtra("get1");
              if(st.equals("0")){
            	  qus.setText("Q 1.  Eating which of these dishes would qualify one as a non-vegetarian?");
                  opt1.setText("A.Malai Kofta"); opt2.setText("B.Navratan Korma"); opt3.setText("C.Gatte ki Sabzi"); opt4.setText("D. Tandoori Raan");
                  opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt3.setOnClickListener(wrong3);
                  opt4.setOnClickListener(right);
            
              } if(st.equals("1")){
            	  qus.setText("Q 1.  .  Which of these is the verb in the sentence “chandu ke chacha ne chandu ki chachi ko chandni chowk mein chatni chatayi”?");
                  opt1.setText("A.Chandu"); opt2.setText("B.Chacha"); opt3.setText("C.Chandni"); opt4.setText("D. Chatayi");
                  opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt3.setOnClickListener(wrong3);
                  opt4.setOnClickListener(right);
            
              } if(st.equals("2")){
            	  qus.setText("Q 1.  According to the title of a 2013 film, what happened at Wadala ?");
                  opt1.setText("A.Meeting"); opt2.setText("B.Romance"); opt3.setText("C.Shootout"); opt4.setText("D. Marriage");
                  opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
                  opt3.setOnClickListener(right);
            
              } if(st.equals("3")){
            	  qus.setText("Q 1.  If you have the GPS service enabled on your phone, which of these would you be able to do?");
                  opt1.setText("A.Listen to songs"); opt2.setText("B.Enable chatting"); opt3.setText("C.Navigate roads"); opt4.setText("D. Watch TV");
                  opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
                  opt3.setOnClickListener(right);
            
              } if(st.equals("4")){
            	  qus.setText("Q 1.  Lord Krishna earned which of the following names because he killed a particular demon ?");
                  opt1.setText("A.Kanhaiya"); opt2.setText("B.Murari"); opt3.setText("C.Jagannath"); opt4.setText("D. Govind");
                  opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                  opt2.setOnClickListener(right);
            
              } if(st.equals("5")){
            	  qus.setText("Q 1.  How many thousands rupee notes would your need to become a crorepati?");
                  opt1.setText("A.100"); opt2.setText("B.1000"); opt3.setText("C.10000"); opt4.setText("D. 100000");
                  opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
                  opt3.setOnClickListener(right);
            
              } if(st.equals("6")){
            	  qus.setText("Q 1.  Which of these is not a computer operating system ?");
                  opt1.setText("A.Apple OS X"); opt2.setText("B.Linux"); opt3.setText("C.Windows 8"); opt4.setText("D. Adobe Photoshop");
                  opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt3.setOnClickListener(wrong3);
                  opt4.setOnClickListener(right);
            
              } if(st.equals("7")){
            	  qus.setText("Q 1.  What is India’s first ingeniously developed passenger car?");
                  opt1.setText("A.Maruti 800"); opt2.setText("B.Tata Indica"); opt3.setText("C.Premier Padmini"); opt4.setText("D. Ambassador");
                  opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                  opt2.setOnClickListener(right);
            
              } if(st.equals("8")){
            	  qus.setText("Q 1.  In which of these sports has India never won silver medal at the Olympic games?");
                  opt1.setText("A.Boxing"); opt2.setText("B.Hockey"); opt3.setText("C.Wrestling"); opt4.setText("D. Shooting");
                  opt2.setOnClickListener(wrong2);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                  opt1.setOnClickListener(right);
            
              }if(st.equals("9")){
            	  qus.setText("Q 1. Which of these Indian cricketers are brothers?");
                  opt1.setText("A.Irfan and Yusuf Pathan"); opt2.setText("B.Ravindra and Ajay Jadeja"); opt3.setText("C.Bhuvneshwar and Vinay Kumar"); opt4.setText("D. Ishant and Rohit Sharma");
                  opt2.setOnClickListener(wrong2);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                  opt1.setOnClickListener(right);
            
              }
           
        quit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub

				startActivity(q);
			
			m1.stop();
			m2.stop();
			finish();
			}
		});
        animation2 = AnimationUtils.loadAnimation(this, R.anim.down ); 
          opt1.startAnimation(animation2);
        opt2.startAnimation(animation2);
        opt3.startAnimation(animation2);
        opt4.startAnimation(animation2);
        img.startAnimation(animation2);
        
        animation1 = AnimationUtils.loadAnimation(this, R.anim.rot ); 
        call.startAnimation(animation1);
        pop.startAnimation(animation1);
        swap.startAnimation(animation1);
        fify.startAnimation(animation1);
 
call.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				helper.inRecords("1",b,c,d);

				cur.moveToPrevious();
				call();
				
				/*m1.stop();
				m2.stop();
				m3.stop();
				m4.stop();*/
				
			}
		});
swap.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		  if(st.equals("0") || st.equals("3") ||st.equals("6") || st.equals("9")){
			  qus.setText("Q 1.  In which of these sports has India never won silver medal at the Olympic games?");
              opt1.setText("A.Boxing"); opt2.setText("B.Hockey"); opt3.setText("C.Wrestling"); opt4.setText("D. Shooting");
              opt2.setOnClickListener(wrong2);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
              opt1.setOnClickListener(right);
		  
		    } 

		  if(st.equals("1") || st.equals("4") ||st.equals("7") || st.equals("9")){
			  qus.setText("Q 1.  Eating which of these dishes would qualify one as a non-vegetarian?");
              opt1.setText("A.Malai Kofta"); opt2.setText("B.Navratan Korma"); opt3.setText("C.Gatte ki Sabzi"); opt4.setText("D. Tandoori Raan");
              opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt3.setOnClickListener(wrong3);
              opt4.setOnClickListener(right);
		  
		    } 

		  if(st.equals("2") || st.equals("5") ||st.equals("8")){
			  qus.setText("Q 1.  What is India’s first ingeniously developed passenger car?");
              opt1.setText("A.Maruti 800"); opt2.setText("B.Tata Indica"); opt3.setText("C.Premier Padmini"); opt4.setText("D. Ambassador");
              opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
              opt2.setOnClickListener(right);
		  
		    } 
	       pop.setEnabled(false);
			swap.setEnabled(false);
			fify.setEnabled(false);
			call.setEnabled(false);
	       helper.inRecords(a,"1",c,d);
			cur.moveToPrevious();
	}
});
fify.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		  
		   fify();
	
		helper.inRecords(a,b,"1",d);
		cur.moveToPrevious();
	}
});




pop.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		pop.setEnabled(false);
		swap.setEnabled(false);
		fify.setEnabled(false);
		call.setEnabled(false);
		helper.inRecords(a,b,c,"1");
		cur.moveToPrevious();
	    LayoutInflater layoutInflater = (LayoutInflater)getBaseContext()
	    	      .getSystemService(LAYOUT_INFLATER_SERVICE);  
	    	    View popupView = layoutInflater.inflate(R.layout.pop, null);  
	    	             final PopupWindow popupWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);  
	    	             
	    	             Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
	    	             Button bd1 = (Button)popupView.findViewById(R.id.button1);
	    	             Button bd2 = (Button)popupView.findViewById(R.id.button2);
	    	             btnDismiss.setOnClickListener(new Button.OnClickListener(){

	    	                 public void onClick(View v) {
	    	                  // TODO Auto-generated method stub
	    	                	 call();
	    	                  popupWindow.dismiss();
	    	                 }}); 
	    	             bd1.setOnClickListener(new Button.OnClickListener(){

	    	                     public void onClick(View v) {
	    	                      // TODO Auto-generated method stub
	    	                    	 if(st.equals("0") || st.equals("3") ||st.equals("6") || st.equals("9")){
	    	                    		 
	    	                           	  qus.setText("Q 1.  According to the title of a 2013 film, what happened at Wadala ?");
	    	                                 opt1.setText("A.Meeting"); opt2.setText("B.Romance"); opt3.setText("C.Shootout"); opt4.setText("D. Marriage");
	    	                                 opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
	    	                                 opt3.setOnClickListener(right);
	    	                           
	    	                             } 

	    	      		  if(st.equals("1") || st.equals("4") ||st.equals("7") || st.equals("9")){
	    	      			qus.setText("Q 1.  If you have the GPS service enabled on your phone, which of these would you be able to do?");
                            opt1.setText("A.Listen to songs"); opt2.setText("B.Enable chatting"); opt3.setText("C.Navigate roads"); opt4.setText("D. Watch TV");
                            opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
                            opt3.setOnClickListener(right);
	    	      		    } 

	    	      		  if(st.equals("2") || st.equals("5") ||st.equals("8")){
	    	      			 qus.setText("Q 1.  Lord Krishna earned which of the following names because he killed a particular demon ?");
                             opt1.setText("A.Kanhaiya"); opt2.setText("B.Murari"); opt3.setText("C.Jagannath"); opt4.setText("D. Govind");
                             opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                             opt2.setOnClickListener(right);
  		  
	    	      		  
	    	      		    } 
	    	                      popupWindow.dismiss();
	    	                     }});
	    	             bd2.setOnClickListener(new Button.OnClickListener(){

	    	                         public void onClick(View v) {
	    	                          // TODO Auto-generated method stub
	    	                        fify();
	    	                        popupWindow.dismiss();
	    	                         }});
	    	               
	    	             popupWindow.showAsDropDown(pop, 50, -30);
	}
});

}
	public void call(){
		pop.setEnabled(false);
		swap.setEnabled(false);
		fify.setEnabled(false);
		call.setEnabled(false);
		Intent w= new Intent(getApplicationContext(), callfile.class);
		startActivity(w);
	}
	public void fify(){
		 Intent ans=getIntent();
         final String st=ans.getStringExtra("get1");
        
		 if(st.equals("0")){
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("1")){
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("2")){
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("3")){
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("4")){
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("5")){
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("6")){
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("7")){
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("8")){
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("9")){
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);}
		   
	
		pop.setEnabled(false);
		swap.setEnabled(false);
		fify.setEnabled(false);
		call.setEnabled(false);
	}
	public void swap(){
		
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
        Toast.makeText(this, "Can not exit without finish Game", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            public void run() {
                doubleBackToExitPressedOnce=false;                
                
            }
        }, 2000);
    } 
   
     
    
}
