/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decl Export</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.DeclExport#getExports <em>Exports</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getDeclExport()
 * @model
 * @generated
 */
public interface DeclExport extends Decl
{
  /**
   * Returns the value of the '<em><b>Exports</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.Export}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exports</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getDeclExport_Exports()
   * @model containment="true"
   * @generated
   */
  EList<Export> getExports();

} // DeclExport
