/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getValue <em>Value</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getTyBind <em>Ty Bind</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Ty#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getTy()
 * @model
 * @generated
 */
public interface Ty extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.Ty#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Ty Bind</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.TyBind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ty Bind</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ty Bind</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_TyBind()
   * @model containment="true"
   * @generated
   */
  EList<TyBind> getTyBind();

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.TyElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getTy_Elements()
   * @model containment="true"
   * @generated
   */
  EList<TyElement> getElements();

} // Ty
