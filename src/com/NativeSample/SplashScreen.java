package com.NativeSample;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.content.Intent;

public class SplashScreen extends Activity {
	/** Called when the activity is first created. */
	
	private Thread mSplashThread;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.splash);
	    
	    final SplashScreen sPlashScreen=this;
	    
	    mSplashThread = new Thread(){
	    	@Override
	    	public void run(){
	    		try {
	    			synchronized (this) {
						wait(5000);
	    			}
	    		}
	    		catch (InterruptedException ex) {
					// TODO: handle exception
				}	
	    		finish();
	    		
	    		Intent intent=new Intent();
	    		intent.setClass(sPlashScreen, NativeSampleActivity.class);
	    		startActivity(intent);
	    		stop();
	    		
	    	}
	    };
	    mSplashThread.start();
	    
	    
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent evt){
		if(evt.getAction()== MotionEvent.ACTION_DOWN){
			synchronized (mSplashThread) {
				mSplashThread.notifyAll();
				
			}
		}
		return true;		
	}


}