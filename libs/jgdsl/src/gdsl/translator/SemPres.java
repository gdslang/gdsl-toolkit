package gdsl.translator;

/**
 * This enum represents different levels of semantics preservation
 * during the translation of basic blocks.
 * 
 * @author Julian Kranz
 */
public enum SemPres {
  /**
   * This item requires the semantics of original machine program
   * and the translated program to equal on the instruction level.
   */
  EVERYWHERE(1),

  /**
   * This item requires the semantics of original machine program
   * and the translated program to equal on the basic block level.
   */
  BLOCK(2),

  /**
   * This item requires the semantics of original machine program
   * and the translated program to equal in the context they occur
   * in only. This means that the translation maps the semantics of
   * the program as a whole correctly whereas parts of translated semantics
   * cannot be mapped to parts of the original machine program.
   */
  CONTEXT(4);

  private int id;

  /**
   * Get the Gdsl id; this id is used to identify the preservation requirement
   * on the Gdsl side.
   * 
   * @return the internal Gdsl id
   */
  public int getId () {
    return id;
  }

  private SemPres (int id) {
    this.id = id;
  }
}
