/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Apply Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.ApplyExp#getAtomicExp <em>Atomic Exp</em>}</li>
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
   * Returns the value of the '<em><b>Atomic Exp</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.AtomicExp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Atomic Exp</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atomic Exp</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getApplyExp_AtomicExp()
   * @model containment="true"
   * @generated
   */
  EList<AtomicExp> getAtomicExp();

} // ApplyExp
