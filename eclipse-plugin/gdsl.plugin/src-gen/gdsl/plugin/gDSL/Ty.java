/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getValue <em>Value</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getDecl <em>Decl</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getType <em>Type</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getTyBind <em>Ty Bind</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getElements <em>Elements</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getParam <em>Param</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getResType <em>Res Type</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getR <em>R</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getIn <em>In</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getTy()
 * @model
 * @generated
 */
public interface Ty extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Ty#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Decl</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decl</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl</em>' reference.
   * @see #setDecl(DeclType)
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_Decl()
   * @model
   * @generated
   */
  DeclType getDecl();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Ty#getDecl <em>Decl</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl</em>' reference.
   * @see #getDecl()
   * @generated
   */
  void setDecl(DeclType value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Ty#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Ty Bind</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.TyBind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ty Bind</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ty Bind</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_TyBind()
   * @model containment="true"
   * @generated
   */
  EList<TyBind> getTyBind();

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.TyElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_Elements()
   * @model containment="true"
   * @generated
   */
  EList<TyElement> getElements();

  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.Ty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_Param()
   * @model containment="true"
   * @generated
   */
  EList<Ty> getParam();

  /**
   * Returns the value of the '<em><b>Res Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Res Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Res Type</em>' containment reference.
   * @see #setResType(Ty)
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_ResType()
   * @model containment="true"
   * @generated
   */
  Ty getResType();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Ty#getResType <em>Res Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Res Type</em>' containment reference.
   * @see #getResType()
   * @generated
   */
  void setResType(Ty value);

  /**
   * Returns the value of the '<em><b>R</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>R</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>R</em>' containment reference.
   * @see #setR(Ty)
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_R()
   * @model containment="true"
   * @generated
   */
  Ty getR();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Ty#getR <em>R</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>R</em>' containment reference.
   * @see #getR()
   * @generated
   */
  void setR(Ty value);

  /**
   * Returns the value of the '<em><b>In</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In</em>' containment reference.
   * @see #setIn(Ty)
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_In()
   * @model containment="true"
   * @generated
   */
  Ty getIn();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Ty#getIn <em>In</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>In</em>' containment reference.
   * @see #getIn()
   * @generated
   */
  void setIn(Ty value);

  /**
   * Returns the value of the '<em><b>Out</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Out</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out</em>' containment reference.
   * @see #setOut(Ty)
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_Out()
   * @model containment="true"
   * @generated
   */
  Ty getOut();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Ty#getOut <em>Out</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Out</em>' containment reference.
   * @see #getOut()
   * @generated
   */
  void setOut(Ty value);

} // Ty
