package com.NativeSample;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;

public class NativeSampleActivity extends Activity {
    Date now;
	CharSequence tdy;
	Date dest;
	CharSequence pragyan;
	long diffInMis;
	TextView dtv;
	TextView htv;
	TextView mtv;
	TextView stv;
	/** Called when the activity is first created. */
    @Override
    
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutInflater().inflate(R.layout.main,null));
    }
    
    public void onStart(){
    	super.onStart();
    	dtv=(TextView) this.findViewById(R.id.days_count_view);
    	htv=(TextView) this.findViewById(R.id.hr_count_view);
    	mtv=(TextView) this.findViewById(R.id.min_count_view);
    	stv=(TextView) this.findViewById(R.id.sec_count_view);
    	startCountDown();
    }
    
    public void startCountDown(){
    	now = new Date();
        tdy= DateFormat.format("yyyy-MM-dd hh:mm:ss", now.getTime());
        int year=112;
        int month=01;
        int date=22;
        int hour=00;
        int min=00;
        int sec=00;	
        dest = new Date(year,month,date,hour,min,sec);
        pragyan= DateFormat.format("yyyy-MM-dd hh:mm:ss", dest.getTime());
        diffInMis= dest.getTime() - now.getTime();
        Prag counter=new Prag(diffInMis,1000);

        counter.start();
    }
    
    


	public class Prag extends CountDownTimer {
		long days,rem,hours,rem2,mins,secs;
		public Prag(long millisInFuture,long countDownInterval){
			super(millisInFuture,countDownInterval);
		}
		public void onFinish(){
	//		tv.setText("Prayan is here !!!");
		}
		public void onTick(long millisUntilFinished){
			millisUntilFinished=millisUntilFinished/1000;
			days= millisUntilFinished/86400;
			rem=millisUntilFinished%86400;
			
			hours=rem/3600;
			rem2=rem%3600;
			mins=rem2/60;
			secs=rem2%60;
			setTexts();
			Log.v("damn",String.valueOf(days));

		}
		public void setTexts(){
			dtv.setText(String.valueOf(days));
			htv.setText(String.valueOf(hours));
			mtv.setText(String.valueOf(mins));
			stv.setText(String.valueOf(secs));
		}
		
	}
}