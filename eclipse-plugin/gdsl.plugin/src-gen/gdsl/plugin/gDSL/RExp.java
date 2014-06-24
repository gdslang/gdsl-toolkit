/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RExp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.RExp#getAexp <em>Aexp</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.RExp#getSym <em>Sym</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.RExp#getAexps <em>Aexps</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getRExp()
 * @model
 * @generated
 */
public interface RExp extends AndAlsoExp
{
  /**
   * Returns the value of the '<em><b>Aexp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aexp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aexp</em>' containment reference.
   * @see #setAexp(AExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getRExp_Aexp()
   * @model containment="true"
   * @generated
   */
  AExp getAexp();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.RExp#getAexp <em>Aexp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Aexp</em>' containment reference.
   * @see #getAexp()
   * @generated
   */
  void setAexp(AExp value);

  /**
   * Returns the value of the '<em><b>Sym</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sym</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sym</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getRExp_Sym()
   * @model unique="false"
   * @generated
   */
  EList<String> getSym();

  /**
   * Returns the value of the '<em><b>Aexps</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.AExp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aexps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aexps</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getRExp_Aexps()
   * @model containment="true"
   * @generated
   */
  EList<AExp> getAexps();

} // RExp
