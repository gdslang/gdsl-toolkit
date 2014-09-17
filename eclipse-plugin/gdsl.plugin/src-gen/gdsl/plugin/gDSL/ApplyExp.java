/**
 */
package gdsl.plugin.gDSL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Apply Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.ApplyExp#getAtomicExp <em>Atomic Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.ApplyExp#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getApplyExp()
 * @model
 * @generated
 */
public interface ApplyExp extends SelectExp
{
  /**
   * Returns the value of the '<em><b>Atomic Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Atomic Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atomic Exp</em>' containment reference.
   * @see #setAtomicExp(AtomicExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getApplyExp_AtomicExp()
   * @model containment="true"
   * @generated
   */
  AtomicExp getAtomicExp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.ApplyExp#getAtomicExp <em>Atomic Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Atomic Exp</em>' containment reference.
   * @see #getAtomicExp()
   * @generated
   */
  void setAtomicExp(AtomicExp value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference.
   * @see #setArgs(Args)
   * @see gdsl.plugin.gDSL.GDSLPackage#getApplyExp_Args()
   * @model containment="true"
   * @generated
   */
  Args getArgs();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.ApplyExp#getArgs <em>Args</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Args</em>' containment reference.
   * @see #getArgs()
   * @generated
   */
  void setArgs(Args value);

} // ApplyExp
