/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.CaseExp#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.CaseExp#getClosedExp <em>Closed Exp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.CaseExp#getPat <em>Pat</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.CaseExp#getExp <em>Exp</em>}</li>
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
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see gdsl.plugin.gDSL.GDSLPackage#getCaseExp_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.CaseExp#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * Returns the value of the '<em><b>Pat</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pat</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pat</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getCaseExp_Pat()
   * @model unique="false"
   * @generated
   */
  EList<String> getPat();

  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.Exp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getCaseExp_Exp()
   * @model containment="true"
   * @generated
   */
  EList<Exp> getExp();

} // CaseExp
