/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.Model#getDecl <em>Decl</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Decl</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.Decl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decl</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getModel_Decl()
   * @model containment="true"
   * @generated
   */
  EList<Decl> getDecl();

} // Model
