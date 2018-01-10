package com.example.kbc_game;

import java.util.Timer;
import java.util.TimerTask;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;
import com.example.KBC_Player.R;

public class callfile extends Activity {
	Button call;
	EditText et1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callnew);
        call=(Button)findViewById(R.id.button1);
        et1=(EditText)findViewById(R.id.editText1);
        
			

			call.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					// String url = et1.getText().toString();
					 String number = "tel:" + et1.getText().toString().trim();
				        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number)); 
				        startActivity(callIntent);
				        
		
				/*	
					 Timer timer = new Timer();
			         timer.schedule((TimerTask)(new TimerTask(){
			             

			             public void run() {
			               finish();
			               System.exit(1);
			                }
			         }),5000);
					*/                 
				}
			});
	        
	      
	    
			

	       
	        
	        
	     

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

     
    
}
