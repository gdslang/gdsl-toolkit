/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Closed Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.ClosedExp#getIfCaseExp <em>If Case Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.ClosedExp#getThenCaseExp <em>Then Case Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.ClosedExp#getElseCaseExp <em>Else Case Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.ClosedExp#getDoExp <em>Do Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getClosedExp()
 * @model
 * @generated
 */
public interface ClosedExp extends CaseExp
{
  /**
   * Returns the value of the '<em><b>If Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If Case Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If Case Exp</em>' containment reference.
   * @see #setIfCaseExp(CaseExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getClosedExp_IfCaseExp()
   * @model containment="true"
   * @generated
   */
  CaseExp getIfCaseExp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.ClosedExp#getIfCaseExp <em>If Case Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If Case Exp</em>' containment reference.
   * @see #getIfCaseExp()
   * @generated
   */
  void setIfCaseExp(CaseExp value);

  /**
   * Returns the value of the '<em><b>Then Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Case Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Case Exp</em>' containment reference.
   * @see #setThenCaseExp(CaseExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getClosedExp_ThenCaseExp()
   * @model containment="true"
   * @generated
   */
  CaseExp getThenCaseExp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.ClosedExp#getThenCaseExp <em>Then Case Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Case Exp</em>' containment reference.
   * @see #getThenCaseExp()
   * @generated
   */
  void setThenCaseExp(CaseExp value);

  /**
   * Returns the value of the '<em><b>Else Case Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Case Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Case Exp</em>' containment reference.
   * @see #setElseCaseExp(CaseExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getClosedExp_ElseCaseExp()
   * @model containment="true"
   * @generated
   */
  CaseExp getElseCaseExp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.ClosedExp#getElseCaseExp <em>Else Case Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Case Exp</em>' containment reference.
   * @see #getElseCaseExp()
   * @generated
   */
  void setElseCaseExp(CaseExp value);

  /**
   * Returns the value of the '<em><b>Do Exp</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.MonadicExp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Do Exp</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Do Exp</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getClosedExp_DoExp()
   * @model containment="true"
   * @generated
   */
  EList<MonadicExp> getDoExp();

} // ClosedExp
