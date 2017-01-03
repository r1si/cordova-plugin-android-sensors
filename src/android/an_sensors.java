package com.cordova.ansensors.plugin;

import org.apache.cordova.*;
import java.io.*;
import java.net.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import android.app.KeyguardManager;
import android.media.AudioManager;
import android.content.Context;
import android.app.Activity;
import android.telephony.TelephonyManager;

public class an_sensors extends CordovaPlugin {
	private static final String TAG = "CordovaShellExecute";
	@Override
	public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		Context context = this.cordova.getActivity().getApplicationContext();
		if (action.equals("isDeviceLock")){
			callbackContext.success(String.valueOf(isDeviceLock(context)));
			return true;

		}else if(action.equals("isCallActive")){
			callbackContext.success(String.valueOf(isCallActive(context)));
			return true;
		}else if(action.equals("getDeviceNetwokActivity")){
			callbackContext.success(String.valueOf(getDeviceNetwokActivity(context)));
			return true;
		}else{
			callbackContext.error("errore");
			return false;
		}
	}

	/**
	 * Function that check if phone is in calling
	 * @param Context context - The context of application
	 * @return boolean
	 */
	public static boolean isCallActive(Context context){
		AudioManager manager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
		if(manager.getMode()==AudioManager.MODE_IN_CALL){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Function that check if phone is locking or not
	 * @param Context context - The context of application
	 * @return boolean
	 */
	public static boolean isDeviceLock(Context context){
		boolean isPhoneLocked; //declare helper variable
		int crt_api_version = Integer.valueOf(android.os.Build.VERSION.SDK);
		KeyguardManager myKM = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE); //keyguardManager

		if(crt_api_version >= 22){
			isPhoneLocked = myKM.isDeviceLocked();
		}else{
			isPhoneLocked = myKM.inKeyguardRestrictedInputMode();
		}

		return  isPhoneLocked; // right one
	}

	/**
	 * Function that get the current device netwok activity
	 * @param Context context - The context of application
	 * @return int - [0,1,2,3,4,5,6]
	 */
	public static int getDeviceNetwokActivity(Context context){
		TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE); // TelehponyManager
		return  manager.getDataActivity();
	}

	/**
	 * Function to close Andorid Socket
	 * @param xs
	 */
	public static void closeSilently(Object... xs) {
		// Note: on Android API levels prior to 19 Socket does not implement Closeable
		for (Object x : xs) {
			if (x != null) {
				try {
					Log.d(TAG,"closing: "+x);
					if (x instanceof Closeable) {
						((Closeable)x).close();
					} else if (x instanceof Socket) {
						((Socket)x).close();
					} else if (x instanceof DatagramSocket) {
						((DatagramSocket)x).close();
					} else {
						Log.d(TAG,"cannot close: "+x);
						throw new RuntimeException("cannot close "+x);
					}
				} catch (Throwable e) {
					Log.e(TAG,"Closer failed");
				}
			}
		}
	}
}