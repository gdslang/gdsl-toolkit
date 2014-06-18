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
  
  /**
   * A reference manager for the GDSL heap; the GDSL heap is automatically
   * reset if the number of references to it drops to zero.
   */
  public final ReferenceManager heapManager = new ReferenceManager(this);
  
  static {
    System.loadLibrary("jgdsl");
  }
 
  /**
   * Get the buffer associated with the GDSL object; it is used as input
   * buffer for the decoder.
   * 
   * @return the respective {@link ByteBuffer} object
   */
  public ByteBuffer getBuffer () {
    return buffer;
  }
  
  /**
   * Get the current revision of the GDSL heap; the revision is incremented
   * whenever the heap is reset. This is allows associated objects to make
   * sure to only access valid memory, i.e. to abort an access to a native
   * GDSL object if the heap revision does not match.
   * 
   * @return the heap revision
   */
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
   * Get the list of available frontends; the environment variable
   * "GDSL_FRONTENDS" is used to search for frontends.
   * 
   * @return the list of frontends
   */
  public static Frontend[] getFrontends () {
    return getFrontendsNative();
  }
  
  /**
   * Get the list of available frontends using a specified path
   * 
   * @param base the path to search the frontends in
   * @return the list of frontends
   */
  public static Frontend[] getFrontends (String base) {
    return getFrontendsNativeWithBase(base);
  }
  
  private static native ListFrontend[] getFrontendsNative ();
  private static native ListFrontend[] getFrontendsNativeWithBase (String base);
  
  /**
   * Construct the Gdsl object
   */
  public Gdsl (Frontend frontend) {
    this.frontend = frontend;
    this.frontend.referenceManager.ref();
    gdslStatePtr = init(getFrontendPtr());
  }

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
  
  /**
   * This function resets the GDSL heap; it is automatically called by the
   * reference manager if the number of references drops to zero. User code
   * may also call this function; a subsequent access to the already freed
   * heap will not cause undefined behaviour since the heap is revisioned.
   * Therefore, calling this function is always safe.
   */
  @Override public void free () {
   if(gdslStatePtr != 0)
     resetHeap();
  }
  
  /**
   * Create a heap usage indicator; such an indicator is usful to make sure
   * that the GDSL heap is always reset as early as possible: If no reference
   * to the heap is ever created, the reference count will never drop to zero
   * (because it stays zero) and therefore the heap will never be reset (it will,
   * however, be freed once the GDSL object itself is destructed). The heap
   * usage indicator will initiate the resetting of the heap when its
   * destructor is called and no other references exist.
   * 
   * @return the heap usage indicator
   */
  public HeapUseIndicator heapUseIndicator() {
    return new HeapUseIndicator(this);
  }

  private native long init (long frontendPtr);

  private native void setCode (long frontendPtr, long gdslStatePtr, ByteBuffer buffer, long offset, long base);

  private native long getIpOffset (long frontendPtr, long gdslStatePtr);

  private native void resetHeap (long frontendPtr, long gdslStatePtr);

  private native void destroy (long frontendPtr, long gdslStatePtr);
}
