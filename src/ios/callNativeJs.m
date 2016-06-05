/********* callNativeJs.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import "OtherPage.h"
@interface callNativeJs : CDVPlugin {
    // Member variables go here.
}

- (void)coolMethod:(CDVInvokedUrlCommand*)command;
@end

@implementation callNativeJs

- (void)coolMethod:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo = [command.arguments objectAtIndex:0];
    
    if (echo != nil && [echo length] > 0) {
        NSArray *array = [echo componentsSeparatedByString:@"#"];
        NSString *action = array[2];
        NSString *param  = array[3];
        if([action isEqualToString:@"jump"]){
            [self.viewController presentViewController:[OtherPage new] animated:YES completion:nil];
        }
        
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:echo];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
