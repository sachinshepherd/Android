package com.example.kbc_game;



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
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
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
public class three extends Activity {
	Button quit,pop,fify,call, swap;
	Button opt1,opt2,opt3,opt4;
	Animation animation2,animation1;
	Chronometer cr;
	Gallery img;

int TimeCounter;

String a,b,c,d;
Cursor cur;
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
        img.setBackgroundResource(R.drawable.threedigit);
        cr=(Chronometer)findViewById(R.id.chronometer1);
        m1=MediaPlayer.create(getApplicationContext(), R.raw.tiktok);
        m2=MediaPlayer.create(getApplicationContext(), R.raw.question);
        m3=MediaPlayer.create(getApplicationContext(), R.raw.rightanswer);
        m4=MediaPlayer.create(getApplicationContext(), R.raw.fail_buzzer);
        //    m1.start();
        m2.start();
        cr.setBase(SystemClock.elapsedRealtime());
        cr.start();
        
        m1=MediaPlayer.create(getApplicationContext(), R.raw.tiktok);
        final db4 helper=new db4(getApplicationContext(), null,null, 0);
        cur=helper.getAllTitles();
		cur.moveToLast();
		
		if(cur.getString(0).equals("1") ){
			call.setEnabled(false);call.setBackgroundResource(R.drawable.phonw);}
		if(cur.getString(1).equals("1") ){
			swap.setEnabled(false);swap.setBackgroundResource(R.drawable.doublearrowww);}
		if(cur.getString(2).equals("1") ){
			fify.setEnabled(false);fify.setBackgroundResource(R.drawable.fiftyfiftyw);}
		if(cur.getString(3).equals("1") ){
			pop.setEnabled(false);pop.setBackgroundResource(R.drawable.powerpapluw);}

      	
		a=cur.getString(0);
		b=cur.getString(1);
		c=cur.getString(2);
				d=cur.getString(3);
 

        
        final Timer T=new Timer();
         T.scheduleAtFixedRate(new TimerTask() {         
                @Override
                public void run() {
                m1.start();              

                }
            }, 5, 1000);

          final Intent q = new Intent(getApplicationContext(), score.class);
         q.putExtra("scr", "10000");
         
