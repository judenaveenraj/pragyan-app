package com.NativeSample;

import java.util.Date;

import com.NativeSample.NativeSampleActivity.AnimListener;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class NativeSampleActivity extends Activity implements android.view.View.OnClickListener{
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
        
        /*FrameLayout fl = (FrameLayout) findViewById(R.id.menuLayout);
        AnimationSet set = new AnimationSet(true);
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(1000);
        set.addAnimation(animation);
        animation = new TranslateAnimation(
            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
            Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f
        );
        
        animation.setDuration(5000);
        set.addAnimation(animation);
        animation =new RotateAnimation(0.0f, 45.0f);
        animation.setDuration(5000);
        set.addAnimation(animation);
        
        set.setFillAfter(true);
        LayoutAnimationController controller =
            new LayoutAnimationController(set, 0.25f);
;
        final ViewGroup vg = (ViewGroup) findViewById(R.id.menuLayout);
        final ImageView vg1 = (ImageView) findViewById(R.id.top_btn);
        set.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);
				vg1.setLayoutParams(params);
			}
		});
        vg.setLayoutAnimation(controller);
        ImageView top_btn = (ImageView) findViewById(R.id.top_btn);
    	top_btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.v("Clicked","Top_btnn clicked");
				
			}
		});*/

    }
    
    public void onStart(){
    	super.onStart();
    	dtv=(TextView) this.findViewById(R.id.days_count_view);
    	htv=(TextView) this.findViewById(R.id.hr_count_view);
    	mtv=(TextView) this.findViewById(R.id.min_count_view);
    	stv=(TextView) this.findViewById(R.id.sec_count_view);
    	startCountDown();
    	startMenuAnim();
    }
    
    public void setClickListeners(){
    	ImageView top_btn=(ImageView)findViewById(R.id.top_btn);
    	ImageView bottom_btn=(ImageView)findViewById(R.id.bottom_btn);
    	ImageView right_btn=(ImageView)findViewById(R.id.pivotImg);
    	ImageView left_btn=(ImageView)findViewById(R.id.left_btn);
    	top_btn.setOnClickListener(this);
    	bottom_btn.setOnClickListener(this);
    	left_btn.setOnClickListener(this);
    	right_btn.setOnClickListener(this);
    }
    
    public void startMenuAnim(){
    	Animation rotateMenu = AnimationUtils.loadAnimation(this, R.anim.main_rotate);
    	LayoutAnimationController rotController = new LayoutAnimationController(rotateMenu, 0);
    	FrameLayout menuWheelLayout = (FrameLayout)findViewById(R.id.menuLayout);
    	AnimListener animlisten = new AnimListener();
    	rotateMenu.setAnimationListener(animlisten);
    	menuWheelLayout.setLayoutAnimation(rotController);
    
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
			//Log.v("damn",String.valueOf(days));

		}
		public void setTexts(){
			dtv.setText(String.valueOf(days));
			htv.setText(String.valueOf(hours));
			mtv.setText(String.valueOf(mins));
			stv.setText(String.valueOf(secs));
		}
		
	}
	
	
	public class AnimListener implements AnimationListener{
		ViewGroup.LayoutParams top_params=null;
		ViewGroup.LayoutParams bot_params=null;
		ViewGroup.LayoutParams left_params=null;
		ViewGroup.LayoutParams right_params=null;
		
		public void onAnimationStart(Animation animation) {
			ImageView top_btn=(ImageView)findViewById(R.id.top_btn);
        	ImageView bottom_btn=(ImageView)findViewById(R.id.bottom_btn);
        	ImageView right_btn=(ImageView)findViewById(R.id.pivotImg);
        	ImageView left_btn=(ImageView)findViewById(R.id.left_btn);
        	top_params=top_btn.getLayoutParams();
        	bot_params=bottom_btn.getLayoutParams();
        	left_params=left_btn.getLayoutParams();
        	right_params=right_btn.getLayoutParams();
		}

        public void onAnimationEnd(Animation animation) 
        {
        	Log.v("done","animation done");
        	setClickListeners();
        	ImageView top_btn=(ImageView)findViewById(R.id.top_btn);
        	ImageView bottom_btn=(ImageView)findViewById(R.id.bottom_btn);
        	ImageView right_btn=(ImageView)findViewById(R.id.pivotImg);
        	ImageView left_btn=(ImageView)findViewById(R.id.left_btn);
        	RelativeLayout.LayoutParams para=(android.widget.RelativeLayout.LayoutParams) top_btn.getLayoutParams();
        	RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
        			para);
        	RelativeLayout rl = (RelativeLayout) findViewById(R.id.menuAbsLayout);
        	rl.setLayoutParams(new FrameLayout.LayoutParams(rl.getLayoutParams()));
        	
        	//FrameLayout fl=(FrameLayout) findViewById(R.id.menuLayout);
        	//fl.setLayoutParams(new LinearLayout.LayoutParams(fl.getLayoutParams()));
        	final Animation a = AnimationUtils.loadAnimation(NativeSampleActivity.this, R.anim.main_rotate_init);
        	top_btn.startAnimation(a);
        
        	params=new RelativeLayout.LayoutParams(top_btn.getLayoutParams());
        	params.leftMargin=0;
        	top_btn.setLayoutParams(params);
        	bottom_btn.setLayoutParams(bot_params);
        	right_btn.setLayoutParams(right_params);
        	left_btn.setLayoutParams(left_params);

        }

        public void onAnimationRepeat(Animation animation) {
        }
	}
	
	
	public void onClick(View v){
		if(v.getId()==R.id.bottom_btn){
			Log.d("ClickEvent","botoom map clicked");
		}
		if(v.getId()==R.id.top_btn){
			Log.d("ClickEvent","top map clicked");
		}
		if(v.getId()==R.id.left_btn){
			Log.d("ClickEvent","left ap clicked");
		}
		if(v.getId()==R.id.pivotImg){
			Log.d("ClickEvent","right map clicked");
		}
		Intent inte = new Intent();
		inte.setClass(this,ShowListViewer.class);
		startActivity(inte);
	}
	
}