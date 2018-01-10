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
public class four extends Activity {
	Button quit,pop,fify,call, swap;
	Button opt1,opt2,opt3,opt4;
	Animation animation2,animation1;
	Chronometer cr;
	Gallery img;
	String a,b,c,d;
	Cursor cur;

int TimeCounter;
	
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
        img.setBackgroundResource(R.drawable.fourdigit);
        cr=(Chronometer)findViewById(R.id.chronometer1);
        m1=MediaPlayer.create(getApplicationContext(), R.raw.tiktok);
        m2=MediaPlayer.create(getApplicationContext(), R.raw.question);
        m3=MediaPlayer.create(getApplicationContext(), R.raw.rightanswer);
        m4=MediaPlayer.create(getApplicationContext(), R.raw.fail_buzzer);
        //    m1.start();
        m2.start();
        cr.setBase(SystemClock.elapsedRealtime());
        cr.start();
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

        
        m1=MediaPlayer.create(getApplicationContext(), R.raw.tiktok);
        
        
        final Timer T=new Timer();
         T.scheduleAtFixedRate(new TimerTask() {         
                @Override
                public void run() {
                m1.start();              

                }
            }, 5, 1000);

          final Intent q = new Intent(getApplicationContext(), score.class);
         q.putExtra("scr", "20000");
         
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
         			 Intent z =new Intent(getApplicationContext(), five.class);
         			 z.putExtra("get5", st);
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
           final String st=ans.getStringExtra("get4");
           if(st.equals("0")){
         	  qus.setText("Q 4.  Damascus is the capital of which country?");
               opt1.setText("A. Tunisia"); opt2.setText("B. Jordan"); opt3.setText("C. Syria"); opt4.setText("D. Lebanon");
               opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
               opt3.setOnClickListener(right);
         
           } if(st.equals("1")){
         	  qus.setText("Q 4.  The 2013 film Lootera is partly based on which short story by O Henry ?");
               opt1.setText("A. The Ransom of Red Chief"); opt2.setText("B. The Gift of the Magi"); opt3.setText("C. The Last leaf"); opt4.setText("D. The Third Ingredient");
               opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
               opt3.setOnClickListener(right);
         
           } if(st.equals("2")){
         	  qus.setText("Q 4.  Which of these is the administrative head of a district in India?");
               opt1.setText(" A.DM"); opt2.setText("B. DIG"); opt3.setText("C. DCP"); opt4.setText("D. DSP");
               opt2.setOnClickListener(wrong2);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
               opt1.setOnClickListener(right);
         
           } if(st.equals("3")){
         	  qus.setText("Q 4.  Which of these cricket tournaments is often referred to as the ‘Mini World Cup’ ?");
               opt1.setText("A. Natwest Series"); opt2.setText("B. Asia Cup"); opt3.setText("C. ICC Championship Trophy"); opt4.setText("D. Twenty20 World Cup");
               opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
               opt3.setOnClickListener(right);
         
           } if(st.equals("4")){
         	  qus.setText("Q 4.  In July 2013, Indian highest judicial court issued a rule that anybody who wants to buy which of these these has to show his identity card.");
               opt1.setText("A. Alcohol"); opt2.setText("B. Sandalwood"); opt3.setText("C. Gold"); opt4.setText("D. Acid");
               opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt2.setOnClickListener(wrong2);
               opt4.setOnClickListener(right);
         
           } if(st.equals("5")){
         	  qus.setText("Q 4.  Which of these festivals is celebratedin honor of an avatar of Lord Vishnu?");
               opt1.setText("A. Janmashtami"); opt2.setText("Ganesha Chaturthi"); opt3.setText("C. Vishwakarma"); opt4.setText("D. Maha Shivratri");
               opt2.setOnClickListener(wrong2);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
               opt1.setOnClickListener(right);
         
           } if(st.equals("6")){
         	  qus.setText("Q 4.  ) Which of these films is the first Hindi film as a lead actor for a South Indian actor ?");
               opt1.setText("A. Aashiqui 2"); opt2.setText("B. Raanjhanaa"); opt3.setText("C. Fukrey"); opt4.setText("D. Ghanchakkar");
               opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
               opt2.setOnClickListener(right);
         
           } if(st.equals("7")){
         	  qus.setText("Q 4.  In geometry, if a shape has only three sides namely A, B and C, then what shape would that be ?");
               opt1.setText("A. Rectangle"); opt2.setText("B. Square"); opt3.setText("C. Triangle"); opt4.setText("D. Pentagon");
               opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
               opt3.setOnClickListener(right);
         
           } if(st.equals("8")){
         	  qus.setText("Q 4.  Complete this popular saying “Daane Daane par likha hai _________ ” ?");
               opt1.setText("A. Ugaane waale ka kaam"); opt2.setText("B. Kharidne waale kaa daam"); opt3.setText("C. Pakaane waale ka paigam"); opt4.setText("D. Khaane waale ka naam");
               opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt2.setOnClickListener(wrong2);
               opt4.setOnClickListener(right);
         
           }if(st.equals("9")){
         	  qus.setText("Q 4.  Which one of these states is the largest in area ?");
               opt1.setText("A. Assam"); opt2.setText("B. Arunachal Pradesh"); opt3.setText("C. Punjab"); opt4.setText("D. Haryana");
               opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
               opt2.setOnClickListener(right);
         
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
			  qus.setText("Q 4.  In July 2013, Indian highest judicial court issued a rule that anybody who wants to buy which of these these has to show his identity card.");
              opt1.setText("A. Alcohol"); opt2.setText("B. Sandalwood"); opt3.setText("C. Gold"); opt4.setText("D. Acid");
              opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt2.setOnClickListener(wrong2);
              opt4.setOnClickListener(right);
		  
		    } 

