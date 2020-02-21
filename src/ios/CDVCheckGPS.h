#import <Cordova/CDV.h>

@interface CheckGPS: CDVPlugin
    - (void)check:(CDVInvokedUrlCommand*)command;
	- (void)locationServiceCheck:(CDVInvokedUrlCommand*)command;
    - (void)locationPermissionCheck:(CDVInvokedUrlCommand*)command;
    - (void)locationPermissionAsk:(CDVInvokedUrlCommand*)command;
@end
