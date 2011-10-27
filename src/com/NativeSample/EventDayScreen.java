package com.NativeSample;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class EventDayScreen extends Activity {

	private EventDayScreen eventdayscreen;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    Configuration config=getResources().getConfiguration();
	    changeOrientation(config);
	
	    // TODO Auto-generated method stub
	}
	
	public void onConfigurationChanged(Configuration newConfig){
		changeOrientation(newConfig);
	}
	
	public void changeOrientation(Configuration myconfig){
		if (myconfig.orientation==Configuration.ORIENTATION_PORTRAIT){
		setContentView(R.layout.eventday);}
		if (myconfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
			setContentView(R.layout.eventday_land);}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent evt){
		if (evt.getAction()==MotionEvent.ACTION_DOWN){
			Log.v("damn","inside");
			final EventDayScreen eventdayscreen=this;
			Intent intent = new Intent();
			intent.setClass(eventdayscreen, NativeSampleActivity.class);
			startActivity(intent);
		}
		return true;
	}

}
