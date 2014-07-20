/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MExp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.MExp#getSign <em>Sign</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.MExp#getMexps <em>Mexps</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getMExp()
 * @model
 * @generated
 */
public interface MExp extends AExp
{
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
   * @see gdsl.plugin.gDSL.GDSLPackage#getMExp_Sign()
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
   * @see gdsl.plugin.gDSL.GDSLPackage#getMExp_Mexps()
   * @model containment="true"
   * @generated
   */
  EList<MExp> getMexps();

} // MExp
