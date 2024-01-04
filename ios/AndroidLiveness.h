
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNAndroidLivenessSpec.h"

@interface AndroidLiveness : NSObject <NativeAndroidLivenessSpec>
#else
#import <React/RCTBridgeModule.h>

@interface AndroidLiveness : NSObject <RCTBridgeModule>
#endif

@end
