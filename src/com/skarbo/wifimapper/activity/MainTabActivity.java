package com.skarbo.wifimapper.activity;

import java.util.List;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.skarbo.wifimapper.R;
import com.skarbo.wifimapper.handler.WifiHandler;
import com.skarbo.wifimapper.receiver.WifiBroadcastReceiver;

public class MainTabActivity extends TabActivity implements WifiHandler {
	private static final String TAG = "MainTabActivity";

	private WifiManager wifiManager;

	private TabHost tabHost;
	private boolean isInit = false;

	private WifiBroadcastReceiver wifiBroadcastReceiver;

	// ... ON

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "On create");
		setContentView(R.layout.main_tab);

		if (!this.isInit) {
			doInit();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "On destroy");
	}

	// ... /ON

	// ... GET

	public WifiManager getWifiManager() {
		return this.wifiManager;
	}

	// ... /GET

	// ... DO

	private void doInit() {
		doSetupTabHost();
		tabHost.getTabWidget().setDividerDrawable(R.drawable.tab_divider);

		TabHost tabHost = getTabHost(); 
	    TabHost.TabSpec spec;
	    Intent intent;

		doSetupTab("Mapper", "mapper", new Intent(this, MapperActivity.class));
		doSetupTab("Tagger", "tagger", new Intent(this, TaggerActivity.class));
		doSetupTab("Wi-Fi", "wifi", new Intent(this, WifiActivity.class));

		this.wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
		this.wifiBroadcastReceiver = new WifiBroadcastReceiver(this);

		// Start WiFi
		this.doStartWifi();
		
		this.isInit = true;
	}

	private void doSetupTabHost() {
		tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup();
	}

	private void doSetupTab(final String tag, final String indicator, Intent intent) {
		View tabview = createTabView(tabHost.getContext(), tag);

		TabSpec setContent = tabHost.newTabSpec(tag).setIndicator(tabview).setContent(intent);
		tabHost.addTab(setContent);
	}

	private void doStartWifi()
	{
		// Intent filter
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
		
		// Register WiFi receiver
		this.registerReceiver(this.wifiBroadcastReceiver, intentFilter);
		this.getWifiManager().startScan();
	}
	// ... /DO

	// ... CREATE

	private static View createTabView(final Context context, final String text) {
		View view = LayoutInflater.from(context).inflate(R.layout.tabs_bg, null);
		TextView tv = (TextView) view.findViewById(R.id.tabsText);
		tv.setText(text);
		return view;
	}

	// ... /CREATE

	// ... HANDLE

	public void handleWifiScan(List<ScanResult> scanResults) {

	}

	// ... /HANDLE

}
