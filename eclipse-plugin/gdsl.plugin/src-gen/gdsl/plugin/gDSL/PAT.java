/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.PAT#getId <em>Id</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.PAT#getPat <em>Pat</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getPAT()
 * @model
 * @generated
 */
public interface PAT extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see gdsl.plugin.gDSL.GDSLPackage#getPAT_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.PAT#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Pat</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pat</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pat</em>' containment reference.
   * @see #setPat(PAT)
   * @see gdsl.plugin.gDSL.GDSLPackage#getPAT_Pat()
   * @model containment="true"
   * @generated
   */
  PAT getPat();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.PAT#getPat <em>Pat</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pat</em>' containment reference.
   * @see #getPat()
   * @generated
   */
  void setPat(PAT value);

} // PAT
