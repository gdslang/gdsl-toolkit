/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cases</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.Cases#getPat <em>Pat</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.Cases#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getCases()
 * @model
 * @generated
 */
public interface Cases extends EObject
{
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
   * @see gdsl.plugin.gDSL.GDSLPackage#getCases_Pat()
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
   * @see gdsl.plugin.gDSL.GDSLPackage#getCases_Exp()
   * @model containment="true"
   * @generated
   */
  EList<Exp> getExp();

} // Cases
