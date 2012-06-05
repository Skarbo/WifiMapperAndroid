package com.skarbo.wifimapper.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MapperActivity extends Activity {

	private static final String TAG = "MapperActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "On create");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "On destroy");
	}
	
}
