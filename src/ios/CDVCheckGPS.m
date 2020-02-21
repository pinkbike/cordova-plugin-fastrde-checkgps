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
	check:(CDVInvokedUrlCommand*)command;
}

- (void)locationPermissionCheck:(CDVInvokedUrlCommand*)command
{
	check:(CDVInvokedUrlCommand*)command;
}

- (void)locationPermissionAsk:(CDVInvokedUrlCommand*)command
{
	check:(CDVInvokedUrlCommand*)command;
}
@end