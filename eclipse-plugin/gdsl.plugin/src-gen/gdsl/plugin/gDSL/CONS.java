/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CONS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.CONS#getConName <em>Con Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getCONS()
 * @model
 * @generated
 */
public interface CONS extends EObject
{
  /**
   * Returns the value of the '<em><b>Con Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Con Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Con Name</em>' attribute.
   * @see #setConName(String)
   * @see gdsl.plugin.gDSL.GDSLPackage#getCONS_ConName()
   * @model
   * @generated
   */
  String getConName();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.CONS#getConName <em>Con Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Con Name</em>' attribute.
   * @see #getConName()
   * @generated
   */
  void setConName(String value);

} // CONS
