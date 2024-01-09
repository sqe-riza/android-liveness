package com.androidliveness;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import aai.liveness.GuardianLivenessDetectionSDK;
import ai.advance.liveness.lib.Market;

@ReactModule(name = AndroidLivenessModule.NAME)
public class AndroidLivenessModule extends ReactContextBaseJavaModule {
  public static final String NAME = "AndroidLiveness";
  private final ReactApplicationContext reactContext;

  public AndroidLivenessModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void multiply(double a, double b, Promise promise) {
    promise.resolve(a * b);
  }

  @ReactMethod
  public void sdkVersion() {
    GuardianLivenessDetectionSDK.init(reactContext, Market.Indonesia);
  }
}
