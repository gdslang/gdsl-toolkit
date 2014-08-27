/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.Type#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Type#getTyVars <em>Ty Vars</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Type#getConDecl <em>Con Decl</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Type#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getType()
 * @model
 * @generated
 */
public interface Type extends Decl
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see gdsl.plugin.gDSL.GDSLPackage#getType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Type#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see gdsl.plugin.gDSL.GDSLPackage#getType_TyVars()
   * @model containment="true"
   * @generated
   */
  TyVars getTyVars();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Type#getTyVars <em>Ty Vars</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ty Vars</em>' containment reference.
   * @see #getTyVars()
   * @generated
   */
  void setTyVars(TyVars value);

  /**
   * Returns the value of the '<em><b>Con Decl</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.ConDecl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Con Decl</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Con Decl</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getType_ConDecl()
   * @model containment="true"
   * @generated
   */
  EList<ConDecl> getConDecl();

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Ty)
   * @see gdsl.plugin.gDSL.GDSLPackage#getType_Value()
   * @model containment="true"
   * @generated
   */
  Ty getValue();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Type#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Ty value);

} // Type
