import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-android-liveness' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const AndroidLiveness = NativeModules.AndroidLiveness
  ? NativeModules.AndroidLiveness
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function multiply(a: number, b: number): Promise<number> {
  return AndroidLiveness.multiply(a, b);
}

export const sdkVersion = () => {
  console.info('LivenessModule', JSON.stringify(NativeModules));
  return NativeModules.LivenessModule?.sdkVersion();
};

export const asd = () => {
  return NativeModules.LivenessModule.initSDKByLicense('Indonesia', false);
};
