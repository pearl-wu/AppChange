#import "AppChange.h"
#import <Cordova/CDV.h>

@implementation AppChange
- (void)check:(CDVInvokedUrlCommand*)command {
    
    CDVPluginResult* pluginResult = nil;
    
    NSString* scheme = [command.arguments objectAtIndex:0];
	    
    if ([[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:scheme]]) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:(true)];
    }
    else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsBool:(false)];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    
}

- (void)inport:(uri)command{
	
}

- (void)toAPPopen:()command{
	CDVPluginResult* pluginResult = nil;
    NSString* urischeme = [command.arguments objectAtIndex:0];
	if ([[UIApplication sharedApplication]canOpenURL:[NSURL URLWithString:@urischeme]]) {
		[[UIApplication sharedApplication]openURL:[NSURL URLWithString:@urischeme]];
	}
}

- (void)goAPPurl:()command{

	CDVPluginResult* pluginResult = nil;
    NSString* appid = [command.arguments objectAtIndex:0];
	NSString *str = [NSString stringWithFormat:@"http://itunes.apple.com/app/id%d",appid];
	[[UIApplication sharedApplication] openURL:[NSURL urlWithString:str]];	
}
@end
