/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ty Vars</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.TyVars#getAttr <em>Attr</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getTyVars()
 * @model
 * @generated
 */
public interface TyVars extends EObject
{
  /**
   * Returns the value of the '<em><b>Attr</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getTyVars_Attr()
   * @model containment="true"
   * @generated
   */
  EList<Type> getAttr();

} // TyVars
