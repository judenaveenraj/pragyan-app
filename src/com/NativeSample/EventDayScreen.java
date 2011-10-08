package com.NativeSample;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class EventDayScreen extends Activity {

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

}
