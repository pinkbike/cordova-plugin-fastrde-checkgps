package de.fastr.phonegap.plugins;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.location.LocationManager;
import android.content.Context;

import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.Manifest.permission;
import android.content.pm.PackageManager;


public class CheckGPS extends CordovaPlugin {
	private static final int PERMISSION_REQUEST_CODE = 200;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("check")) {
			this.locationServiceCheck(callbackContext);
			return true;
		} else if (action.equals("locationPermissionCheck")) {
			this.locationPermissionCheck(callbackContext);
			return true;
		} else if (action.equals("locationPermissionAsk")) {
			this.locationPermissionAsk(callbackContext);
			return true;
		}
		return false;
	}


	private void locationServiceCheck(CallbackContext callbackContext){
		Context context = this.cordova.getActivity().getApplicationContext();

		final LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			callbackContext.success();
		} else {
			callbackContext.error(0);
		}
	}


	private void locationPermissionCheck(CallbackContext callbackContext) {
		Context context = this.cordova.getActivity().getApplicationContext();

		boolean permissionAccessCoarseLocationApproved =
			ActivityCompat.checkSelfPermission(context, permission.ACCESS_COARSE_LOCATION)
				== PackageManager.PERMISSION_GRANTED;

		if (permissionAccessCoarseLocationApproved) {
			callbackContext.success();
		} else {
			callbackContext.error(0);
		}
	}
	
	private void locationPermissionAsk(CallbackContext callbackContext) {
		String[] permissions = new String[] {
			Manifest.permission.ACCESS_COARSE_LOCATION,
			Manifest.permission.ACCESS_FINE_LOCATION,
			Manifest.permission.ACCESS_BACKGROUND_LOCATION
		};
		cordova.requestPermissions(this, PERMISSION_REQUEST_CODE, permissions);
		callbackContext.success();
	}
}
