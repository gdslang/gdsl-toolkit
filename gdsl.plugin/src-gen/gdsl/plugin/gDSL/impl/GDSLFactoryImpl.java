/**
 */
package gdsl.plugin.gDSL.impl;

import gdsl.plugin.gDSL.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GDSLFactoryImpl extends EFactoryImpl implements GDSLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GDSLFactory init()
  {
    try
    {
      GDSLFactory theGDSLFactory = (GDSLFactory)EPackage.Registry.INSTANCE.getEFactory(GDSLPackage.eNS_URI);
      if (theGDSLFactory != null)
      {
        return theGDSLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GDSLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GDSLFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case GDSLPackage.MODEL: return createModel();
      case GDSLPackage.DECL: return createDecl();
      case GDSLPackage.DECL_GRANULARITY: return createDeclGranularity();
      case GDSLPackage.DECL_EXPORT: return createDeclExport();
      case GDSLPackage.DECL_TYPE: return createDeclType();
      case GDSLPackage.DECL_VAL: return createDeclVal();
      case GDSLPackage.EXPORT: return createExport();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Decl createDecl()
  {
    DeclImpl decl = new DeclImpl();
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclGranularity createDeclGranularity()
  {
    DeclGranularityImpl declGranularity = new DeclGranularityImpl();
    return declGranularity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclExport createDeclExport()
  {
    DeclExportImpl declExport = new DeclExportImpl();
    return declExport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclType createDeclType()
  {
    DeclTypeImpl declType = new DeclTypeImpl();
    return declType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclVal createDeclVal()
  {
    DeclValImpl declVal = new DeclValImpl();
    return declVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Export createExport()
  {
    ExportImpl export = new ExportImpl();
    return export;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GDSLPackage getGDSLPackage()
  {
    return (GDSLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GDSLPackage getPackage()
  {
    return GDSLPackage.eINSTANCE;
  }

} //GDSLFactoryImpl
