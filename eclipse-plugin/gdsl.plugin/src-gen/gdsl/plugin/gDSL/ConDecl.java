/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Con Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.ConDecl#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.ConDecl#getTy <em>Ty</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getConDecl()
 * @model
 * @generated
 */
public interface ConDecl extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(CONS)
   * @see gdsl.plugin.gDSL.GDSLPackage#getConDecl_Name()
   * @model containment="true"
   * @generated
   */
  CONS getName();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.ConDecl#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(CONS value);

  /**
   * Returns the value of the '<em><b>Ty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ty</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ty</em>' containment reference.
   * @see #setTy(Ty)
   * @see gdsl.plugin.gDSL.GDSLPackage#getConDecl_Ty()
   * @model containment="true"
   * @generated
   */
  Ty getTy();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.ConDecl#getTy <em>Ty</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ty</em>' containment reference.
   * @see #getTy()
   * @generated
   */
  void setTy(Ty value);

} // ConDecl
