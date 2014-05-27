/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Con Decls</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.ConDecls#getConDecls <em>Con Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getConDecls()
 * @model
 * @generated
 */
public interface ConDecls extends EObject
{
  /**
   * Returns the value of the '<em><b>Con Decls</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.ConDecl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Con Decls</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Con Decls</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getConDecls_ConDecls()
   * @model containment="true"
   * @generated
   */
  EList<ConDecl> getConDecls();

} // ConDecls