		  if(st.equals("1") || st.equals("4") ||st.equals("7") || st.equals("9")){
			  qus.setText("Q 4.  Which of these festivals is celebratedin honor of an avatar of Lord Vishnu?");
              opt1.setText("A. Janmashtami"); opt2.setText("Ganesha Chaturthi"); opt3.setText("C. Vishwakarma"); opt4.setText("D. Maha Shivratri");
              opt2.setOnClickListener(wrong2);  opt3.setOnClickListener(wrong3);opt4.setOnClickListener(wrong4);
              opt1.setOnClickListener(right);
		  
		    } 

		  if(st.equals("2") || st.equals("5") ||st.equals("8")){
			  qus.setText("Q 4.  ) Which of these films is the first Hindi film as a lead actor for a South Indian actor ?");
              opt1.setText("A. Aashiqui 2"); opt2.setText("B. Raanjhanaa"); opt3.setText("C. Fukrey"); opt4.setText("D. Ghanchakkar");
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
	    	                    		 qus.setText("Q 4.  In geometry, if a shape has only three sides namely A, B and C, then what shape would that be ?");
	  	    	      	               opt1.setText("A. Rectangle"); opt2.setText("B. Square"); opt3.setText("C. Triangle"); opt4.setText("D. Pentagon");
	  	    	      	               opt1.setOnClickListener(wrong1);  opt2.setOnClickListener(wrong2);opt4.setOnClickListener(wrong4);
	  	    	      	               opt3.setOnClickListener(right);
	    	      		       
	    	      	        
	    	      		  
	    	      		    } 

	    	      		  if(st.equals("1") || st.equals("4") ||st.equals("7") || st.equals("9")){
	    	      			qus.setText("Q 4.  Complete this popular saying “Daane Daane par likha hai _________ ” ?");
 	      	               opt1.setText("A. Ugaane waale ka kaam"); opt2.setText("B. Kharidne waale kaa daam"); opt3.setText("C. Pakaane waale ka paigam"); opt4.setText("D. Khaane waale ka naam");
 	      	               opt1.setOnClickListener(wrong1);  opt3.setOnClickListener(wrong3);opt2.setOnClickListener(wrong2);
 	      	               opt4.setOnClickListener(right);
	    	      		  
	    	      		    } 

	    	      		  if(st.equals("2") || st.equals("5") ||st.equals("8")){
	    	      			 qus.setText("Q 4.  Which one of these states is the largest in area ?");
  	      	               opt1.setText("A. Assam"); opt2.setText("B. Arunachal Pradesh"); opt3.setText("C. Punjab"); opt4.setText("D. Haryana");
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
      final String st=ans.getStringExtra("get4");
     
		 if(st.equals("0")){
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("1")){
			   opt2.setEnabled(false);opt2.setBackgroundResource(R.drawable.playbuttonred);
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);}
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
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("7")){
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);
			   opt4.setEnabled(false);opt4.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("8")){
			   opt1.setEnabled(false);opt1.setBackgroundResource(R.drawable.playbuttonred);
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);}
		   if(st.equals("9")){
			   opt3.setEnabled(false);opt3.setBackgroundResource(R.drawable.playbuttonred);
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
