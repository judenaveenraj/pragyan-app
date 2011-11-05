package com.NativeSample;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ShowListViewer extends ListActivity {

	    private String strings[]={};
		@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.listviewer);
		    setListAdapter(new ArrayAdapter(this, R.layout.list_item, strings));
		    startActivity(new Intent(this, sid.class));
	    }
	}
