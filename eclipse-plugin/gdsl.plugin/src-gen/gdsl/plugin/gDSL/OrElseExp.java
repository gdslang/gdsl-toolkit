/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Else Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.OrElseExp#getLeft <em>Left</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.OrElseExp#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getOrElseExp()
 * @model
 * @generated
 */
public interface OrElseExp extends ClosedExp
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(AndAlsoExp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getOrElseExp_Left()
   * @model containment="true"
   * @generated
   */
  AndAlsoExp getLeft();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.OrElseExp#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(AndAlsoExp value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.AndAlsoExp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getOrElseExp_Right()
   * @model containment="true"
   * @generated
   */
  EList<AndAlsoExp> getRight();

} // OrElseExp
