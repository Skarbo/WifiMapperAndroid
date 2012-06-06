package com.skarbo.wifimapper.activity;

import com.skarbo.wifimapper.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TaggerActivity extends Activity {

	private static final String TAG = "TaggerActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "On create");

		setContentView(R.layout.tagger);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "On destroy");
	}

}
