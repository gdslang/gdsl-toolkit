/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decl Val</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.DeclVal#getAttr <em>Attr</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.DeclVal#getExp <em>Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.DeclVal#getDecPat <em>Dec Pat</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.DeclVal#getExps <em>Exps</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getDeclVal()
 * @model
 * @generated
 */
public interface DeclVal extends Decl
{
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
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclVal_Attr()
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
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclVal_Exp()
   * @model containment="true"
   * @generated
   */
  Exp getExp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.DeclVal#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(Exp value);

  /**
   * Returns the value of the '<em><b>Dec Pat</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.DecodePat}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dec Pat</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dec Pat</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclVal_DecPat()
   * @model containment="true"
   * @generated
   */
  EList<DecodePat> getDecPat();

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
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclVal_Exps()
   * @model containment="true"
   * @generated
   */
  EList<Exp> getExps();

} // DeclVal
