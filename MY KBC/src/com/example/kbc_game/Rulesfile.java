package com.example.kbc_game;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import com.example.KBC_Player.R;

public class Rulesfile extends Activity {
	Button back;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules);
        back=(Button)findViewById(R.id.button1);
        back.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i= new Intent(getApplicationContext(), MainActivity.class);	
			startActivity(i);
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
        Toast.makeText(this, "Press Home Button", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            public void run() {
                doubleBackToExitPressedOnce=false;                
                
            }
        }, 2000);
    } 
    
    
}
