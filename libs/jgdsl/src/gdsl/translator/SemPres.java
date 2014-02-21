package gdsl.translator;

/**
 * This enum represents different levels of semantics preservation during the translation of basic block.
 * 
 * @author Julian Kranz
 */
public enum SemPres {
  EVERYWHERE(0), BLOCK(1), CONTEXT(2);
  
  private int id;
  
  public int getId () {
    return id;
  }
  
  private SemPres (int id) {
    this.id = id;
  }
}
