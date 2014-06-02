/**
 */
package gdsl.plugin.gDSL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gdsl.plugin.gDSL.GDSLPackage
 * @generated
 */
public interface GDSLFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GDSLFactory eINSTANCE = gdsl.plugin.gDSL.impl.GDSLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Decl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decl</em>'.
   * @generated
   */
  Decl createDecl();

  /**
   * Returns a new object of class '<em>Decl Granularity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decl Granularity</em>'.
   * @generated
   */
  DeclGranularity createDeclGranularity();

  /**
   * Returns a new object of class '<em>Decl Export</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decl Export</em>'.
   * @generated
   */
  DeclExport createDeclExport();

  /**
   * Returns a new object of class '<em>Decl Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decl Type</em>'.
   * @generated
   */
  DeclType createDeclType();

  /**
   * Returns a new object of class '<em>Decl Val</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decl Val</em>'.
   * @generated
   */
  DeclVal createDeclVal();

  /**
   * Returns a new object of class '<em>Export</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Export</em>'.
   * @generated
   */
  Export createExport();

  /**
   * Returns a new object of class '<em>Con Decls</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Con Decls</em>'.
   * @generated
   */
  ConDecls createConDecls();

  /**
   * Returns a new object of class '<em>Con Decl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Con Decl</em>'.
   * @generated
   */
  ConDecl createConDecl();

  /**
   * Returns a new object of class '<em>Ty</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ty</em>'.
   * @generated
   */
  Ty createTy();

  /**
   * Returns a new object of class '<em>Ty Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ty Element</em>'.
   * @generated
   */
  TyElement createTyElement();

  /**
   * Returns a new object of class '<em>Ty Bind</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ty Bind</em>'.
   * @generated
   */
  TyBind createTyBind();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GDSLPackage getGDSLPackage();

} //GDSLFactory