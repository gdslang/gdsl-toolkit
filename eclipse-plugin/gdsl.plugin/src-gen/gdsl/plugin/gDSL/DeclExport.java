/**
 */
package gdsl.plugin.gDSL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decl Export</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.DeclExport#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.DeclExport#getTyVars <em>Ty Vars</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.DeclExport#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getDeclExport()
 * @model
 * @generated
 */
public interface DeclExport extends Decl
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' reference.
   * @see #setName(DeclVal)
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclExport_Name()
   * @model
   * @generated
   */
  DeclVal getName();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.DeclExport#getName <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' reference.
   * @see #getName()
   * @generated
   */
  void setName(DeclVal value);

  /**
   * Returns the value of the '<em><b>Ty Vars</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ty Vars</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ty Vars</em>' containment reference.
   * @see #setTyVars(TyVars)
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclExport_TyVars()
   * @model containment="true"
   * @generated
   */
  TyVars getTyVars();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.DeclExport#getTyVars <em>Ty Vars</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ty Vars</em>' containment reference.
   * @see #getTyVars()
   * @generated
   */
  void setTyVars(TyVars value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Ty)
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclExport_Type()
   * @model containment="true"
   * @generated
   */
  Ty getType();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.DeclExport#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Ty value);

} // DeclExport
