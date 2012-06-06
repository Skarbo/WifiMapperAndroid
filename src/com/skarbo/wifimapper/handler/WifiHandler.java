package com.skarbo.wifimapper.handler;

import java.util.List;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

public interface WifiHandler {

	abstract WifiManager getWifiManager();

	abstract void handleWifiScan(List<ScanResult> scanResults);

}
