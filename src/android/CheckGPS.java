package de.fastr.phonegap.plugins;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.LocationManager;
import android.content.Context;

import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.Manifest.permission;
import android.content.pm.PackageManager;
/*
 * thx to http://stackoverflow.com/questions/843675/how-do-i-find-out-if-the-gps-of-an-android-device-is-enabled
 */
public class CheckGPS extends CordovaPlugin{
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("check")){
			this.check(callbackContext);
			return true;
		} else if (action.equals("locationPermissionCheck")){
			this.locationPermissionCheck();
			return true;
		}
		return false;
	}


	private void check(CallbackContext callbackContext){
		Context context = this.cordova.getActivity().getApplicationContext();
		final LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			callbackContext.success();
		} else {
			callbackContext.error(0);
		}
	}


	private void locationPermissionCheck() {
		boolean permissionAccessCoarseLocationApproved =
				ActivityCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION)
						== PackageManager.PERMISSION_GRANTED;

		if (permissionAccessCoarseLocationApproved) {
			boolean backgroundLocationPermissionApproved =
					ActivityCompat.checkSelfPermission(this,
							permission.ACCESS_BACKGROUND_LOCATION)
							== PackageManager.PERMISSION_GRANTED;

			if (backgroundLocationPermissionApproved) {
				// App can access location both in the foreground and in the background.
			} else {
				// App can only access location in the foreground. Display a dialog
				// warning the user that your app must have all-the-time access to
				ActivityCompat.requestPermissions(this, new String[] {
						Manifest.permission.ACCESS_BACKGROUND_LOCATION
				}, 1);
			}
		} else {
			// App doesn't have access to the device's location at all. Make full request
			ActivityCompat.requestPermissions(this, new String[] {
					Manifest.permission.ACCESS_COARSE_LOCATION,
					Manifest.permission.ACCESS_BACKGROUND_LOCATION
			}, 1);
		}
	}
}
