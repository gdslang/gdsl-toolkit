/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gdsl.plugin.gDSL.AtomicExp#getId <em>Id</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.AtomicExp#getFields <em>Fields</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.AtomicExp#getExpr <em>Expr</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.AtomicExp#getExps <em>Exps</em>}</li>
 *   <li>{@link gdsl.plugin.gDSL.AtomicExp#getValDecl <em>Val Decl</em>}</li>
 * </ul>
 * </p>
 *
 * @see gdsl.plugin.gDSL.GDSLPackage#getAtomicExp()
 * @model
 * @generated
 */
public interface AtomicExp extends ApplyExp
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getAtomicExp_Id()
   * @model unique="false"
   * @generated
   */
  EList<String> getId();

  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.Field}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getAtomicExp_Fields()
   * @model containment="true"
   * @generated
   */
  EList<Field> getFields();

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Exp)
   * @see gdsl.plugin.gDSL.GDSLPackage#getAtomicExp_Expr()
   * @model containment="true"
   * @generated
   */
  Exp getExpr();

  /**
   * Sets the value of the '{@link gdsl.plugin.gDSL.AtomicExp#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Exp value);

  /**
   * Returns the value of the '<em><b>Exps</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.Exp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exps</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getAtomicExp_Exps()
   * @model containment="true"
   * @generated
   */
  EList<Exp> getExps();

  /**
   * Returns the value of the '<em><b>Val Decl</b></em>' containment reference list.
   * The list contents are of type {@link gdsl.plugin.gDSL.ValueDecl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val Decl</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val Decl</em>' containment reference list.
   * @see gdsl.plugin.gDSL.GDSLPackage#getAtomicExp_ValDecl()
   * @model containment="true"
   * @generated
   */
  EList<ValueDecl> getValDecl();

} // AtomicExp
