package com.androidwoman.activities;

import com.androidwoman.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActivitySplash extends Activity{

	private TextView footer_login_page;
	private Thread mSplashThread;
	private final int DURATION = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		//Gestion du pied de page
		footer_login_page = (TextView)findViewById(R.id.footer_login_page);
		//this.setFont(footer_login_page, "OpenSans-Light.ttf");	
		String fontPath = "OpenSans-Light.ttf";
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        footer_login_page.setTypeface(tf);
        
        

		mSplashThread = new Thread() {
			 
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(DURATION);
                    } catch (InterruptedException e) {
                    } finally {
                        finish();
                        Intent intent = new Intent(getBaseContext(),
                        		ActivityHome.class);
                        startActivity(intent);
                    }
                }
            }
        };
        mSplashThread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);*/
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		/*// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}*/
		return super.onOptionsItemSelected(item);
	}
}
