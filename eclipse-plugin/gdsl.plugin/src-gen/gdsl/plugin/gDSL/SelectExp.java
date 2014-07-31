/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.SelectExp#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.SelectExp#getApplyexps <em>Applyexps</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getSelectExp()
 * @model
 * @generated
 */
public interface SelectExp extends MExp
{
  /**
   * Returns the value of the '<em><b>Symbol</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Symbol</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Symbol</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getSelectExp_Symbol()
   * @model unique="false"
   * @generated
   */
  EList<String> getSymbol();

  /**
   * Returns the value of the '<em><b>Applyexps</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.ApplyExp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applyexps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applyexps</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getSelectExp_Applyexps()
   * @model containment="true"
   * @generated
   */
  EList<ApplyExp> getApplyexps();

} // SelectExp
