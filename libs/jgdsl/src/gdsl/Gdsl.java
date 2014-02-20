package gdsl;

import java.nio.ByteBuffer;


public class Gdsl {
  private final Frontend[] frontends;

  private Frontend frontend;

  private long gdslStatePtr = 0;
  private ByteBuffer buffer;

  public long getGdslStatePtr () {
    if (gdslStatePtr == 0)
      throw new RuntimeException("Gdsl Frontend not initialized");
    return gdslStatePtr;
  }

  public Frontend getFrontend () {
    if (frontend == null)
      throw new RuntimeException("Frontend not set");
    return frontend;
  }
  
  public long getFrontendPtr() {
    return getFrontend().getPointer();
  }

  public Frontend[] getFrontends () {
    return frontends;
  }

  public Gdsl () {
    System.loadLibrary("jgdsl");

    frontends = getFrontendsNative();
  }

  private native Frontend[] getFrontendsNative ();

  public Gdsl (String base) {
    System.loadLibrary("jgdsl");

    frontends = getFrontendsNativeWithBase(base);
  }

  private native Frontend[] getFrontendsNativeWithBase (String base);

  public void setFrontend (Frontend frontend) {
    boolean found = false;
    for (Frontend f : frontends)
      if (f.identifies(frontend)) {
        found = true;
        break;
      }
    if (!found)
      throw new RuntimeException("Invalid frontend");
    long frontendPtr = getFrontendPtr(frontend);
    frontend.setPointer(frontendPtr);
    this.frontend = frontend;
  }

  public void initFrontend () {
    if (gdslStatePtr == 0)
      gdslStatePtr = init(getFrontendPtr());
  }

  public void setCode (ByteBuffer buffer, long offset, long base) {
    if (buffer == null)
      throw new NullPointerException();
    if (!buffer.isDirect())
      throw new RuntimeException("Buffer must be direct");
    if (offset < 0 || base < 0)
      throw new IllegalArgumentException();
    this.buffer = buffer;
    setCode(getFrontendPtr(), getGdslStatePtr(), buffer, offset, base);
  }

  public long decodeOne () {
    if (frontend.isConfigured())
      return decodeOneWithConfig(getFrontendPtr(), getGdslStatePtr(), frontend.getConfig().vector());
    else
      return decodeOne(getFrontendPtr(), getGdslStatePtr());
  }

  private native long decodeOne (long frontendPtr, long gdslStatePtr);

  private native long decodeOneWithConfig (long frontendPtr, long gdslStatePtr, long decodeConfig);

  public long getIpOffset () {
    return getIpOffset(getFrontend().getPointer(), getGdslStatePtr());
  }

  public void resetHeap () {
    resetHeap(getFrontend().getPointer(), getGdslStatePtr());
  }

  public void destroyFrontend () {
    destroyFrontend(getFrontend().getPointer(), getGdslStatePtr());
    gdslStatePtr = 0;
    frontend = null;
  }

  private native long getFrontendPtr (Frontend frontend);

  private native long init (long frontendPtr);

  private native void setCode (long frontendPtr, long gdslStatePtr, ByteBuffer buffer, long offset, long base);

  private native long getIpOffset (long frontendPtr, long gdslStatePtr);

  private native void resetHeap (long frontendPtr, long gdslStatePtr);

  private native void destroyFrontend (long frontendPtr, long gdslStatePtr);
}
