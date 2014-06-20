/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.CaseExp#getClosedExp <em>Closed Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.CaseExp#getCases <em>Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getCaseExp()
 * @model
 * @generated
 */
public interface CaseExp extends EObject
{
  /**
   * Returns the value of the '<em><b>Closed Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Closed Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Closed Exp</em>' containment reference.
   * @see #setClosedExp(ClosedExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getCaseExp_ClosedExp()
   * @model containment="true"
   * @generated
   */
  ClosedExp getClosedExp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.CaseExp#getClosedExp <em>Closed Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Closed Exp</em>' containment reference.
   * @see #getClosedExp()
   * @generated
   */
  void setClosedExp(ClosedExp value);

  /**
   * Returns the value of the '<em><b>Cases</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cases</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cases</em>' containment reference.
   * @see #setCases(Cases)
   * @see gdsl.plugin.gDSL.GDSLPackage#getCaseExp_Cases()
   * @model containment="true"
   * @generated
   */
  Cases getCases();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.CaseExp#getCases <em>Cases</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cases</em>' containment reference.
   * @see #getCases()
   * @generated
   */
  void setCases(Cases value);

} // CaseExp