         final Timer timer = new Timer();
         timer.schedule((TimerTask)(new TimerTask(){
             

             public void run() {
                m1.stop();
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
         			timer.cancel();

        	    	T.cancel();

        	    	TextView tv,tv1;
        			tv=(TextView)findViewById(R.id.textView1);
        		    tv1=(TextView)findViewById(R.id.textView2);
        			tv.setBackgroundResource(R.drawable.green);
        			tv1.setText(" Right answer ");
      				TimeCounter=TimeCounter%10;
      				String st=String.valueOf(TimeCounter);
         			 Intent z =new Intent(getApplicationContext(), four.class);
         			 z.putExtra("get4", st);
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
               final String st=ans.getStringExtra("get3");
               if(st.equals("0")){
             	  qus.setText("Q 3.  Which of these is a species of panda found in India?");
                   opt1.setText("A.Blue"); opt2.setText("B.Brown"); opt3.setText("C.Red "); opt4.setText("D. Black");
                   opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
                   opt3.setOnClickListener(right);
             
               } if(st.equals("1")){
             	  qus.setText("Q 3. ) In the film ‘Namak Halaal’, which character says ” I can talk English, I can walk English, I can laugh English” ?");
                   opt1.setText("A.Amit Srivastava"); opt2.setText("B.Arjun Singh"); opt3.setText("C.Vijay Khanna"); opt4.setText("D. Anthony Gonsalves");
                   opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt2.setOnClickListener(wrong2);
                   opt4.setOnClickListener(right);
             
               } if(st.equals("2")){
             	  qus.setText("Q 3.  Which part of a human eye is removed during a cataract operation ?");
                   opt1.setText("A.Iris"); opt2.setText("B.Lens"); opt3.setText("C.Pupil"); opt4.setText("D.Cornea");
                   opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                   opt2.setOnClickListener(right);
             
               } if(st.equals("3")){
             	  qus.setText("Q 3.  In the Ramayana, which of these rivers is also called ‘Bhagirathi’ meaning the daughter of Bhagirathi ?");
                   opt1.setText("A.Yamuna"); opt2.setText("B.Narmada"); opt3.setText("C.Ganga"); opt4.setText("D.Saraswati");
                   opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
                   opt3.setOnClickListener(right);
             
               } if(st.equals("4")){
             	  qus.setText("Q 3.  In hindu mythology, which of these is a mother-son pair?");
                   opt1.setText("A.Holika-Prahalad "); opt2.setText("B.Shakuntala-Bharata"); opt3.setText("C.Savitri-Satyavan"); opt4.setText("D.Kunti-Pandu");
                   opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                   opt2.setOnClickListener(right);
             
               } if(st.equals("5")){
             	  qus.setText("Q 3.  The maximum part of a chicken egg is composed of what?");
                   opt1.setText("A.Water"); opt2.setText("B.Protein"); opt3.setText("C.Fat"); opt4.setText("D.Cholesterol");
                   opt2.setOnClickListener(wrong2);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                   opt1.setOnClickListener(right);
             
               } if(st.equals("6")){
             	  qus.setText("Q 3.  In Sep 2013, which company announced that they will acquire Nokia?");
                   opt1.setText("A.Intel"); opt2.setText("B.Microsoft"); opt3.setText("C.Samsung"); opt4.setText("D.Sony");
                   opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                   opt2.setOnClickListener(right);
             
               } if(st.equals("7")){
             	  qus.setText("Q 3.  Who won the Champions League Twenty20 in 2013?");
                   opt1.setText("A.Mumbai Indians"); opt2.setText("B.Chennai Super Kings"); opt3.setText("C.Trinidad and Tobago"); opt4.setText("D.Rajasthan Royals");
                   opt2.setOnClickListener(wrong2);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                   opt1.setOnClickListener(right);
             
               } if(st.equals("8")){
             	  qus.setText("Q 3.  Which of these would you need if you are shopping online ?");
                   opt1.setText("A.Cash-on-purchase"); opt2.setText("B.Credit Card"); opt3.setText("C.Clock"); opt4.setText("D.Car");
                   opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                   opt2.setOnClickListener(right);
             
               }if(st.equals("9")){
             	  qus.setText("Q 3.  Rajya Vardan singh Rathore, Gagan Narang and Vijay Kumar have won the Olympic medal in which games?");
                   opt1.setText("A.Archery"); opt2.setText("B.Kayaking"); opt3.setText("C.Cannoing"); opt4.setText("D.Shooting");
                   opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt2.setOnClickListener(wrong2);
                   opt4.setOnClickListener(right);
             
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
			  qus.setText("Q 3. ) In the film ‘Namak Halaal’, which character says ” I can talk English, I can walk English, I can laugh English” ?");
              opt1.setText("A.Amit Srivastava"); opt2.setText("B.Arjun Singh"); opt3.setText("C.Vijay Khanna"); opt4.setText("D. Anthony Gonsalves");
              opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt2.setOnClickListener(wrong2);
              opt4.setOnClickListener(right);
		  
		    } 
		  
		  
		  

		  if(st.equals("1") || st.equals("4") ||st.equals("7") || st.equals("9")){
			  qus.setText("Q 3.  Which part of a human eye is removed during a cataract operation ?");
              opt1.setText("A.Iris"); opt2.setText("B.Lens"); opt3.setText("C.Pupil"); opt4.setText("D.Cornea");
              opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
              opt2.setOnClickListener(right);
		  
		    } 

		  if(st.equals("2") || st.equals("5") ||st.equals("8")){
			  qus.setText("Q 3.  Which of these is a species of panda found in India?");
              opt1.setText("A.Blue"); opt2.setText("B.Brown"); opt3.setText("C.Red "); opt4.setText("D. Black");
              opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
              opt3.setOnClickListener(right);
		  
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
	    	                    		 qus.setText("Q 3.  Who won the Champions League Twenty20 in 2013?");
	    	                              opt1.setText("A.Mumbai Indians"); opt2.setText("B.Chennai Super Kings"); opt3.setText("C.Trinidad and Tobago"); opt4.setText("D.Rajasthan Royals");
	    	                              opt2.setOnClickListener(wrong2);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
	    	                              opt1.setOnClickListener(right);
	    	      		  
	    	      		    } 

	    	      		  if(st.equals("1") || st.equals("4") ||st.equals("7") || st.equals("9")){
	    	      			qus.setText("Q 3.  Which of these would you need if you are shopping online ?");
                            opt1.setText("A.Cash-on-purchase"); opt2.setText("B.Credit Card"); opt3.setText("C.Clock"); opt4.setText("D.Car");
                            opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
                            opt2.setOnClickListener(right);
	    	      		  
	    	      		    } 

	    	      		  if(st.equals("2") || st.equals("5") ||st.equals("8")){
	    	      			 qus.setText("Q 3.  Rajya Vardan singh Rathore, Gagan Narang and Vijay Kumar have won the Olympic medal in which games?");
                             opt1.setText("A.Archery"); opt2.setText("B.Kayaking"); opt3.setText("C.Cannoing"); opt4.setText("D.Shooting");
                             opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt2.setOnClickListener(wrong2);
                             opt4.setOnClickListener(right);
	    	      		  
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
         final String st=ans.getStringExtra("get3");
        
		 if(st.equals("0")){
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("1")){
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("2")){
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("3")){
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("4")){
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("5")){
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("6")){
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("7")){
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("8")){
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("9")){
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);}
		   
	
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
