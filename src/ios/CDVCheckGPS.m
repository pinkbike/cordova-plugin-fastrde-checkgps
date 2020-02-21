#import "CDVCheckGPS.h"
#import <CoreLocation/CoreLocation.h>
@implementation CheckGPS
- (void)check:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
	if([CLLocationManager locationServicesEnabled] &&
  	 [CLLocationManager authorizationStatus] != kCLAuthorizationStatusDenied) {
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
	} else {
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
	}
  [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}
- (void)locationServiceCheck:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    if ([CLLocationManager locationServicesEnabled]) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}
- (void)locationPermissionCheck:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    if ([CLLocationManager locationServicesEnabled] && [CLLocationManager authorizationStatus] != kCLAuthorizationStatusDenied) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}
- (void)locationPermissionAsk:(CDVInvokedUrlCommand*)command
{
    CLLocationManager *locationManager = [[CLLocationManager alloc] init];
    [locationManager requestWhenInUseAuthorization];
    [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId];
}
@end
