//
//  ExtractZipFilePlugin.h
//
//  Created by Shaun Rowe on 10/05/2012.
//  Copyright (c) 2012 Pobl Creative Cyf. All rights reserved.
//

#import <Cordova/CDVPlugin.h>
#import "SSZipArchive.h"

@interface ExtractZipFile : CDVPlugin {}

- (void)extract:(CDVInvokedUrlCommand *)command;

@end
