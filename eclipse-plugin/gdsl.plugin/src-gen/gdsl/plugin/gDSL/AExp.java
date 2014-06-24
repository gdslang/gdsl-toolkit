/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AExp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.AExp#getMexp <em>Mexp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.AExp#getSign <em>Sign</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.AExp#getMexps <em>Mexps</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getAExp()
 * @model
 * @generated
 */
public interface AExp extends EObject
{
  /**
   * Returns the value of the '<em><b>Mexp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mexp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mexp</em>' containment reference.
   * @see #setMexp(MExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getAExp_Mexp()
   * @model containment="true"
   * @generated
   */
  MExp getMexp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.AExp#getMexp <em>Mexp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mexp</em>' containment reference.
   * @see #getMexp()
   * @generated
   */
  void setMexp(MExp value);

  /**
   * Returns the value of the '<em><b>Sign</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sign</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sign</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getAExp_Sign()
   * @model unique="false"
   * @generated
   */
  EList<String> getSign();

  /**
   * Returns the value of the '<em><b>Mexps</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.MExp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mexps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mexps</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getAExp_Mexps()
   * @model containment="true"
   * @generated
   */
  EList<MExp> getMexps();

} // AExp
