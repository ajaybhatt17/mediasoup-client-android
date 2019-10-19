package org.mediasoup.droid;

public class Device {

  private long mNativeDevice;

  public Device() {
    mNativeDevice = nativeNewDevice();
  }

  public void dispose() {
    nativeFreeDevice(mNativeDevice);
    mNativeDevice = 0;
  }

  public void load(String routerRtpCapabilities) {
    nativeLoad(mNativeDevice, routerRtpCapabilities);
  }

  public boolean isLoaded() {
    return nativeIsLoaded(mNativeDevice);
  }

  public String GetRtpCapabilities() {
    return nativeGetRtpCapabilities(mNativeDevice);
  }

  public boolean canProduce(String kind) {
    return nativeCanProduce(mNativeDevice, kind);
  }

  public SendTransport createSendTransport(
      SendTransport.Listener listener,
      String id,
      String iceParameters,
      String iceCandidates,
      String dtlsParameters) {
    return nativeCreateSendTransport(
        mNativeDevice, listener, id, iceParameters, iceCandidates, dtlsParameters);
  }

  public RecvTransport createRecvTransport(
      RecvTransport.Listener listener,
      String id,
      String iceParameters,
      String iceCandidates,
      String dtlsParameters) {
    return nativeCreateRecvTransport(
        mNativeDevice, listener, id, iceParameters, iceCandidates, dtlsParameters);
  }

  private static native long nativeNewDevice();

  private static native void nativeFreeDevice(long device);

  private static native void nativeLoad(long device, String routerRtpCapabilities);

  private static native boolean nativeIsLoaded(long device);

  private static native String nativeGetRtpCapabilities(long device);

  private static native boolean nativeCanProduce(long device, String kind);

  private static native SendTransport nativeCreateSendTransport(
      long device,
      SendTransport.Listener listener,
      String id,
      String iceParameters,
      String iceCandidates,
      String dtlsParameters);

  private static native RecvTransport nativeCreateRecvTransport(
      long device,
      RecvTransport.Listener listener,
      String id,
      String iceParameters,
      String iceCandidates,
      String dtlsParameters);
}