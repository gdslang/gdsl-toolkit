/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decl Val</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.DeclVal#getAttr <em>Attr</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getDeclVal()
 * @model
 * @generated
 */
public interface DeclVal extends Decl
{
  /**
   * Returns the value of the '<em><b>Attr</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attr</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclVal_Attr()
   * @model unique="false"
   * @generated
   */
  EList<String> getAttr();

} // DeclVal
