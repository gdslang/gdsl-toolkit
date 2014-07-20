/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decl Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.DeclType#getConDecl <em>Con Decl</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.DeclType#getValue <em>Value</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.DeclType#getAttr <em>Attr</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getDeclType()
 * @model
 * @generated
 */
public interface DeclType extends Decl
{
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
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclType_ConDecl()
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
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclType_Value()
   * @model containment="true"
   * @generated
   */
  Ty getValue();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.DeclType#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Ty value);

  /**
   * Returns the value of the '<em><b>Attr</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attr</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclType_Attr()
   * @model unique="false"
   * @generated
   */
  EList<String> getAttr();

} // DeclType
