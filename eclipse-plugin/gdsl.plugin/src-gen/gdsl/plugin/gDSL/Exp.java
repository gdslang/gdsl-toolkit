/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.Exp#getCaseExp <em>Case Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Exp#getMid <em>Mid</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getExp()
 * @model
 * @generated
 */
public interface Exp extends EObject
{
  /**
   * Returns the value of the '<em><b>Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Case Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Case Exp</em>' containment reference.
   * @see #setCaseExp(CaseExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getExp_CaseExp()
   * @model containment="true"
   * @generated
   */
  CaseExp getCaseExp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Exp#getCaseExp <em>Case Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Case Exp</em>' containment reference.
   * @see #getCaseExp()
   * @generated
   */
  void setCaseExp(CaseExp value);

  /**
   * Returns the value of the '<em><b>Mid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mid</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mid</em>' attribute.
   * @see #setMid(String)
   * @see gdsl.plugin.gDSL.GDSLPackage#getExp_Mid()
   * @model
   * @generated
   */
  String getMid();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Exp#getMid <em>Mid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mid</em>' attribute.
   * @see #getMid()
   * @generated
   */
  void setMid(String value);

} // Exp
