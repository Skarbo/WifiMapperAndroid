package com.skarbo.wifimapper.receiver;

import com.skarbo.wifimapper.handler.WifiHandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WifiBroadcastReceiver extends BroadcastReceiver {

	private WifiHandler wifiHandler;

	public WifiBroadcastReceiver(WifiHandler wifiHandler) {
		this.wifiHandler = wifiHandler;
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		if (this.wifiHandler != null) {
			this.wifiHandler.handleWifiScan(this.wifiHandler.getWifiManager().getScanResults());
		}
	}

}
