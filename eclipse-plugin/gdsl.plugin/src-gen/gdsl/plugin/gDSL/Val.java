/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Val</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.Val#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Val#getAttr <em>Attr</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Val#getExp <em>Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Val#getMid <em>Mid</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Val#getDecPat <em>Dec Pat</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Val#getExps <em>Exps</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getVal()
 * @model
 * @generated
 */
public interface Val extends Decl
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
   * @see gdsl.plugin.gDSL.GDSLPackage#getVal_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Val#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see gdsl.plugin.gDSL.GDSLPackage#getVal_Attr()
   * @model unique="false"
   * @generated
   */
  EList<String> getAttr();

  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(Exp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getVal_Exp()
   * @model containment="true"
   * @generated
   */
  Exp getExp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Val#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(Exp value);

  /**
   * Returns the value of the '<em><b>Mid</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mid</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mid</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getVal_Mid()
   * @model unique="false"
   * @generated
   */
  EList<String> getMid();

  /**
   * Returns the value of the '<em><b>Dec Pat</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dec Pat</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dec Pat</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getVal_DecPat()
   * @model unique="false"
   * @generated
   */
  EList<String> getDecPat();

  /**
   * Returns the value of the '<em><b>Exps</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.Exp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exps</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getVal_Exps()
   * @model containment="true"
   * @generated
   */
  EList<Exp> getExps();

} // Val
