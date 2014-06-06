/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bit Pat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.BitPat#getBitpat <em>Bitpat</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getBitPat()
 * @model
 * @generated
 */
public interface BitPat extends DecodePat
{
  /**
   * Returns the value of the '<em><b>Bitpat</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bitpat</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bitpat</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getBitPat_Bitpat()
   * @model unique="false"
   * @generated
   */
  EList<String> getBitpat();

} // BitPat
