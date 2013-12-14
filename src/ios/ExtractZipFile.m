//
//  ExtractZipFilePlugin.m
//
//  Created by Shaun Rowe on 10/05/2012.
//  Copyright (c) 2012 Pobl Creative Cyf. All rights reserved.
//

#import "ExtractZipFile.h"
#import "SSZipArchive.h"

@implementation ExtractZipFile

- (void)extract:(CDVInvokedUrlCommand *)command
{
    NSString *file = [command.arguments objectAtIndex:0];
    NSString *destination = [command.arguments objectAtIndex:1];

    CDVPluginResult *result;
  
    if([SSZipArchive unzipFileAtPath:file toDestination:destination delegate:nil]) {
        result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:[destination stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding]];
        [self writeJavascript:[result toSuccessCallbackString:command.callbackId]];
    } else {
        result = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:[@"Could not extract archive" stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding]];
        [self writeJavascript:[result toErrorCallbackString:command.callbackId]];
    }
}

@end