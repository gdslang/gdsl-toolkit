/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MExp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.MExp#getApplyexps <em>Applyexps</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getMExp()
 * @model
 * @generated
 */
public interface MExp extends EObject
{
  /**
   * Returns the value of the '<em><b>Applyexps</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.ApplyExp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applyexps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applyexps</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getMExp_Applyexps()
   * @model containment="true"
   * @generated
   */
  EList<ApplyExp> getApplyexps();

} // MExp
