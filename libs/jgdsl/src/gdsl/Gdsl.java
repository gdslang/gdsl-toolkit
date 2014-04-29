package gdsl;

import java.nio.ByteBuffer;

/**
 * The Gdsl class represents the main interface to Gdsl. The
 * user needs to perform the following steps:
 * 
 * 1. Create a new instance of the Gdsl class;
 * 2. (Optionally) Request the list of available frontends;
 * 3. Choose a frontend (for example using an architecture binder);
 * 4. Initialize the frontend;
 * 5. (Optionally) configure the frontend;
 * 6. Use the Decoder and Translator classes for the decoding and
 * semantic translation of instructions.
 * 
 * @author Julian Kranz
 */
public class Gdsl implements IReferable {
  private Frontend frontend;

  private long gdslStatePtr = 0;
  private ByteBuffer buffer;
  
  private long heapRevision = 0;
  
  public final ReferenceManager heapManager = new ReferenceManager(this);
  
  public ByteBuffer getBuffer () {
    return buffer;
  }
  
  public long getHeapRevision () {
    return heapRevision;
  }

  /**
   * Get the address of the associated native Gdsl state object
   * 
   * @return the value of the pointer
   */
  public long getGdslStatePtr () {
    if (gdslStatePtr == 0)
      throw new ResourceUnavailableException("Gdsl Frontend not initialized");
    return gdslStatePtr;
  }

  /**
   * Get the associated {@link Frontend} object.
   * 
   * @return the {@link Frontend} object
   */
  public Frontend getFrontend () {
    if (frontend == null)
      throw new RuntimeException("Frontend not set");
    return frontend;
  }

  /**
   * Get the address of the associated native frontend object
   * 
   * @return the value of the pointer
   */
  public long getFrontendPtr () {
    return getFrontend().getPointer();
  }

  /**
   * Get the list of available frontends; in case the list is
   * queried the first time and has not been set by the constructor,
   * the environment variable "GDSL_FRONTENDS" is used to search for
   * frontends.
   * 
   * @return the list of frontends
   */
  public static Frontend[] getFrontends () {
    return getFrontendsNative();
  }
  
  public static Frontend[] getFrontends (String base) {
    return getFrontendsNativeWithBase(base);
  }
  
  private static native ListFrontend[] getFrontendsNative ();
  private static native ListFrontend[] getFrontendsNativeWithBase (String base);

  static {
    System.loadLibrary("jgdsl");
  }
  
  /**
   * Construct the Gdsl object
   */
  public Gdsl (Frontend frontend) {
    this.frontend = frontend;
    this.frontend.referenceManager.ref();
    gdslStatePtr = init(getFrontendPtr());
  }

//  /**
//   * Construct the Gdsl object using a given path to search
//   * for frontends
//   * 
//   * @param base the path to search frontends in
//   */
//  public Gdsl (String base) {
//    System.loadLibrary("jgdsl");
//
//   throw new RuntimeException();
////    frontends = getFrontendsNativeWithBase(base);
//  }

//  /**
//   * Associate the Gdsl object with a {@link Frontend} object; the frontend.
//   * The method should only be called once per Gdsl object.
//   * 
//   * @param frontend the frontend to associate with
//   */
//  public void setFrontend (Frontend frontend) {
//    if (this.frontend != null)
//      throw new RuntimeException("Already set");
////    boolean found = false;
////    for (Frontend f : frontends)
////      if (f.identifies(frontend)) {
////        found = true;
////        break;
////      }
////    if (!found)
////      throw new RuntimeException("Invalid frontend");
//    this.frontend = frontend;
//  }
  
  
//  /**
//   * Associate the Gdsl object with a {@link Frontend} object; the frontend is
//   * constructed from the given name. The name is also used for the name of
//   * the Gdsl library to load; therefore, libgdsl-name needs to be locatable by dlopen().
//   * 
//   * @param name the name of the frontend
//   */
//  public void setFrontend(String name) {
//    long frontendPtr = getFrontendPtrByLibName(name);
//    this.frontend = new Frontend(name, "");
//  }
//
//  /**
//   * Initialize the associated frontend; this creates a native gdsl state
//   * object. The method should only be called once per Gdsl object.
//   */
//  public void initFrontend () {
//    if (gdslStatePtr == 0)
//    else
//      throw new RuntimeException("Already initialized");
//  }

  /**
   * Set the code input stream for Gdsl. The data is shared between
   * Java and Gdsl using a directly allocated {@link ByteBuffer} object
   * which can be accessed efficiently from native code.
   * 
   * @param buffer the directly allocated {@link ByteBuffer} object
   * @param offset an offset into the byte buffer; Gdsl will start to decode
   *          from that offset.
   * @param base the base pointer to use for relative addresses
   */
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

  /**
   * Decode one instruction and return the pointer to the native object.
   * 
   * @return the pointer to the native instruction object
   */
  public long decodeOne () {
    if (frontend.isConfigured())
      return decodeOneWithConfig(getFrontendPtr(), getGdslStatePtr(), frontend.getConfig().vector());
    else
      return decodeOne(getFrontendPtr(), getGdslStatePtr());
  }

  private native long decodeOne (long frontendPtr, long gdslStatePtr);

  private native long decodeOneWithConfig (long frontendPtr, long gdslStatePtr, long decodeConfig);

  /**
   * Get the current offset into the input stream; this offset can be used to
   * calculate the size of decoded instructions.
   * 
   * @return the offset
   */
  public long getIpOffset () {
    return getIpOffset(getFrontend().getPointer(), getGdslStatePtr());
  }

  /**
   * Reset the Gdsl heap; this can be used to perform primitive garbarge collection
   * for Gdsl programs.
   * 
   * Caution: All native pointers into the Gdsl heap are invalidated by this operation.
   */
  public void resetHeap () {
    resetHeap(getFrontend().getPointer(), getGdslStatePtr());
    heapRevision++;
  }

//  /**
//   * Todo: Adapt doc
//   * 
//   * Cleanup the complete state on the native side. This frees all natively allocated data.
//   * After this operation the Gdsl object is in the same state as it was after calling the
//   * constructor.
//   */
//  public void destroyFrontend () {
//    destroy(getFrontend().getPointer(), getGdslStatePtr());
//    gdslStatePtr = 0;
//    frontend = null;
//  }
  
  @Override protected void finalize () throws Throwable {
    /*
     * Todo: finally
     */
    destroy(getFrontend().getPointer(), getGdslStatePtr());
    getFrontend().referenceManager.unref();
    gdslStatePtr = 0;
    super.finalize();
  }
  
  @Override public void free () {
   if(gdslStatePtr != 0)
     resetHeap();
  }
  
  public HeapUseIndicator heapUseIndicator() {
    return new HeapUseIndicator(this);
  }

  private native long init (long frontendPtr);

  private native void setCode (long frontendPtr, long gdslStatePtr, ByteBuffer buffer, long offset, long base);

  private native long getIpOffset (long frontendPtr, long gdslStatePtr);

  private native void resetHeap (long frontendPtr, long gdslStatePtr);

  private native void destroy (long frontendPtr, long gdslStatePtr);
}
