package com.geniusgithub.mediarender;

import java.util.HashMap;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.geniusgithub.mediarender.util.CommonLog;
import com.geniusgithub.mediarender.util.LogFactory;

public class RenderApplication  extends Application implements ItatisticsEvent{

	private static final CommonLog log = LogFactory.createLog();

	private static RenderApplication mInstance;

	private DeviceInfo mDeviceInfo;
	
	
	public synchronized static RenderApplication getInstance(){
		return mInstance;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		log.e("RenderApplication onCreate");
		
		mInstance = this;
		mDeviceInfo = new DeviceInfo();
		
	}

	public void updateDevInfo(String name, String uuid){
		mDeviceInfo.dev_name = name;
		mDeviceInfo.uuid = uuid;
	}
	
	public void setDevStatus(boolean flag){
		mDeviceInfo.status = flag;
		DeviceUpdateBrocastFactory.sendDevUpdateBrocast(this);
	}
	
	public DeviceInfo getDevInfo(){
		return mDeviceInfo;
	}
	
	@Override
	public void onEvent(String eventID) {
		log.e("eventID = " + eventID);	
	}

	@Override
	public void onEvent(String eventID, HashMap<String, String> map) {
		log.e("eventID = " + eventID);	
	}
	
	public static void onPause(Activity context){
	}
	
	public static void onResume(Activity context){
	}
	
	public static void onCatchError(Context context){
	}
}
