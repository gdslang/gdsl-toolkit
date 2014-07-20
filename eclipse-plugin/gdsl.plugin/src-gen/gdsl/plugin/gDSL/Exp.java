/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.Exp#getName <em>Name</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Exp#getMid <em>Mid</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Exp#getCaseExps <em>Case Exps</em>}</li>
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
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(CaseExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getExp_Name()
   * @model containment="true"
   * @generated
   */
  CaseExp getName();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Exp#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(CaseExp value);

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
   * @see gdsl.plugin.gDSL.GDSLPackage#getExp_Mid()
   * @model unique="false"
   * @generated
   */
  EList<String> getMid();

  /**
   * Returns the value of the '<em><b>Case Exps</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.CaseExp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Case Exps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Case Exps</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getExp_CaseExps()
   * @model containment="true"
   * @generated
   */
  EList<CaseExp> getCaseExps();

} // Exp
